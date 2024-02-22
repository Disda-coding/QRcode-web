package com.ruoyi.ledger.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 设备信息对象 ledger_device
 * 
 * @author disda
 * @date 2024-02-22
 */
public class LedgerDevice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String devName;

    /** 设备型号id */
    @Excel(name = "设备型号id")
    private Long devModelId;

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

    /** 系统类型id */
    @Excel(name = "系统类型id")
    private Long sysTypeId;

    /** 机柜id */
    @Excel(name = "机柜id")
    private Long locId;

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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("devName", getDevName())
            .append("devModelId", getDevModelId())
            .append("opDatetime", getOpDatetime())
            .append("description", getDescription())
            .append("supplyId", getSupplyId())
            .append("sysTypeId", getSysTypeId())
            .append("locId", getLocId())
            .toString();
    }
}
