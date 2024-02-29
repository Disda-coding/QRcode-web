package com.ruoyi.ledger.service.impl;

import com.ruoyi.ledger.domain.LedgerDevice;
import com.ruoyi.ledger.domain.LedgerIp;
import com.ruoyi.ledger.domain.vo.LedgerDeviceExcel;
import com.ruoyi.ledger.domain.vo.LedgerDeviceVO;
import com.ruoyi.ledger.mapper.LedgerDeviceMapper;
import com.ruoyi.ledger.mapper.LedgerIpMapper;
import com.ruoyi.ledger.service.ILedgerDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 设备信息Service业务层处理
 *
 * @author disda
 * @date 2024-02-22
 */
@Service
public class LedgerDeviceServiceImpl implements ILedgerDeviceService {
    @Autowired
    private LedgerDeviceMapper ledgerDeviceMapper;
    @Autowired
    private LedgerIpMapper ledgerIpMapper;

    /**
     * 查询设备信息
     *
     * @param id 设备信息主键
     * @return 设备信息
     */
    @Override
    public LedgerDeviceVO selectLedgerDeviceById(Long id) {
        return ledgerDeviceMapper.selectLedgerDeviceById(id);
    }

    /**
     * 查询设备信息列表
     *
     * @param ledgerDeviceVO 设备信息
     * @return 设备信息
     */
    @Override
    public List<LedgerDeviceVO> selectLedgerDeviceList(LedgerDeviceVO ledgerDeviceVO) {
        return ledgerDeviceMapper.selectLedgerDeviceList(ledgerDeviceVO);
    }

    /**
     * 新增设备信息
     *
     * @param ledgerDevice 设备信息
     * @return 结果
     */
    @Override
    public int insertLedgerDevice(LedgerDevice ledgerDevice) {
        return ledgerDeviceMapper.insertLedgerDevice(ledgerDevice);
    }

    /**
     * 修改设备信息
     *
     * @param ledgerDevice 设备信息
     * @return 结果
     */
    @Override
    public int updateLedgerDevice(LedgerDevice ledgerDevice) {
        return ledgerDeviceMapper.updateLedgerDevice(ledgerDevice);
    }

    /**
     * 批量删除设备信息
     *
     * @param ids 需要删除的设备信息主键
     * @return 结果
     */
    @Override
    public int deleteLedgerDeviceByIds(Long[] ids) {
        return ledgerDeviceMapper.deleteLedgerDeviceByIds(ids);
    }

    /**
     * 删除设备信息信息
     *
     * @param id 设备信息主键
     * @return 结果
     */
    @Override
    public int deleteLedgerDeviceById(Long id) {
        return ledgerDeviceMapper.deleteLedgerDeviceById(id);
    }

    @Override
    public List<LedgerDeviceExcel> generateDevExcel(LedgerDeviceVO ledgerDeviceVO) {
        List<LedgerDeviceVO> list = selectLedgerDeviceList(ledgerDeviceVO);
        List<LedgerDeviceExcel> res = new ArrayList<>();
        // 手动装配
        for (LedgerDeviceVO ledgerDeviceVo : list) {
            LedgerDeviceExcel tmp = new LedgerDeviceExcel();
            if (ledgerDeviceVo.getLedgerLocation() != null) {
                tmp.setName(ledgerDeviceVo.getLedgerLocation().getName());
            } else {
                tmp.setName("");
            }
            tmp.setDevName(ledgerDeviceVo.getDevName());
            tmp.setSn(ledgerDeviceVo.getSn());
            tmp.setAbbreviation(ledgerDeviceVo.getAbbreviation());
            //ip地址
            if (ledgerDeviceVo.getLedgerDevDetails() != null) {
                tmp.setDevType(ledgerDeviceVo.getLedgerDevDetails().getDevType());
                tmp.setDevModel(ledgerDeviceVo.getLedgerDevDetails().getDevModel());
            }

            tmp.setOpDatetime(ledgerDeviceVo.getOpDatetime());
            tmp.setDescription(ledgerDeviceVo.getDescription());
            if (ledgerDeviceVo.getLedgerPowerSupply() != null) {
                tmp.setStatus(ledgerDeviceVo.getLedgerPowerSupply().getStatus());
            }
            if (ledgerDeviceVo.getLedgerSystem() == null) {
                tmp.setSysType("");
            } else {
                tmp.setSysType(ledgerDeviceVo.getLedgerSystem().getSysType());
            }
            //ip地址，由于台账规模小，直接分多次访问数据库,规模大可以从这里优化
            LedgerIp queryLedgerIp = new LedgerIp();
            queryLedgerIp.setDevId(ledgerDeviceVo.getId());
            List<LedgerIp> ipList=ledgerIpMapper.selectLedgerIpList(queryLedgerIp);
            tmp.setLedgerIpList(formatLedgerIpList(ipList));
            res.add(tmp);
        }
        return res;
    }
    private String formatLedgerIpList(List<LedgerIp> ipList) {
        StringBuilder sb = new StringBuilder();
        for (LedgerIp ledgerIp : ipList) {
            sb.append("ip地址类型：").append(ledgerIp.getType()).append("，ip地址：").append(ledgerIp.getIpAddr()).append("\r\n");
        }
        return sb.toString();
    }

}
