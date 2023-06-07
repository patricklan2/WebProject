package org.lan.cinema.controller;

import org.lan.cinema.service.DealService;
import org.lan.cinema.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@CrossOrigin
public class DealController {
    @Resource
    DealService dealService;

    @RequestMapping("consume")
    public Result consume(String cardId,String name,int number){
        return Result.ok(dealService.consume(cardId,name,number));
    }

    @RequestMapping("recharge")
    public Result recharge(String cardId,int number){
        return Result.ok(dealService.recharge(cardId,number));
    }

    @RequestMapping("exchange")
    public Result exchange(String memberId, String name, int number){
        return Result.ok(dealService.exchangeGoods(memberId,name,number));
    }
}
