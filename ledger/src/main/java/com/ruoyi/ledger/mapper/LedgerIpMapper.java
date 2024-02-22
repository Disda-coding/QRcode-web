package com.ruoyi.ledger.mapper;

import java.util.List;
import com.ruoyi.ledger.domain.LedgerIp;

/**
 * ip地址Mapper接口
 * 
 * @author disda
 * @date 2024-02-22
 */
public interface LedgerIpMapper 
{
    /**
     * 查询ip地址
     * 
     * @param id ip地址主键
     * @return ip地址
     */
    public LedgerIp selectLedgerIpById(Long id);

    /**
     * 查询ip地址列表
     * 
     * @param ledgerIp ip地址
     * @return ip地址集合
     */
    public List<LedgerIp> selectLedgerIpList(LedgerIp ledgerIp);

    /**
     * 新增ip地址
     * 
     * @param ledgerIp ip地址
     * @return 结果
     */
    public int insertLedgerIp(LedgerIp ledgerIp);

    /**
     * 修改ip地址
     * 
     * @param ledgerIp ip地址
     * @return 结果
     */
    public int updateLedgerIp(LedgerIp ledgerIp);

    /**
     * 删除ip地址
     * 
     * @param id ip地址主键
     * @return 结果
     */
    public int deleteLedgerIpById(Long id);

    /**
     * 批量删除ip地址
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLedgerIpByIds(Long[] ids);
}
