package com.ruoyi.ledger.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.ledger.domain.LedgerDevIp;
import com.ruoyi.ledger.service.ILedgerDevIpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 设备ip映射Controller
 * 
 * @author disda
 * @date 2024-02-22
 */
@RestController
@RequestMapping("/ledger/devIp")
public class LedgerDevIpController extends BaseController
{
    @Autowired
    private ILedgerDevIpService ledgerDevIpService;

    /**
     * 查询设备ip映射列表
     */
    @PreAuthorize("@ss.hasPermi('ledger:ip:list')")
    @GetMapping("/list")
    public TableDataInfo list(LedgerDevIp ledgerDevIp)
    {
        startPage();
        List<LedgerDevIp> list = ledgerDevIpService.selectLedgerDevIpList(ledgerDevIp);
        return getDataTable(list);
    }

    /**
     * 导出设备ip映射列表
     */
    @PreAuthorize("@ss.hasPermi('ledger:ip:export')")
    @Log(title = "设备ip映射", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LedgerDevIp ledgerDevIp)
    {
        List<LedgerDevIp> list = ledgerDevIpService.selectLedgerDevIpList(ledgerDevIp);
        ExcelUtil<LedgerDevIp> util = new ExcelUtil<LedgerDevIp>(LedgerDevIp.class);
        util.exportExcel(response, list, "设备ip映射数据");
    }

    /**
     * 获取设备ip映射详细信息
     */
    @PreAuthorize("@ss.hasPermi('ledger:ip:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(ledgerDevIpService.selectLedgerDevIpById(id));
    }

    /**
     * 新增设备ip映射
     */
    @PreAuthorize("@ss.hasPermi('ledger:ip:add')")
    @Log(title = "设备ip映射", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LedgerDevIp ledgerDevIp)
    {
        return toAjax(ledgerDevIpService.insertLedgerDevIp(ledgerDevIp));
    }

    /**
     * 修改设备ip映射
     */
    @PreAuthorize("@ss.hasPermi('ledger:ip:edit')")
    @Log(title = "设备ip映射", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LedgerDevIp ledgerDevIp)
    {
        return toAjax(ledgerDevIpService.updateLedgerDevIp(ledgerDevIp));
    }

    /**
     * 删除设备ip映射
     */
    @PreAuthorize("@ss.hasPermi('ledger:ip:remove')")
    @Log(title = "设备ip映射", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(ledgerDevIpService.deleteLedgerDevIpByIds(ids));
    }
}
