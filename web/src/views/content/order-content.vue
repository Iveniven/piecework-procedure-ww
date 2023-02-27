<template>

  <div class="table-operations" style="margin-bottom: 16px">
    <a-button type="primary" danger>删除</a-button>
    <a-button type="primary" @click="showModalOfOrders">添加</a-button>
  </div>

  <a-table :data-source="ordersList" :columns="columns" :pagination="pagination" :loading="loading" @change="handleTableChange">

    <!--搜索按钮-->
    <template
        #customFilterDropdown="{ setSelectedKeys, selectedKeys, confirm, clearFilters, column }"
    >
      <div style="padding: 8px">
        <a-input
            :placeholder="`Search ${column.dataIndex}`"
            :value="selectedKeys[0]"
            style="width: 188px; margin-bottom: 8px; display: block"
            @change="e => setSelectedKeys(e.target.value ? [e.target.value] : [])"
            @pressEnter="handleSearch(selectedKeys, confirm, column.dataIndex)"
        />
        <a-button
            type="primary"
            
            style="width: 90px; margin-right: 8px"
            @click="handleSearch(selectedKeys, confirm, column.dataIndex)"
        >
          <template #icon>
            <SearchOutlined/>
          </template>
          Search
        </a-button>
        <a-button style="width: 90px" @click="handleReset(clearFilters)">
          Reset
        </a-button>
      </div>
    </template>

    <template #customFilterIcon="{ filtered }">
      <search-outlined :style="{ color: filtered ? '#108ee9' : undefined }"/>
    </template>

    <template #bodyCell="{ text, column ,record}">

      <!--高亮-->
      <span v-if="searchText && searchedColumn === column.dataIndex">
        <template
            v-for="(fragment, i) in text
            .toString()
            .split(new RegExp(`(?<=${searchText})|(?=${searchText})`, 'i'))"
        >
          <mark
              v-if="fragment.toLowerCase() === searchText.toLowerCase()"
              :key="i"
              class="highlight"
          >
            {{ fragment }}
          </mark>
          <template v-else>{{ fragment }}</template>
        </template>
      </span>

      <!--出货标签-->
      <template v-if="column.key === 'completion'">
            <span>
              <a-tag
                  :color="record.completion === 'false' ? 'processing' : record.completion === 'true' ? 'green' : 'error'">
                      <template #icon>
                        <sync-outlined :spin="true" v-if="record.completion === 'false'"/>
                        <check-circle-outlined v-if="record.completion === 'true'"/>
                        <close-circle-outlined v-if="record.completion === 'pass'"/>
                      </template>
                {{ record.completion === 'false' ? '出货中' : record.completion === 'true' ? '已完成' : '订单取消' }}
              </a-tag>
            </span>
      </template>

      <!--按钮-->
      <template v-if="column.key === 'more'">
        <div>
          <a-space :size="10">
            <a-button type="primary" @click="showModal(record)">查看</a-button>
            <a-button>修改</a-button>
          </a-space>

          <a-modal
              v-model:visible="visible"
              title="订单详情"
              width="100%"
              wrap-class-name="full-modal"
              @ok="handleOk"
          >

            <!--内表格-->
            <a-table
                :columns="columnsForWire"
                :data-source="wiresList"
                :pagination="{ pageSize: 50 }"
                :scroll="{ y: 240 }"
            >
              <template #bodyCell="{ text, column ,record}">

                <!--时间-->
                <template v-if="column.key === 'updatetime'">
                  {{ record.updatetime === 'Invalid Date' ? '' : record.updatetime }}
                </template>


                <!--出货标签-->
                <template v-if="column.key === 'completion'">
                 <span>
                   <a-tag :color="record.remainingamo === 0 ? 'green' : 'processing'">
                                           <template #icon>
                        <sync-outlined :spin="true" v-if="record.remainingamo !== 0"/>
                        <check-circle-outlined v-if="record.remainingamo === 0"/>
                      </template>
                {{ record.remainingamo === 0 ? '已完成' : '剩余数量：' + record.remainingamo + record.unit }}
                   </a-tag>
                 </span>
                </template>


              </template>


            </a-table>


          </a-modal>
        </div>
      </template>

    </template>

  </a-table>

  <a-modal v-model:visible="visibleOfOrders" width="1000px" title="新增订单" @ok="handleOkOfOrders">
    <a-form
        :model="formStateOfOrders"
        name="basic"
        :label-col="{ span: 8 }"
        :wrapper-col="{ span: 16 }"
        autocomplete="off"
        @finish="onFinishOfOrders"
        @finishFailed="onFinishFailedOfOrders"
    >

      <a-form-item
          label="公司名称"
          name="username"
          :rules="[{ required: true, message: '请输入公司名称!' }]"
      >
        <!--        <a-auto-complete-->
        <!--            v-model:value="company"-->
        <!--            :options="options"-->
        <!--            style="width: 200px"-->
        <!--            placeholder=""-->
        <!--            :filter-option="filterOption"-->
        <!--        />-->
      </a-form-item>

    </a-form>
  </a-modal>

