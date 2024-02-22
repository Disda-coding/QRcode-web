package com.ruoyi.ledger.service;

import java.util.List;
import com.ruoyi.ledger.domain.LedgerDevIp;

/**
 * 设备ip映射Service接口
 * 
 * @author disda
 * @date 2024-02-22
 */
public interface ILedgerDevIpService 
{
    /**
     * 查询设备ip映射
     * 
     * @param id 设备ip映射主键
     * @return 设备ip映射
     */
    public LedgerDevIp selectLedgerDevIpById(Long id);

    /**
     * 查询设备ip映射列表
     * 
     * @param ledgerDevIp 设备ip映射
     * @return 设备ip映射集合
     */
    public List<LedgerDevIp> selectLedgerDevIpList(LedgerDevIp ledgerDevIp);

    /**
     * 新增设备ip映射
     * 
     * @param ledgerDevIp 设备ip映射
     * @return 结果
     */
    public int insertLedgerDevIp(LedgerDevIp ledgerDevIp);

    /**
     * 修改设备ip映射
     * 
     * @param ledgerDevIp 设备ip映射
     * @return 结果
     */
    public int updateLedgerDevIp(LedgerDevIp ledgerDevIp);

    /**
     * 批量删除设备ip映射
     * 
     * @param ids 需要删除的设备ip映射主键集合
     * @return 结果
     */
    public int deleteLedgerDevIpByIds(Long[] ids);

    /**
     * 删除设备ip映射信息
     * 
     * @param id 设备ip映射主键
     * @return 结果
     */
    public int deleteLedgerDevIpById(Long id);
}
