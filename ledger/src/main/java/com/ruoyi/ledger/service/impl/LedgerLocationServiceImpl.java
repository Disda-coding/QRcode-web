package com.ruoyi.ledger.service.impl;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.ledger.domain.LedgerLocation;
import com.ruoyi.ledger.domain.vo.ElementOptions;
import com.ruoyi.ledger.mapper.LedgerDeviceMapper;
import com.ruoyi.ledger.mapper.LedgerLocationMapper;
import com.ruoyi.ledger.service.ILedgerLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.ruoyi.ledger.utils.QRCodeGenerator.generateDevQRCode;

/**
 * 机柜地址Service业务层处理
 * 
 * @author disda
 * @date 2024-02-22
 */
@Service
public class LedgerLocationServiceImpl implements ILedgerLocationService 
{
    @Autowired
    private LedgerLocationMapper ledgerLocationMapper;
    @Autowired
    private LedgerDeviceMapper ledgerDeviceMapper;

    /**
     * 查询机柜地址
     * 
     * @param id 机柜地址主键
     * @return 机柜地址
     */
    @Override
    public LedgerLocation selectLedgerLocationById(Long id)
    {
        return ledgerLocationMapper.selectLedgerLocationById(id);
    }

    /**
     * 查询机柜地址列表
     * 
     * @param ledgerLocation 机柜地址
     * @return 机柜地址
     */
    @Override
    public List<LedgerLocation> selectLedgerLocationList(LedgerLocation ledgerLocation)
    {
        return ledgerLocationMapper.selectLedgerLocationList(ledgerLocation);
    }

    /**
     * 新增机柜地址
     * 
     * @param ledgerLocation 机柜地址
     * @return 结果
     */
    @Override
    public int insertLedgerLocation(LedgerLocation ledgerLocation)
    {
        return ledgerLocationMapper.insertLedgerLocation(ledgerLocation);
    }

    /**
     * 修改机柜地址
     * 
     * @param ledgerLocation 机柜地址
     * @return 结果
     */
    @Override
    public int updateLedgerLocation(LedgerLocation ledgerLocation)
    {
        return ledgerLocationMapper.updateLedgerLocation(ledgerLocation);
    }

    /**
     * 批量删除机柜地址
     * 
     * @param ids 需要删除的机柜地址主键
     * @return 结果
     */
    @Override
    public int deleteLedgerLocationByIds(Long[] ids)
    {
        return ledgerLocationMapper.deleteLedgerLocationByIds(ids);
    }

    /**
     * 删除机柜地址信息
     * 
     * @param id 机柜地址主键
     * @return 结果
     */
    @Override
    public int deleteLedgerLocationById(Long id)
    {
        return ledgerLocationMapper.deleteLedgerLocationById(id);
    }

    @Override
    public List<ElementOptions> getLocationOps() {
        List<ElementOptions> uniqueLocOps = ledgerLocationMapper.getLocationOps();
        return uniqueLocOps;
    }

    @Override
    public List<String> getDevList(Long id) {
        return ledgerDeviceMapper.getDevList(id);
    }

    @Override
    public String getLocQRcode(Long id) {
        List<String> qrinfo = getDevList(id);
        String name = ledgerLocationMapper.selectLedgerLocationById(id).getName();
        if (qrinfo==null ||qrinfo.size() == 0){
            throw new ServiceException("该机柜下暂无设备");
        }
        return generateDevQRCode((ArrayList<String>) qrinfo,name);
    }
}
