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
}