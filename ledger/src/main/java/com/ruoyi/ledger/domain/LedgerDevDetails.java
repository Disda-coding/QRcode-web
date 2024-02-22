package com.ruoyi.ledger.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 设备详情对象 ledger_dev_details
 * 
 * @author disda
 * @date 2024-02-22
 */
public class LedgerDevDetails extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /**  */
    @Excel(name = "")
    private String devType;

    /**  */
    @Excel(name = "")
    private String devModel;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDevType(String devType) 
    {
        this.devType = devType;
    }

    public String getDevType() 
    {
        return devType;
    }
    public void setDevModel(String devModel) 
    {
        this.devModel = devModel;
    }

    public String getDevModel() 
    {
        return devModel;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("devType", getDevType())
            .append("devModel", getDevModel())
            .toString();
    }
}
