package com.ruoyi.ledger.mapper;

import com.ruoyi.ledger.domain.LedgerPowerSupply;
import com.ruoyi.ledger.domain.vo.ElementOptions;

import java.util.List;

/**
 * 电源详情Mapper接口
 * 
 * @author disda
 * @date 2024-02-22
 */
public interface LedgerPowerSupplyMapper 
{
    /**
     * 查询电源详情
     * 
     * @param id 电源详情主键
     * @return 电源详情
     */
    public LedgerPowerSupply selectLedgerPowerSupplyById(Long id);

    /**
     * 查询电源详情列表
     * 
     * @param ledgerPowerSupply 电源详情
     * @return 电源详情集合
     */
    public List<LedgerPowerSupply> selectLedgerPowerSupplyList(LedgerPowerSupply ledgerPowerSupply);

    /**
     * 新增电源详情
     * 
     * @param ledgerPowerSupply 电源详情
     * @return 结果
     */
    public int insertLedgerPowerSupply(LedgerPowerSupply ledgerPowerSupply);

    /**
     * 修改电源详情
     * 
     * @param ledgerPowerSupply 电源详情
     * @return 结果
     */
    public int updateLedgerPowerSupply(LedgerPowerSupply ledgerPowerSupply);

    /**
     * 删除电源详情
     * 
     * @param id 电源详情主键
     * @return 结果
     */
    public int deleteLedgerPowerSupplyById(Long id);

    /**
     * 批量删除电源详情
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLedgerPowerSupplyByIds(Long[] ids);

    List<ElementOptions> getPowerSupplyOps();
}
