package com.ruoyi.ledger.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * @program: qrcode-ruoyi
 * @description: 用于导出Excel的类
 * @author: Disda
 * @create: 2024-02-27 16:35
 */
public class LedgerDeviceExcel extends BaseEntity {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "LedgerDeviceExcel{" +
                "id=" + id +
                ", devName='" + devName + '\'' +
                ", sn='" + sn + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", ledgerIpList='" + ledgerIpList + '\'' +
                ", devType='" + devType + '\'' +
                ", devModel='" + devModel + '\'' +
                ", opDatetime=" + opDatetime +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", sysType='" + sysType + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }


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

    public String getLedgerIpList() {
        return ledgerIpList;
    }

    public void setLedgerIpList(String ledgerIpList) {
        this.ledgerIpList = ledgerIpList;
    }

    public String getDevType() {
        return devType;
    }

    public void setDevType(String devType) {
        this.devType = devType;
    }

    public String getDevModel() {
        return devModel;
    }

    public void setDevModel(String devModel) {
        this.devModel = devModel;
    }

    public Date getOpDatetime() {
        return opDatetime;
    }

    public void setOpDatetime(Date opDatetime) {
        this.opDatetime = opDatetime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    public String getSysType() {
        return sysType;
    }

    public void setSysType(String sysType) {
        this.sysType = sysType;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String devName;


    /** 序列号 */
    @Excel(name = "序列号")
    private String sn;

    /** 简称 */
    @Excel(name = "简称")
    private String abbreviation;

    @Excel(name="ip列表")
    private String ledgerIpList;

    @Excel(name = "设备类型")
    private String devType;

    /**  */
    @Excel(name = "设备型号")
    private String devModel;

    /** 运维时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "运维时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date opDatetime;

    /** 描述 */
    @Excel(name = "描述")
    private String description;


    @Excel(name = "电源情况")
    private String status;


    @Excel(name = "操作系统")
    private String sysType;


    @Excel(name = "机柜名")
    private String name;
}