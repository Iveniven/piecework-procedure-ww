package com.gec.piecework.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Orders implements Serializable {
    /**
     * 订单id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * 公司名称
     *
     * @mbg.generated
     */
    private String company;

    /**
     * 时间
     *
     * @mbg.generated
     */
    private Date time;

    /**
     * 是否出完货
     *
     * @mbg.generated
     */
    private String completion;

    private List<Wire> wireList;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getCompletion() {
        return completion;
    }

    public void setCompletion(String completion) {
        this.completion = completion;
    }

    public List<Wire> getWireList() {
        return wireList;
    }

    public void setWireList(List<Wire> wireList) {
        this.wireList = wireList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", company=").append(company);
        sb.append(", time=").append(time);
        sb.append(", completion=").append(completion);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}