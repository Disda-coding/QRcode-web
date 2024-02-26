package com.ruoyi.ledger.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.ledger.domain.LedgerIp;
import com.ruoyi.ledger.service.ILedgerIpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * ip地址Controller
 * 
 * @author disda
 * @date 2024-02-22
 */
@RestController
@RequestMapping("/ledger/ip")
public class LedgerIpController extends BaseController
{
    @Autowired
    private ILedgerIpService ledgerIpService;

    /**
     * 查询所有ip类型
     * @return
     */
    @PreAuthorize("@ss.hasPermi('ledger:ip:query')")
    @GetMapping(value = "/getIpTypeOps")
    public AjaxResult getIpTypeOps()
    {
        return success(ledgerIpService.getIpTypeOps());
    }

    @PreAuthorize("@ss.hasPermi('ledger:ip:query')")
    @GetMapping(value = "/getIpDevOptions")
    public AjaxResult getIpDevOptions()
    {
        return success(ledgerIpService.getIpDevOptions());
    }




    /**
     * 查询ip地址列表
     */
    @PreAuthorize("@ss.hasPermi('ledger:ip:list')")
    @GetMapping("/list")
    public TableDataInfo list(LedgerIp ledgerIp)
    {
        startPage();
        List<LedgerIp> list = ledgerIpService.selectLedgerIpList(ledgerIp);
        return getDataTable(list);
    }

    /**
     * 导出ip地址列表
     */
    @PreAuthorize("@ss.hasPermi('ledger:ip:export')")
    @Log(title = "ip地址", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LedgerIp ledgerIp)
    {
        List<LedgerIp> list = ledgerIpService.selectLedgerIpList(ledgerIp);
        ExcelUtil<LedgerIp> util = new ExcelUtil<LedgerIp>(LedgerIp.class);
        util.exportExcel(response, list, "ip地址数据");
    }

    /**
     * 获取ip地址详细信息
     */
    @PreAuthorize("@ss.hasPermi('ledger:ip:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(ledgerIpService.selectLedgerIpById(id));
    }

    /**
     * 新增ip地址
     */
    @PreAuthorize("@ss.hasPermi('ledger:ip:add')")
    @Log(title = "ip地址", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LedgerIp ledgerIp)
    {
        return toAjax(ledgerIpService.insertLedgerIp(ledgerIp));
    }

    /**
     * 修改ip地址
     */
    @PreAuthorize("@ss.hasPermi('ledger:ip:edit')")
    @Log(title = "ip地址", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LedgerIp ledgerIp)
    {
        return toAjax(ledgerIpService.updateLedgerIp(ledgerIp));
    }

    /**
     * 删除ip地址
     */
    @PreAuthorize("@ss.hasPermi('ledger:ip:remove')")
    @Log(title = "ip地址", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(ledgerIpService.deleteLedgerIpByIds(ids));
    }
}
