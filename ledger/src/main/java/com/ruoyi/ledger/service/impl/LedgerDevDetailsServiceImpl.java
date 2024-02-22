package com.ruoyi.ledger.service.impl;

import com.ruoyi.ledger.domain.LedgerDevDetails;
import com.ruoyi.ledger.mapper.LedgerDevDetailsMapper;
import com.ruoyi.ledger.service.ILedgerDevDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 设备详情Service业务层处理
 * 
 * @author disda
 * @date 2024-02-22
 */
@Service
public class LedgerDevDetailsServiceImpl implements ILedgerDevDetailsService
{
    @Autowired
    private LedgerDevDetailsMapper ledgerDevDetailsMapper;

    /**
     * 查询设备详情
     * 
     * @param id 设备详情主键
     * @return 设备详情
     */
    @Override
    public LedgerDevDetails selectLedgerDevDetailsById(Long id)
    {
        return ledgerDevDetailsMapper.selectLedgerDevDetailsById(id);
    }

    /**
     * 查询设备详情列表
     * 
     * @param ledgerDevDetails 设备详情
     * @return 设备详情
     */
    @Override
    public List<LedgerDevDetails> selectLedgerDevDetailsList(LedgerDevDetails ledgerDevDetails)
    {
        return ledgerDevDetailsMapper.selectLedgerDevDetailsList(ledgerDevDetails);
    }

    /**
     * 新增设备详情
     * 
     * @param ledgerDevDetails 设备详情
     * @return 结果
     */
    @Override
    public int insertLedgerDevDetails(LedgerDevDetails ledgerDevDetails)
    {
        return ledgerDevDetailsMapper.insertLedgerDevDetails(ledgerDevDetails);
    }

    /**
     * 修改设备详情
     * 
     * @param ledgerDevDetails 设备详情
     * @return 结果
     */
    @Override
    public int updateLedgerDevDetails(LedgerDevDetails ledgerDevDetails)
    {
        return ledgerDevDetailsMapper.updateLedgerDevDetails(ledgerDevDetails);
    }

    /**
     * 批量删除设备详情
     * 
     * @param ids 需要删除的设备详情主键
     * @return 结果
     */
    @Override
    public int deleteLedgerDevDetailsByIds(Long[] ids)
    {
        return ledgerDevDetailsMapper.deleteLedgerDevDetailsByIds(ids);
    }

    /**
     * 删除设备详情信息
     * 
     * @param id 设备详情主键
     * @return 结果
     */
    @Override
    public int deleteLedgerDevDetailsById(Long id)
    {
        return ledgerDevDetailsMapper.deleteLedgerDevDetailsById(id);
    }

    @Override
    public List<String> getDevTypeOps() {
        List<String> uniqueDevType = ledgerDevDetailsMapper.getDevTypeOpsgetDevTypeOps();
        return uniqueDevType;
    }
}
