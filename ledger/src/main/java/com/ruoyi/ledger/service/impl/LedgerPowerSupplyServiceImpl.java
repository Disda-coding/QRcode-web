package com.ruoyi.ledger.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.ledger.mapper.LedgerPowerSupplyMapper;
import com.ruoyi.ledger.domain.LedgerPowerSupply;
import com.ruoyi.ledger.service.ILedgerPowerSupplyService;

/**
 * 电源详情Service业务层处理
 * 
 * @author disda
 * @date 2024-02-22
 */
@Service
public class LedgerPowerSupplyServiceImpl implements ILedgerPowerSupplyService 
{
    @Autowired
    private LedgerPowerSupplyMapper ledgerPowerSupplyMapper;

    /**
     * 查询电源详情
     * 
     * @param id 电源详情主键
     * @return 电源详情
     */
    @Override
    public LedgerPowerSupply selectLedgerPowerSupplyById(Long id)
    {
        return ledgerPowerSupplyMapper.selectLedgerPowerSupplyById(id);
    }

    /**
     * 查询电源详情列表
     * 
     * @param ledgerPowerSupply 电源详情
     * @return 电源详情
     */
    @Override
    public List<LedgerPowerSupply> selectLedgerPowerSupplyList(LedgerPowerSupply ledgerPowerSupply)
    {
        return ledgerPowerSupplyMapper.selectLedgerPowerSupplyList(ledgerPowerSupply);
    }

    /**
     * 新增电源详情
     * 
     * @param ledgerPowerSupply 电源详情
     * @return 结果
     */
    @Override
    public int insertLedgerPowerSupply(LedgerPowerSupply ledgerPowerSupply)
    {
        return ledgerPowerSupplyMapper.insertLedgerPowerSupply(ledgerPowerSupply);
    }

    /**
     * 修改电源详情
     * 
     * @param ledgerPowerSupply 电源详情
     * @return 结果
     */
    @Override
    public int updateLedgerPowerSupply(LedgerPowerSupply ledgerPowerSupply)
    {
        return ledgerPowerSupplyMapper.updateLedgerPowerSupply(ledgerPowerSupply);
    }

    /**
     * 批量删除电源详情
     * 
     * @param ids 需要删除的电源详情主键
     * @return 结果
     */
    @Override
    public int deleteLedgerPowerSupplyByIds(Long[] ids)
    {
        return ledgerPowerSupplyMapper.deleteLedgerPowerSupplyByIds(ids);
    }

    /**
     * 删除电源详情信息
     * 
     * @param id 电源详情主键
     * @return 结果
     */
    @Override
    public int deleteLedgerPowerSupplyById(Long id)
    {
        return ledgerPowerSupplyMapper.deleteLedgerPowerSupplyById(id);
    }
}
