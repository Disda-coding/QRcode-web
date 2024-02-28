package com.ruoyi.ledger.service;

import com.ruoyi.ledger.domain.LedgerIp;
import com.ruoyi.ledger.domain.vo.ElementOptions;

import java.util.List;

/**
 * ip地址Service接口
 * 
 * @author disda
 * @date 2024-02-22
 */
public interface ILedgerIpService 
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
     * 批量删除ip地址
     * 
     * @param ids 需要删除的ip地址主键集合
     * @return 结果
     */
    public int deleteLedgerIpByIds(Long[] ids);

    /**
     * 删除ip地址信息
     * 
     * @param id ip地址主键
     * @return 结果
     */
    public int deleteLedgerIpById(Long id);

    /**
     * 获取ip地址类型
     * @return
     */
    List<String> getIpTypeOps();

    List<ElementOptions> getIpDevOptions();

    List<String> getDevIps(Long id);
}
