package com.ruoyi.ledger.mapper;

import com.ruoyi.ledger.domain.LedgerDevice;
import com.ruoyi.ledger.domain.vo.ElementOptions;
import com.ruoyi.ledger.domain.vo.LedgerDeviceVO;

import java.util.List;

/**
 * 设备信息Mapper接口
 * 
 * @author disda
 * @date 2024-02-22
 */
public interface LedgerDeviceMapper 
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
    public List<LedgerDeviceVO> selectLedgerDeviceList(LedgerDeviceVO ledgerDevice);

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
     * 删除设备信息
     * 
     * @param id 设备信息主键
     * @return 结果
     */
    public int deleteLedgerDeviceById(Long id);

    /**
     * 批量删除设备信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLedgerDeviceByIds(Long[] ids);

    public List<LedgerDeviceVO> getLedgerDeviceInfo();

    List<ElementOptions> getDevOptions();
}
