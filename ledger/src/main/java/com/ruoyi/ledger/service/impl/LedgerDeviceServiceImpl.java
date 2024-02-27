package com.ruoyi.ledger.service.impl;

import java.util.List;

import com.ruoyi.ledger.domain.vo.LedgerDeviceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.ledger.mapper.LedgerDeviceMapper;
import com.ruoyi.ledger.domain.LedgerDevice;
import com.ruoyi.ledger.service.ILedgerDeviceService;

/**
 * 设备信息Service业务层处理
 * 
 * @author disda
 * @date 2024-02-22
 */
@Service
public class LedgerDeviceServiceImpl implements ILedgerDeviceService 
{
    @Autowired
    private LedgerDeviceMapper ledgerDeviceMapper;

    /**
     * 查询设备信息
     * 
     * @param id 设备信息主键
     * @return 设备信息
     */
    @Override
    public LedgerDevice selectLedgerDeviceById(Long id)
    {
        return ledgerDeviceMapper.selectLedgerDeviceById(id);
    }

    /**
     * 查询设备信息列表
     *
     * @param ledgerDeviceVO 设备信息
     * @return 设备信息
     */
    @Override
    public List<LedgerDeviceVO> selectLedgerDeviceList(LedgerDeviceVO ledgerDeviceVO)
    {
        return ledgerDeviceMapper.selectLedgerDeviceList(ledgerDeviceVO);
    }

    /**
     * 新增设备信息
     * 
     * @param ledgerDevice 设备信息
     * @return 结果
     */
    @Override
    public int insertLedgerDevice(LedgerDevice ledgerDevice)
    {
        return ledgerDeviceMapper.insertLedgerDevice(ledgerDevice);
    }

    /**
     * 修改设备信息
     * 
     * @param ledgerDevice 设备信息
     * @return 结果
     */
    @Override
    public int updateLedgerDevice(LedgerDevice ledgerDevice)
    {
        return ledgerDeviceMapper.updateLedgerDevice(ledgerDevice);
    }

    /**
     * 批量删除设备信息
     * 
     * @param ids 需要删除的设备信息主键
     * @return 结果
     */
    @Override
    public int deleteLedgerDeviceByIds(Long[] ids)
    {
        return ledgerDeviceMapper.deleteLedgerDeviceByIds(ids);
    }

    /**
     * 删除设备信息信息
     * 
     * @param id 设备信息主键
     * @return 结果
     */
    @Override
    public int deleteLedgerDeviceById(Long id)
    {
        return ledgerDeviceMapper.deleteLedgerDeviceById(id);
    }
}
