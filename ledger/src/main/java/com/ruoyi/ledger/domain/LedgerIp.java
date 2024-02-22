package com.ruoyi.ledger.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * IP地址详情对象 ledger_ip
 *
 * @author disda
 * @date 2024-02-22
 */
public class LedgerIp extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** ip地址 */
    @Excel(name = "ip地址")
    private String ipAddr;

    /** ip地址类型 */
    @Excel(name = "ip地址类型")
    private String type;

    /** 设备id */
    @Excel(name = "设备id")
    private Long devId;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setIpAddr(String ipAddr)
    {
        this.ipAddr = ipAddr;
    }

    public String getIpAddr()
    {
        return ipAddr;
    }
    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }
    public void setDevId(Long devId)
    {
        this.devId = devId;
    }

    public Long getDevId()
    {
        return devId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("ipAddr", getIpAddr())
                .append("type", getType())
                .append("devId", getDevId())
                .toString();
    }
}
