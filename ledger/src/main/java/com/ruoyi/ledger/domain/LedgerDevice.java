package com.ruoyi.ledger.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 设备信息对象 ledger_device
 *
 * @author disda
 * @date 2024-02-22
 */
public class LedgerDevice extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    @Override
    public String toString() {
        return "LedgerDevice{" +
                "id=" + id +
                ", sn='" + sn + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", devName='" + devName + '\'' +
                ", devModelId=" + devModelId +
                ", opDatetime=" + opDatetime +
                ", description='" + description + '\'' +
                ", supplyId=" + supplyId +
                ", sysTypeId=" + sysTypeId +
                ", locId=" + locId +
                '}';
    }

    /**
     * 序列号
     */
    @Excel(name = "序列号")
    private String sn;

    /**
     * 简称
     */
    @Excel(name = "简称")
    private String abbreviation;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    /**
     * 设备名称
     */
    @Excel(name = "设备名称")
    private String devName;

    /**
     * 设备型号id
     */
    @Excel(name = "设备型号id")
    private Long devModelId;

    /**
     * 运维时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "运维时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date opDatetime;

    /**
     * 描述
     */
    @Excel(name = "描述")
    private String description;

    /**
     * 电源id
     */
    @Excel(name = "电源id")
    private Long supplyId;

    /**
     * 系统类型id
     */
    @Excel(name = "系统类型id")
    private Long sysTypeId;

    /**
     * 机柜id
     */
    @Excel(name = "机柜id")
    private Long locId;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevModelId(Long devModelId) {
        this.devModelId = devModelId;
    }

    public Long getDevModelId() {
        return devModelId;
    }

    public void setOpDatetime(Date opDatetime) {
        this.opDatetime = opDatetime;
    }

    public Date getOpDatetime() {
        return opDatetime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setSupplyId(Long supplyId) {
        this.supplyId = supplyId;
    }

    public Long getSupplyId() {
        return supplyId;
    }

    public void setSysTypeId(Long sysTypeId) {
        this.sysTypeId = sysTypeId;
    }

    public Long getSysTypeId() {
        return sysTypeId;
    }

    public void setLocId(Long locId) {
        this.locId = locId;
    }

    public Long getLocId() {
        return locId;
    }

}
