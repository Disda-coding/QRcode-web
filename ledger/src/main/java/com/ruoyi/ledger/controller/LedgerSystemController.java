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
import com.ruoyi.ledger.domain.LedgerSystem;
import com.ruoyi.ledger.service.ILedgerSystemService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 操作系统Controller
 * 
 * @author disda
 * @date 2024-02-23
 */
@RestController
@RequestMapping("/ledger/sys")
public class LedgerSystemController extends BaseController
{
    @Autowired
    private ILedgerSystemService ledgerSystemService;

    /**
     * 查询操作系统列表
     */
    @PreAuthorize("@ss.hasPermi('ledger:sys:list')")
    @GetMapping("/list")
    public TableDataInfo list(LedgerSystem ledgerSystem)
    {
        startPage();
        List<LedgerSystem> list = ledgerSystemService.selectLedgerSystemList(ledgerSystem);
        return getDataTable(list);
    }

    /**
     * 导出操作系统列表
     */
    @PreAuthorize("@ss.hasPermi('ledger:sys:export')")
    @Log(title = "操作系统", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LedgerSystem ledgerSystem)
    {
        List<LedgerSystem> list = ledgerSystemService.selectLedgerSystemList(ledgerSystem);
        ExcelUtil<LedgerSystem> util = new ExcelUtil<LedgerSystem>(LedgerSystem.class);
        util.exportExcel(response, list, "操作系统数据");
    }

    /**
     * 获取操作系统详细信息
     */
    @PreAuthorize("@ss.hasPermi('ledger:sys:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(ledgerSystemService.selectLedgerSystemById(id));
    }

    /**
     * 新增操作系统
     */
    @PreAuthorize("@ss.hasPermi('ledger:sys:add')")
    @Log(title = "操作系统", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LedgerSystem ledgerSystem)
    {
        return toAjax(ledgerSystemService.insertLedgerSystem(ledgerSystem));
    }

    /**
     * 修改操作系统
     */
    @PreAuthorize("@ss.hasPermi('ledger:sys:edit')")
    @Log(title = "操作系统", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LedgerSystem ledgerSystem)
    {
        return toAjax(ledgerSystemService.updateLedgerSystem(ledgerSystem));
    }

    /**
     * 删除操作系统
     */
    @PreAuthorize("@ss.hasPermi('ledger:sys:remove')")
    @Log(title = "操作系统", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(ledgerSystemService.deleteLedgerSystemByIds(ids));
    }
}
