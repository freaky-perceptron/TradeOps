package com.group22.back_end.controllers;

import com.group22.back_end.exception.ResourceNotFoundException;
import com.group22.back_end.models.Security;
import com.group22.back_end.models.Trade;
import com.group22.back_end.services.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/trades")
public class TradeController {

    private TradeService tradeService;

    @Autowired
    public TradeController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @GetMapping("/get")
    public ResponseEntity getAllTrades() {
        System.out.println("/trades/get: retrieving all trades");
        List<Trade> response = tradeService.getAllTrades();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("get/{tradeId}")
    public ResponseEntity getTradeById(@PathVariable int tradeId) {
        System.out.println("/trades/get?Id: retrieving a by Id");
        List<Trade> response = tradeService.getTradeById(tradeId);
        return ResponseEntity.ok().body((response));
    }

    @GetMapping("get/security/{tradeId}")
    public ResponseEntity getSecurityByTradeId(@PathVariable int tradeId) {
        System.out.println("/trades/get/security?Id: retrieving security by tradeId");
        List<Security> response = tradeService.getSecurityByTradeId(tradeId);
        return ResponseEntity.ok().body(response);
    }


    @PostMapping("/add")
    public Trade addTrade(@RequestBody Trade trade) {
        return tradeService.addTrade(trade);
    }

    @PutMapping("/update/")
    public void updateTrade(@RequestBody Trade trade) throws ResourceNotFoundException{
        tradeService.updateTrade(trade);
    }

    @DeleteMapping("/delete/{tradeId}")
    public void deleteTrade(@PathVariable int tradeId) throws ResourceNotFoundException {
        tradeService.deleteTradeById(tradeId);
    }


}
