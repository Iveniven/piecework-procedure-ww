package com.gec.piecework.pojo;

import java.io.Serializable;
import java.util.Date;

public class Shipping extends PageReq implements Serializable {
    /**
     * id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * 电线id
     *
     * @mbg.generated
     */
    private Integer idWire;

    /**
     * 数量
     *
     * @mbg.generated
     */
    private Integer wireAmount;

    /**
     * 货物增减
     *
     * @mbg.generated
     */
    private String changes;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private Date creattime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdWire() {
        return idWire;
    }

    public void setIdWire(Integer idWire) {
        this.idWire = idWire;
    }

    public Integer getWireAmount() {
        return wireAmount;
    }

    public void setWireAmount(Integer wireAmount) {
        this.wireAmount = wireAmount;
    }

    public String getChanges() {
        return changes;
    }

    public void setChanges(String changes) {
        this.changes = changes;
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", idWire=").append(idWire);
        sb.append(", wireAmount=").append(wireAmount);
        sb.append(", changes=").append(changes);
        sb.append(", creattime=").append(creattime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}