package com.ruoyi.ledger.mapper;

import com.ruoyi.ledger.domain.LedgerIp;

import java.util.List;

/**
 * IP地址详情Mapper接口
 *
 * @author disda
 * @date 2024-02-22
 */
public interface LedgerIpMapper
{
    /**
     * 查询IP地址详情
     *
     * @param id IP地址详情主键
     * @return IP地址详情
     */
    public LedgerIp selectLedgerIpById(Long id);

    /**
     * 查询IP地址详情列表
     *
     * @param ledgerIp IP地址详情
     * @return IP地址详情集合
     */
    public List<LedgerIp> selectLedgerIpList(LedgerIp ledgerIp);

    /**
     * 新增IP地址详情
     *
     * @param ledgerIp IP地址详情
     * @return 结果
     */
    public int insertLedgerIp(LedgerIp ledgerIp);

    /**
     * 修改IP地址详情
     *
     * @param ledgerIp IP地址详情
     * @return 结果
     */
    public int updateLedgerIp(LedgerIp ledgerIp);

    /**
     * 删除IP地址详情
     *
     * @param id IP地址详情主键
     * @return 结果
     */
    public int deleteLedgerIpById(Long id);

    /**
     * 批量删除IP地址详情
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLedgerIpByIds(Long[] ids);

    List<String> getIpTypeOps();
}
