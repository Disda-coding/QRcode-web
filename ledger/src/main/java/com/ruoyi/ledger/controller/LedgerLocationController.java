package com.ruoyi.ledger.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.ledger.domain.LedgerLocation;
import com.ruoyi.ledger.service.ILedgerLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 机柜地址Controller
 * 
 * @author disda
 * @date 2024-02-22
 */
@RestController
@RequestMapping("/ledger/location")
public class LedgerLocationController extends BaseController
{
    @Autowired
    private ILedgerLocationService ledgerLocationService;


    @PreAuthorize("@ss.hasPermi('ledger:location:list')")
    @GetMapping("/getLocationOps")
    public AjaxResult getLocationOps()
    {
        return success(ledgerLocationService.getLocationOps());
    }


    /**
     * 获取机柜下面的设备名称
     * @return
     */
    @PreAuthorize("@ss.hasPermi('ledger:ip:query')")
    @GetMapping(value = "/getDevList/{id}")
    public AjaxResult getDevList(@PathVariable("id") Long id)
    {
        return success(ledgerLocationService.getDevList(id));
    }
    /**
     * 获取机柜的二维码信息
     * @return
     */
    @PreAuthorize("@ss.hasPermi('ledger:ip:query')")
    @GetMapping(value = "/getLocQRcode/{id}")
    public AjaxResult getLocQRcode(@PathVariable("id") Long id)
    {
        AjaxResult ajax = AjaxResult.success();
        ajax.put("img", ledgerLocationService.getLocQRcode(id));
        return ajax;

    }

    /**
     * 查询机柜地址列表
     */
    @PreAuthorize("@ss.hasPermi('ledger:location:list')")
    @GetMapping("/list")
    public TableDataInfo list(LedgerLocation ledgerLocation)
    {
        startPage();
        List<LedgerLocation> list = ledgerLocationService.selectLedgerLocationList(ledgerLocation);
        return getDataTable(list);
    }

    /**
     * 导出机柜地址列表
     */
    @PreAuthorize("@ss.hasPermi('ledger:location:export')")
    @Log(title = "机柜地址", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LedgerLocation ledgerLocation)
    {
        List<LedgerLocation> list = ledgerLocationService.selectLedgerLocationList(ledgerLocation);
        ExcelUtil<LedgerLocation> util = new ExcelUtil<LedgerLocation>(LedgerLocation.class);
        util.exportExcel(response, list, "机柜地址数据");
    }

    /**
     * 获取机柜地址详细信息
     */
    @PreAuthorize("@ss.hasPermi('ledger:location:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(ledgerLocationService.selectLedgerLocationById(id));
    }

    /**
     * 新增机柜地址
     */
    @PreAuthorize("@ss.hasPermi('ledger:location:add')")
    @Log(title = "机柜地址", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LedgerLocation ledgerLocation)
    {
        if(ledgerLocation.getName()== null||ledgerLocation.getName()=="") {
            return error("请填写机柜名");
        }
        return toAjax(ledgerLocationService.insertLedgerLocation(ledgerLocation));
    }

    /**
     * 修改机柜地址
     */
    @PreAuthorize("@ss.hasPermi('ledger:location:edit')")
    @Log(title = "机柜地址", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LedgerLocation ledgerLocation)
    {
        return toAjax(ledgerLocationService.updateLedgerLocation(ledgerLocation));
    }

    /**
     * 删除机柜地址
     */
    @PreAuthorize("@ss.hasPermi('ledger:location:remove')")
    @Log(title = "机柜地址", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(ledgerLocationService.deleteLedgerLocationByIds(ids));
    }
}
