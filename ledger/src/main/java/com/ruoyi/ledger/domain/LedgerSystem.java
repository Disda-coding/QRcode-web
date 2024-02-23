package com.ruoyi.ledger.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 操作系统对象 ledger_system
 * 
 * @author disda
 * @date 2024-02-23
 */
public class LedgerSystem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 操作系统 */
    @Excel(name = "操作系统")
    private String sysType;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSysType(String sysType) 
    {
        this.sysType = sysType;
    }

    public String getSysType() 
    {
        return sysType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("sysType", getSysType())
            .toString();
    }
}
