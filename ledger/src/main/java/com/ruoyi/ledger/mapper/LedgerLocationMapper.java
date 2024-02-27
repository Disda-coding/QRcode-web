package com.ruoyi.ledger.mapper;

import com.ruoyi.ledger.domain.LedgerLocation;

import java.util.List;

/**
 * 机柜地址Mapper接口
 * 
 * @author disda
 * @date 2024-02-22
 */
public interface LedgerLocationMapper 
{
    /**
     * 查询机柜地址
     * 
     * @param id 机柜地址主键
     * @return 机柜地址
     */
    public LedgerLocation selectLedgerLocationById(Long id);

    /**
     * 查询机柜地址列表
     * 
     * @param ledgerLocation 机柜地址
     * @return 机柜地址集合
     */
    public List<LedgerLocation> selectLedgerLocationList(LedgerLocation ledgerLocation);

    /**
     * 新增机柜地址
     * 
     * @param ledgerLocation 机柜地址
     * @return 结果
     */
    public int insertLedgerLocation(LedgerLocation ledgerLocation);

    /**
     * 修改机柜地址
     * 
     * @param ledgerLocation 机柜地址
     * @return 结果
     */
    public int updateLedgerLocation(LedgerLocation ledgerLocation);

    /**
     * 删除机柜地址
     * 
     * @param id 机柜地址主键
     * @return 结果
     */
    public int deleteLedgerLocationById(Long id);

    /**
     * 批量删除机柜地址
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLedgerLocationByIds(Long[] ids);

    List<String> getLocationOps();


}
