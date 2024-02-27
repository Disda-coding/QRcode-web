package com.ruoyi.ledger.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.ledger.domain.LedgerDevice;
import com.ruoyi.ledger.domain.vo.LedgerDeviceVO;
import com.ruoyi.ledger.service.ILedgerDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 设备信息Controller
 * 
 * @author disda
 * @date 2024-02-22
 */
@RestController
@RequestMapping("/ledger/device")
public class LedgerDeviceController extends BaseController
{
    @Autowired
    private ILedgerDeviceService ledgerDeviceService;

    /**
     * 查询设备信息列表
     */
    @PreAuthorize("@ss.hasPermi('ledger:device:list')")
    @GetMapping("/list")
    public TableDataInfo list(LedgerDeviceVO ledgerDeviceVo)
    {
        startPage();
        List<LedgerDeviceVO> list = ledgerDeviceService.selectLedgerDeviceList(ledgerDeviceVo);
        return getDataTable(list);
    }

    /**
     * 导出设备信息列表
     */
    @PreAuthorize("@ss.hasPermi('ledger:device:export')")
    @Log(title = "设备信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LedgerDeviceVO ledgerDeviceVO)
    {
        List<LedgerDeviceVO> list = ledgerDeviceService.selectLedgerDeviceList(ledgerDeviceVO);
        ExcelUtil<LedgerDeviceVO> util = new ExcelUtil<LedgerDeviceVO>(LedgerDeviceVO.class);
        util.exportExcel(response, list, "设备信息数据");
    }

    /**
     * 获取设备信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('ledger:device:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(ledgerDeviceService.selectLedgerDeviceById(id));
    }

    /**
     * 新增设备信息
     */
    @PreAuthorize("@ss.hasPermi('ledger:device:add')")
    @Log(title = "设备信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LedgerDevice ledgerDevice)
    {
        return toAjax(ledgerDeviceService.insertLedgerDevice(ledgerDevice));
    }

    /**
     * 修改设备信息
     */
    @PreAuthorize("@ss.hasPermi('ledger:device:edit')")
    @Log(title = "设备信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LedgerDevice ledgerDevice)
    {
        return toAjax(ledgerDeviceService.updateLedgerDevice(ledgerDevice));
    }

    /**
     * 删除设备信息
     */
    @PreAuthorize("@ss.hasPermi('ledger:device:remove')")
    @Log(title = "设备信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(ledgerDeviceService.deleteLedgerDeviceByIds(ids));
    }
}
