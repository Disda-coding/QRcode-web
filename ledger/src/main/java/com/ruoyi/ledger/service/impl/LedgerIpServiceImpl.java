package com.ruoyi.ledger.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.ledger.mapper.LedgerIpMapper;
import com.ruoyi.ledger.domain.LedgerIp;
import com.ruoyi.ledger.service.ILedgerIpService;

/**
 * ip地址Service业务层处理
 * 
 * @author disda
 * @date 2024-02-22
 */
@Service
public class LedgerIpServiceImpl implements ILedgerIpService 
{
    @Autowired
    private LedgerIpMapper ledgerIpMapper;

    /**
     * 查询ip地址
     * 
     * @param id ip地址主键
     * @return ip地址
     */
    @Override
    public LedgerIp selectLedgerIpById(Long id)
    {
        return ledgerIpMapper.selectLedgerIpById(id);
    }

    /**
     * 查询ip地址列表
     * 
     * @param ledgerIp ip地址
     * @return ip地址
     */
    @Override
    public List<LedgerIp> selectLedgerIpList(LedgerIp ledgerIp)
    {
        return ledgerIpMapper.selectLedgerIpList(ledgerIp);
    }

    /**
     * 新增ip地址
     * 
     * @param ledgerIp ip地址
     * @return 结果
     */
    @Override
    public int insertLedgerIp(LedgerIp ledgerIp)
    {
        return ledgerIpMapper.insertLedgerIp(ledgerIp);
    }

    /**
     * 修改ip地址
     * 
     * @param ledgerIp ip地址
     * @return 结果
     */
    @Override
    public int updateLedgerIp(LedgerIp ledgerIp)
    {
        return ledgerIpMapper.updateLedgerIp(ledgerIp);
    }

    /**
     * 批量删除ip地址
     * 
     * @param ids 需要删除的ip地址主键
     * @return 结果
     */
    @Override
    public int deleteLedgerIpByIds(Long[] ids)
    {
        return ledgerIpMapper.deleteLedgerIpByIds(ids);
    }

    /**
     * 删除ip地址信息
     * 
     * @param id ip地址主键
     * @return 结果
     */
    @Override
    public int deleteLedgerIpById(Long id)
    {
        return ledgerIpMapper.deleteLedgerIpById(id);
    }
}
