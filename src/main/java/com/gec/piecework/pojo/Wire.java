package com.gec.piecework.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Wire extends PageReq implements Serializable {
    /**
     * id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * 数量
     *
     * @mbg.generated
     */
    private Integer amount;

    /**
     * 单位
     *
     * @mbg.generated
     */
    private String unit;

    /**
     * 单价
     *
     * @mbg.generated
     */
    private BigDecimal price;

    /**
     * 总价
     *
     * @mbg.generated
     */
    private BigDecimal lumpsum;

    /**
     * 单号
     *
     * @mbg.generated
     */
    private Integer ordernum;

    /**
     * 创建日期
     *
     * @mbg.generated
     */
    private Date createtime;

    /**
     * 更新时间
     *
     * @mbg.generated
     */
    private Date updatetime;

    /**
     * 备注
     *
     * @mbg.generated
     */
    private String note;

    /**
     * 剩余条数
     *
     * @mbg.generated
     */
    private Integer remainingamo;

    private List<Shipping> shippingList;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getLumpsum() {
        return lumpsum;
    }

    public void setLumpsum(BigDecimal lumpsum) {
        this.lumpsum = lumpsum;
    }

    public Integer getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(Integer ordernum) {
        this.ordernum = ordernum;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getRemainingamo() {
        return remainingamo;
    }

    public void setRemainingamo(Integer remainingamo) {
        this.remainingamo = remainingamo;
    }

    public List<Shipping> getShippingList() {
        return shippingList;
    }

    public void setShippingList(List<Shipping> shippingList) {
        this.shippingList = shippingList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", amount=").append(amount);
        sb.append(", unit=").append(unit);
        sb.append(", price=").append(price);
        sb.append(", lumpsum=").append(lumpsum);
        sb.append(", ordernum=").append(ordernum);
        sb.append(", createtime=").append(createtime);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", note=").append(note);
        sb.append(", remainingamo=").append(remainingamo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}