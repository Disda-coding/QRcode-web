package com.ruoyi.ledger.service.impl;

import com.ruoyi.ledger.domain.LedgerIp;
import com.ruoyi.ledger.domain.vo.ElementOptions;
import com.ruoyi.ledger.mapper.LedgerDeviceMapper;
import com.ruoyi.ledger.mapper.LedgerIpMapper;
import com.ruoyi.ledger.service.ILedgerIpService;
import com.ruoyi.ledger.utils.IPUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * IP地址详情Service业务层处理
 *
 * @author disda
 * @date 2024-02-22
 */
@Service
public class LedgerIpServiceImpl implements ILedgerIpService
{
    @Autowired
    private LedgerIpMapper ledgerIpMapper;

    @Autowired
    private LedgerDeviceMapper ledgerDeviceMapper;

    /**
     * 查询IP地址详情
     *
     * @param id IP地址详情主键
     * @return IP地址详情
     */
    @Override
    public LedgerIp selectLedgerIpById(Long id)
    {
        return ledgerIpMapper.selectLedgerIpById(id);
    }

    /**
     * 查询IP地址详情列表
     *
     * @param ledgerIp IP地址详情
     * @return IP地址详情
     */
    @Override
    public List<LedgerIp> selectLedgerIpList(LedgerIp ledgerIp)
    {
        return ledgerIpMapper.selectLedgerIpList(ledgerIp);
    }

    /**
     * 新增IP地址详情
     *
     * @param ledgerIp IP地址详情
     * @return 结果
     */
    @Override
    public int insertLedgerIp(LedgerIp ledgerIp)
    {

        return ledgerIpMapper.insertLedgerIp(ledgerIp);
    }

    /**
     * 修改IP地址详情
     *
     * @param ledgerIp IP地址详情
     * @return 结果
     */
    @Override
    public int updateLedgerIp(LedgerIp ledgerIp)
    {
        return ledgerIpMapper.updateLedgerIp(ledgerIp);
    }

    /**
     * 批量删除IP地址详情
     *
     * @param ids 需要删除的IP地址详情主键
     * @return 结果
     */
    @Override
    public int deleteLedgerIpByIds(Long[] ids)
    {
        return ledgerIpMapper.deleteLedgerIpByIds(ids);
    }

    /**
     * 删除IP地址详情信息
     *
     * @param id IP地址详情主键
     * @return 结果
     */
    @Override
    public int deleteLedgerIpById(Long id)
    {
        return ledgerIpMapper.deleteLedgerIpById(id);
    }

    @Override
    public List<String> getIpTypeOps() {
        List<String> uniqueIpTypeOps = ledgerIpMapper.getIpTypeOps();
        return uniqueIpTypeOps;
    }

    @Override
    public List<ElementOptions> getIpDevOptions() {
        return ledgerDeviceMapper.getDevOptions();
    }

    @Override
    public List<String> getDevIps(Long id) {
        return ledgerIpMapper.getDevIps(id);
    }

    @Override
    public Map<String, Objects> getAllIps(String ipAddr, String netmask) {
        Map res = new HashMap<String, Objects>();
        List allIplist = IPUtils.getAllIPs(ipAddr,Integer.valueOf(netmask),false);
        List existIps = ledgerIpMapper.showAllIps();
        List<String> filteredIpList = (List<String>) allIplist.stream()
                .filter(ip -> !existIps.contains(ip))
                .collect(Collectors.toList());
        res.put("allIpList",filteredIpList);
        String result = allIplist.size()>filteredIpList.size()?"false":"true";
        res.put("flag",result);
        return res;
    }


}
