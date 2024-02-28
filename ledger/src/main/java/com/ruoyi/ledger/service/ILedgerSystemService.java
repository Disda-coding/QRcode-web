package com.ruoyi.ledger.service;

import com.ruoyi.ledger.domain.LedgerSystem;
import com.ruoyi.ledger.domain.vo.ElementOptions;

import java.util.List;

/**
 * 操作系统Service接口
 * 
 * @author disda
 * @date 2024-02-23
 */
public interface ILedgerSystemService 
{
    /**
     * 查询操作系统
     * 
     * @param id 操作系统主键
     * @return 操作系统
     */
    public LedgerSystem selectLedgerSystemById(Long id);

    /**
     * 查询操作系统列表
     * 
     * @param ledgerSystem 操作系统
     * @return 操作系统集合
     */
    public List<LedgerSystem> selectLedgerSystemList(LedgerSystem ledgerSystem);

    /**
     * 新增操作系统
     * 
     * @param ledgerSystem 操作系统
     * @return 结果
     */
    public int insertLedgerSystem(LedgerSystem ledgerSystem);

    /**
     * 修改操作系统
     * 
     * @param ledgerSystem 操作系统
     * @return 结果
     */
    public int updateLedgerSystem(LedgerSystem ledgerSystem);

    /**
     * 批量删除操作系统
     * 
     * @param ids 需要删除的操作系统主键集合
     * @return 结果
     */
    public int deleteLedgerSystemByIds(Long[] ids);

    /**
     * 删除操作系统信息
     * 
     * @param id 操作系统主键
     * @return 结果
     */
    public int deleteLedgerSystemById(Long id);

    List<ElementOptions> getSystemOps();
}
