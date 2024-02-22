package com.ruoyi.ledger.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 设备ip映射对象 ledger_dev_ip
 * 
 * @author disda
 * @date 2024-02-22
 */
public class LedgerDevIp extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 设备id */
    @Excel(name = "设备id")
    private Long devId;

    /** iip地址id */
    @Excel(name = "iip地址id")
    private Long ipId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDevId(Long devId) 
    {
        this.devId = devId;
    }

    public Long getDevId() 
    {
        return devId;
    }
    public void setIpId(Long ipId) 
    {
        this.ipId = ipId;
    }

    public Long getIpId() 
    {
        return ipId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("devId", getDevId())
            .append("ipId", getIpId())
            .toString();
    }
}
