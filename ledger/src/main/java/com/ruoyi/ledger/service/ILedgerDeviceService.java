package com.ruoyi.ledger.service;

import java.util.List;
import com.ruoyi.ledger.domain.LedgerDevice;

/**
 * 设备信息Service接口
 * 
 * @author disda
 * @date 2024-02-22
 */
public interface ILedgerDeviceService 
{
    /**
     * 查询设备信息
     * 
     * @param id 设备信息主键
     * @return 设备信息
     */
    public LedgerDevice selectLedgerDeviceById(Long id);

    /**
     * 查询设备信息列表
     * 
     * @param ledgerDevice 设备信息
     * @return 设备信息集合
     */
    public List<LedgerDevice> selectLedgerDeviceList(LedgerDevice ledgerDevice);

    /**
     * 新增设备信息
     * 
     * @param ledgerDevice 设备信息
     * @return 结果
     */
    public int insertLedgerDevice(LedgerDevice ledgerDevice);

    /**
     * 修改设备信息
     * 
     * @param ledgerDevice 设备信息
     * @return 结果
     */
    public int updateLedgerDevice(LedgerDevice ledgerDevice);

    /**
     * 批量删除设备信息
     * 
     * @param ids 需要删除的设备信息主键集合
     * @return 结果
     */
    public int deleteLedgerDeviceByIds(Long[] ids);

    /**
     * 删除设备信息信息
     * 
     * @param id 设备信息主键
     * @return 结果
     */
    public int deleteLedgerDeviceById(Long id);
}
