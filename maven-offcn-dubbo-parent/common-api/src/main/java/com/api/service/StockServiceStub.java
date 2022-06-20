package com.api.service;

public class StockServiceStub implements StockService{
    private StockService stockService;

    public StockServiceStub(StockService stockService) {
        this.stockService = stockService;
    }

    @Override
    public String hello(String message) {
        try {
            return stockService.hello(message);
        } catch (Exception e) {
            return "数据发生错误了，走丢了 "+message;
        }
    }
}
