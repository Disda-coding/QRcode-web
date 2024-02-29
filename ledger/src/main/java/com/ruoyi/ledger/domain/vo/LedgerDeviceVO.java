package com.ruoyi.ledger.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.ledger.domain.*;

import java.util.Date;
import java.util.List;

/**
 * @program: qrcode-ruoyi
 * @description: 前端展示设备的VO
 * @author: Disda
 * @create: 2024-02-23 16:18
 */
public class LedgerDeviceVO extends BaseEntity {
    private static final long serialVersionUID = 1L;

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

    @Override
    public String toString() {
        return "LedgerDeviceVO{" +
                "id=" + id +
                ", devName='" + devName + '\'' +
                ", devModelId=" + devModelId +
                ", sn='" + sn + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", ledgerIpList=" + ledgerIpList +
                ", ledgerDevDetails=" + ledgerDevDetails +
                ", opDatetime=" + opDatetime +
                ", description='" + description + '\'' +
                ", supplyId=" + supplyId +
                ", ledgerPowerSupply=" + ledgerPowerSupply +
                ", sysTypeId=" + sysTypeId +
                ", ledgerSystem=" + ledgerSystem +
                ", locId=" + locId +
                ", ledgerLocation=" + ledgerLocation +
                '}';
    }

    /** 主键id */
    private Long id;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String devName;

    /** 设备型号id */
    @Excel(name = "设备型号id")
    private Long devModelId;

    /** 序列号 */
    @Excel(name = "序列号")
    private String sn;

    /** 简称 */
    @Excel(name = "简称")
    private String abbreviation;

    private List<LedgerIp> ledgerIpList;

    private LedgerDevDetails ledgerDevDetails;

    /** 运维时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "运维时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date opDatetime;

    /** 描述 */
    @Excel(name = "描述")
    private String description;

    /** 电源id */
    @Excel(name = "电源id")
    private Long supplyId;

    private LedgerPowerSupply ledgerPowerSupply;

    /** 系统类型id */
    @Excel(name = "系统类型id")
    private Long sysTypeId;

    private LedgerSystem ledgerSystem;

    /** 机柜id */
    @Excel(name = "机柜id")
    private Long locId;

    @Excel(name="机柜位置")
    private LedgerLocation ledgerLocation;
    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setDevName(String devName)
    {
        this.devName = devName;
    }

    public String getDevName()
    {
        return devName;
    }
    public void setDevModelId(Long devModelId)
    {
        this.devModelId = devModelId;
    }

    public Long getDevModelId()
    {
        return devModelId;
    }
    public void setOpDatetime(Date opDatetime)
    {
        this.opDatetime = opDatetime;
    }

    public Date getOpDatetime()
    {
        return opDatetime;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }
    public void setSupplyId(Long supplyId)
    {
        this.supplyId = supplyId;
    }

    public Long getSupplyId()
    {
        return supplyId;
    }
    public void setSysTypeId(Long sysTypeId)
    {
        this.sysTypeId = sysTypeId;
    }

    public Long getSysTypeId()
    {
        return sysTypeId;
    }
    public void setLocId(Long locId)
    {
        this.locId = locId;
    }

    public Long getLocId()
    {
        return locId;
    }

    public List<LedgerIp> getLedgerIpList() {
        return ledgerIpList;
    }

    public void setLedgerIpList(List<LedgerIp> ledgerIpList) {
        this.ledgerIpList = ledgerIpList;
    }

    public LedgerDevDetails getLedgerDevDetails() {
        return ledgerDevDetails;
    }

    public void setLedgerDevDetails(LedgerDevDetails ledgerDevDetails) {
        this.ledgerDevDetails = ledgerDevDetails;
    }

    public LedgerPowerSupply getLedgerPowerSupply() {
        return ledgerPowerSupply;
    }

    public void setLedgerPowerSupply(LedgerPowerSupply ledgerPowerSupply) {
        this.ledgerPowerSupply = ledgerPowerSupply;
    }

    public LedgerSystem getLedgerSystem() {
        return ledgerSystem;
    }

    public void setLedgerSystem(LedgerSystem ledgerSystem) {
        this.ledgerSystem = ledgerSystem;
    }

    public LedgerLocation getLedgerLocation() {
        return ledgerLocation;
    }

    public void setLedgerLocation(LedgerLocation ledgerLocation) {
        this.ledgerLocation = ledgerLocation;
    }
}