package com.ruoyi.ledger.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.ledger.mapper.LedgerDevIpMapper;
import com.ruoyi.ledger.domain.LedgerDevIp;
import com.ruoyi.ledger.service.ILedgerDevIpService;

/**
 * 设备ip映射Service业务层处理
 * 
 * @author disda
 * @date 2024-02-22
 */
@Service
public class LedgerDevIpServiceImpl implements ILedgerDevIpService 
{
    @Autowired
    private LedgerDevIpMapper ledgerDevIpMapper;

    /**
     * 查询设备ip映射
     * 
     * @param id 设备ip映射主键
     * @return 设备ip映射
     */
    @Override
    public LedgerDevIp selectLedgerDevIpById(Long id)
    {
        return ledgerDevIpMapper.selectLedgerDevIpById(id);
    }

    /**
     * 查询设备ip映射列表
     * 
     * @param ledgerDevIp 设备ip映射
     * @return 设备ip映射
     */
    @Override
    public List<LedgerDevIp> selectLedgerDevIpList(LedgerDevIp ledgerDevIp)
    {
        return ledgerDevIpMapper.selectLedgerDevIpList(ledgerDevIp);
    }

    /**
     * 新增设备ip映射
     * 
     * @param ledgerDevIp 设备ip映射
     * @return 结果
     */
    @Override
    public int insertLedgerDevIp(LedgerDevIp ledgerDevIp)
    {
        return ledgerDevIpMapper.insertLedgerDevIp(ledgerDevIp);
    }

    /**
     * 修改设备ip映射
     * 
     * @param ledgerDevIp 设备ip映射
     * @return 结果
     */
    @Override
    public int updateLedgerDevIp(LedgerDevIp ledgerDevIp)
    {
        return ledgerDevIpMapper.updateLedgerDevIp(ledgerDevIp);
    }

    /**
     * 批量删除设备ip映射
     * 
     * @param ids 需要删除的设备ip映射主键
     * @return 结果
     */
    @Override
    public int deleteLedgerDevIpByIds(Long[] ids)
    {
        return ledgerDevIpMapper.deleteLedgerDevIpByIds(ids);
    }

    /**
     * 删除设备ip映射信息
     * 
     * @param id 设备ip映射主键
     * @return 结果
     */
    @Override
    public int deleteLedgerDevIpById(Long id)
    {
        return ledgerDevIpMapper.deleteLedgerDevIpById(id);
    }
}
