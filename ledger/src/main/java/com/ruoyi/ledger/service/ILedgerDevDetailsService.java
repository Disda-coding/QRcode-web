package com.ruoyi.ledger.service;

import com.ruoyi.ledger.domain.LedgerDevDetails;
import com.ruoyi.ledger.domain.vo.ElementOptions;

import java.util.List;

/**
 * 设备详情Service接口
 * 
 * @author disda
 * @date 2024-02-22
 */
public interface ILedgerDevDetailsService 
{
    /**
     * 查询设备详情
     * 
     * @param id 设备详情主键
     * @return 设备详情
     */
    public LedgerDevDetails selectLedgerDevDetailsById(Long id);

    /**
     * 查询设备详情列表
     * 
     * @param ledgerDevDetails 设备详情
     * @return 设备详情集合
     */
    public List<LedgerDevDetails> selectLedgerDevDetailsList(LedgerDevDetails ledgerDevDetails);

    /**
     * 新增设备详情
     * 
     * @param ledgerDevDetails 设备详情
     * @return 结果
     */
    public int insertLedgerDevDetails(LedgerDevDetails ledgerDevDetails);

    /**
     * 修改设备详情
     * 
     * @param ledgerDevDetails 设备详情
     * @return 结果
     */
    public int updateLedgerDevDetails(LedgerDevDetails ledgerDevDetails);

    /**
     * 批量删除设备详情
     * 
     * @param ids 需要删除的设备详情主键集合
     * @return 结果
     */
    public int deleteLedgerDevDetailsByIds(Long[] ids);

    /**
     * 删除设备详情信息
     * 
     * @param id 设备详情主键
     * @return 结果
     */
    public int deleteLedgerDevDetailsById(Long id);

    /**
     * 获取设备类型的列表
     * @return
     */
    List<String> getDevTypeOps();
    /**
     * 获取设备型号的列表
     *
     * @return
     */
    List<ElementOptions> getDevModelOps();
}
