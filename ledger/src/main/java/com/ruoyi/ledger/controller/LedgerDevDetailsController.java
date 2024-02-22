package com.ruoyi.ledger.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.ledger.domain.LedgerDevDetails;
import com.ruoyi.ledger.service.ILedgerDevDetailsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设备详情Controller
 * 
 * @author disda
 * @date 2024-02-22
 */
@RestController
@RequestMapping("/ledger/deviceDetails")
public class LedgerDevDetailsController extends BaseController
{
    @Autowired
    private ILedgerDevDetailsService ledgerDevDetailsService;

    /**
     * 查询设备详情列表
     */
    @PreAuthorize("@ss.hasPermi('ledger:deviceDetails:list')")
    @GetMapping("/list")
    public TableDataInfo list(LedgerDevDetails ledgerDevDetails)
    {
        startPage();
        List<LedgerDevDetails> list = ledgerDevDetailsService.selectLedgerDevDetailsList(ledgerDevDetails);
        return getDataTable(list);
    }

    /**
     * 导出设备详情列表
     */
    @PreAuthorize("@ss.hasPermi('ledger:deviceDetails:export')")
    @Log(title = "设备详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LedgerDevDetails ledgerDevDetails)
    {
        List<LedgerDevDetails> list = ledgerDevDetailsService.selectLedgerDevDetailsList(ledgerDevDetails);
        ExcelUtil<LedgerDevDetails> util = new ExcelUtil<LedgerDevDetails>(LedgerDevDetails.class);
        util.exportExcel(response, list, "设备详情数据");
    }

    /**
     * 获取设备详情详细信息
     */
    @PreAuthorize("@ss.hasPermi('ledger:deviceDetails:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(ledgerDevDetailsService.selectLedgerDevDetailsById(id));
    }

    /**
     * 新增设备详情
     */
    @PreAuthorize("@ss.hasPermi('ledger:deviceDetails:add')")
    @Log(title = "设备详情", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LedgerDevDetails ledgerDevDetails)
    {
        return toAjax(ledgerDevDetailsService.insertLedgerDevDetails(ledgerDevDetails));
    }

    /**
     * 修改设备详情
     */
    @PreAuthorize("@ss.hasPermi('ledger:deviceDetails:edit')")
    @Log(title = "设备详情", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LedgerDevDetails ledgerDevDetails)
    {
        return toAjax(ledgerDevDetailsService.updateLedgerDevDetails(ledgerDevDetails));
    }

    /**
     * 删除设备详情
     */
    @PreAuthorize("@ss.hasPermi('ledger:deviceDetails:remove')")
    @Log(title = "设备详情", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(ledgerDevDetailsService.deleteLedgerDevDetailsByIds(ids));
    }
}