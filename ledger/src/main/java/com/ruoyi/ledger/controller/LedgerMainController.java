package com.ruoyi.ledger.controller;

import com.ruoyi.ledger.service.ILedgerMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: qrcode-ruoyi
 * @description: 用于显示所有设备的Controller
 * @author: Disda
 * @create: 2024-02-22 09:59
 */
@RestController
@RequestMapping("/ledger/main")
public class LedgerMainController {
    @Autowired
    private ILedgerMainService ledgerMainService;
}