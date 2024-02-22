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
import com.ruoyi.ledger.domain.LedgerPowerSupply;
import com.ruoyi.ledger.service.ILedgerPowerSupplyService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 电源详情Controller
 * 
 * @author disda
 * @date 2024-02-22
 */
@RestController
@RequestMapping("/ledger/supply")
public class LedgerPowerSupplyController extends BaseController
{
    @Autowired
    private ILedgerPowerSupplyService ledgerPowerSupplyService;

    /**
     * 查询电源详情列表
     */
    @PreAuthorize("@ss.hasPermi('ledger:supply:list')")
    @GetMapping("/list")
    public TableDataInfo list(LedgerPowerSupply ledgerPowerSupply)
    {
        startPage();
        List<LedgerPowerSupply> list = ledgerPowerSupplyService.selectLedgerPowerSupplyList(ledgerPowerSupply);
        return getDataTable(list);
    }

    /**
     * 导出电源详情列表
     */
    @PreAuthorize("@ss.hasPermi('ledger:supply:export')")
    @Log(title = "电源详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LedgerPowerSupply ledgerPowerSupply)
    {
        List<LedgerPowerSupply> list = ledgerPowerSupplyService.selectLedgerPowerSupplyList(ledgerPowerSupply);
        ExcelUtil<LedgerPowerSupply> util = new ExcelUtil<LedgerPowerSupply>(LedgerPowerSupply.class);
        util.exportExcel(response, list, "电源详情数据");
    }

    /**
     * 获取电源详情详细信息
     */
    @PreAuthorize("@ss.hasPermi('ledger:supply:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(ledgerPowerSupplyService.selectLedgerPowerSupplyById(id));
    }

    /**
     * 新增电源详情
     */
    @PreAuthorize("@ss.hasPermi('ledger:supply:add')")
    @Log(title = "电源详情", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LedgerPowerSupply ledgerPowerSupply)
    {
        return toAjax(ledgerPowerSupplyService.insertLedgerPowerSupply(ledgerPowerSupply));
    }

    /**
     * 修改电源详情
     */
    @PreAuthorize("@ss.hasPermi('ledger:supply:edit')")
    @Log(title = "电源详情", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LedgerPowerSupply ledgerPowerSupply)
    {
        return toAjax(ledgerPowerSupplyService.updateLedgerPowerSupply(ledgerPowerSupply));
    }

    /**
     * 删除电源详情
     */
    @PreAuthorize("@ss.hasPermi('ledger:supply:remove')")
    @Log(title = "电源详情", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(ledgerPowerSupplyService.deleteLedgerPowerSupplyByIds(ids));
    }
}