</template>

<script lang="ts">
import {defineComponent, onMounted, ref, reactive, toRefs, computed} from 'vue';
import axios from "axios";
import dayjs from "dayjs";
import {
  PlusOutlined,
  LoadingOutlined,
  DownOutlined,
  SearchOutlined,
  CheckCircleOutlined,
  SyncOutlined,
  CloseCircleOutlined,
  ExclamationCircleOutlined,
  ClockCircleOutlined,
  MinusCircleOutlined,
} from '@ant-design/icons-vue';


//自动填充选项
interface Option {
  value: string;
}


export default defineComponent({
  name: "order-content",
  components: {
    DownOutlined,
    LoadingOutlined,
    PlusOutlined,
    SearchOutlined,
    CheckCircleOutlined,
    SyncOutlined,
    CloseCircleOutlined,
    ExclamationCircleOutlined,
    ClockCircleOutlined,
    MinusCircleOutlined,
  },
  setup: function () {
    //搜索区分不区分大小写
    const filterOption = (input: string, option: Option) => {
      return option.value.toUpperCase().indexOf(input.toUpperCase()) >= 0;
    };
    //加载动画
    const loading = ref<boolean>(false);
    //分页组件
    const pagination = ref({
      current: 1,
      pageSize: 14,
      total: 0
    });
    //订单列表
    const ordersList = ref();
    const wiresList = ref();
    const visible = ref<boolean>(false);
    const visibleOfOrders = ref<boolean>(false);
    const formStateOfOrders = reactive<any>({
      company: '',
      wireList: {}
    });

    //表格格式
    const columns = [
      {title: '单号', dataIndex: 'id', key: 'id'},
      {
        title: '公司名称',
        dataIndex: 'company',
        key: 'company',
        customFilterDropdown: true,
        onFilter: (value, record) =>
            record.company.toString().toLowerCase().includes(value.toLowerCase()),
      },
      {title: '日期', dataIndex: 'time', key: 'time'},
      {
        title: '状态', dataIndex: 'completion', key: 'completion',
        filters: [
          {text: '已完成', value: 'true'},
          {text: '出货中', value: 'false'},
        ],
        width: '20%',
        onFilter: (value, record) =>
            console.log(value, record),
      },
      {title: '操作', key: 'more'},
    ];
    const columnsForWire = [
      {title: '备注', dataIndex: 'note', key: 'note'},
      {title: '数量', dataIndex: 'amount', key: 'amount'},
      {title: '单位', dataIndex: 'unit', key: 'unit'},
      {title: '状态', dataIndex: 'completion', key: 'completion'},
      {title: '更新时间', dataIndex: 'updatetime', key: 'updatetime'},
      {title: '创建日期', dataIndex: 'createtime', key: 'createtime'},
    ];
    //查询品牌列表
    const handleQuery = (params: any) => {
      loading.value = true;
      axios.get("piecework/orders/queryAllOrders", {
        params: {
          page: params.page,
          size: params.size,
        }
      }).then((response) => {
        ordersList.value = response.data.data.list;
        for (let i = 0; i < ordersList.value.length; i++) {
          ordersList.value[i].time = dayjs(ordersList.value[i].time).format('YYYY-MM-DD HH:mm:ss')
        }
        pagination.value.current = params.page;
        pagination.value.total = response.data.data.total;
        loading.value = false;
      });

    };
    //打开模态框
    const showModal = (params: any) => {
      params.time = dayjs(params.time).format()
      axios.post("/piecework/wire/queryByIdOrders", params
      ).then((response) => {
        for (let i = 0; i < response.data.data.length; i++) {
          response.data.data[i].createtime = dayjs(response.data.data[i].createtime).format('YYYY-MM-DD HH:mm:ss')
          response.data.data[i].updatetime = dayjs(response.data.data[i].updatetime).format('YYYY-MM-DD HH:mm:ss')
        }
        params.time = dayjs(params.time).format('YYYY-MM-DD HH:mm:ss')
        wiresList.value = response.data.data
        visible.value = true;
      });
    };
    const showModalOfOrders = () => {
      visibleOfOrders.value = true;
    };
    //分页导航触发
    const handleTableChange = (pagination: any) => {
      handleQuery({
        page: pagination.current,
        size: pagination.pageSize
      });
    };
    //模态框确认键
    const handleOk = (e: MouseEvent) => {
      console.log(e);
      visible.value = false;
    };
    const handleOkOfOrders = (e: MouseEvent) => {
      console.log(e);
      visibleOfOrders.value = false;
    };

    const handleSearch = (selectedKeys, confirm, dataIndex) => {
      console.log(selectedKeys)
      console.log(dataIndex)
      confirm();
      state.searchText = selectedKeys[0];
      state.searchedColumn = dataIndex;
    };

    const handleReset = clearFilters => {
      clearFilters({confirm: true});
      state.searchText = '';
    };

    const state = reactive({
      searchText: '',
      searchedColumn: '',
    });

    const onFinishOfOrders = (values: any) => {
      console.log('Success:', values);
    };

    const onFinishFailedOfOrders = (errorInfo: any) => {
      console.log('Failed:', errorInfo);
    };

    onMounted(() => {
      handleQuery({
        page: 1,
        size: pagination.value.pageSize
      });
    });
    return {
      columns,
      loading,
      pagination,
      ordersList,
      visible,
      visibleOfOrders,
      wiresList,
      columnsForWire,
      formStateOfOrders,
      handleReset,
      handleSearch,
      showModal,
      showModalOfOrders,
      handleOk,
      handleOkOfOrders,
      handleQuery,
      handleTableChange,
      filterOption,
      onFinishOfOrders,
      onFinishFailedOfOrders,

      // rowSelection,
      // value: ref(''),
      options: ref<Option[]>([
        {value: 'Burns Bay Road'},
        {value: 'Downing Street'},
        {value: 'Wall Street'},
      ]),
      ...toRefs(state),
    };
  },
});
</script>

<style scoped>
.highlight {
  background-color: rgb(255, 192, 105);
  padding: 0;
}
</style>

<style lang="less">
.full-modal {
  .ant-modal {
    max-width: 100%;
    top: 0;
    padding-bottom: 0;
    margin: 0;
  }

  .ant-modal-content {
    display: flex;
    flex-direction: column;
    height: calc(100vh);
  }

  .ant-modal-body {
    flex: 1;
  }
}

.table-operations {
  margin-bottom: 16px;
}

.table-operations > button {
  margin-right: 8px;
}
</style>