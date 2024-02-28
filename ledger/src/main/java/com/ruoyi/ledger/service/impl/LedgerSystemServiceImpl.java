package com.ruoyi.ledger.service.impl;

import com.ruoyi.ledger.domain.LedgerSystem;
import com.ruoyi.ledger.domain.vo.ElementOptions;
import com.ruoyi.ledger.mapper.LedgerSystemMapper;
import com.ruoyi.ledger.service.ILedgerSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 操作系统Service业务层处理
 * 
 * @author disda
 * @date 2024-02-23
 */
@Service
public class LedgerSystemServiceImpl implements ILedgerSystemService 
{
    @Autowired
    private LedgerSystemMapper ledgerSystemMapper;

    /**
     * 查询操作系统
     * 
     * @param id 操作系统主键
     * @return 操作系统
     */
    @Override
    public LedgerSystem selectLedgerSystemById(Long id)
    {
        return ledgerSystemMapper.selectLedgerSystemById(id);
    }

    /**
     * 查询操作系统列表
     * 
     * @param ledgerSystem 操作系统
     * @return 操作系统
     */
    @Override
    public List<LedgerSystem> selectLedgerSystemList(LedgerSystem ledgerSystem)
    {
        return ledgerSystemMapper.selectLedgerSystemList(ledgerSystem);
    }

    /**
     * 新增操作系统
     * 
     * @param ledgerSystem 操作系统
     * @return 结果
     */
    @Override
    public int insertLedgerSystem(LedgerSystem ledgerSystem)
    {
        return ledgerSystemMapper.insertLedgerSystem(ledgerSystem);
    }

    /**
     * 修改操作系统
     * 
     * @param ledgerSystem 操作系统
     * @return 结果
     */
    @Override
    public int updateLedgerSystem(LedgerSystem ledgerSystem)
    {
        return ledgerSystemMapper.updateLedgerSystem(ledgerSystem);
    }

    /**
     * 批量删除操作系统
     * 
     * @param ids 需要删除的操作系统主键
     * @return 结果
     */
    @Override
    public int deleteLedgerSystemByIds(Long[] ids)
    {
        return ledgerSystemMapper.deleteLedgerSystemByIds(ids);
    }

    /**
     * 删除操作系统信息
     * 
     * @param id 操作系统主键
     * @return 结果
     */
    @Override
    public int deleteLedgerSystemById(Long id)
    {
        return ledgerSystemMapper.deleteLedgerSystemById(id);
    }

    @Override
    public List<ElementOptions> getSystemOps() {
        return ledgerSystemMapper.getSystemOps();
    }
}
