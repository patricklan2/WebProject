package org.lan.cinema.controller;

import org.lan.cinema.service.CareService;
import org.lan.cinema.service.SelectService;
import org.lan.cinema.service.StatisticService;
import org.lan.cinema.utils.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@CrossOrigin
@RestController
public class SelectController {
    @Resource
    SelectService selectService;
    @Resource
    StatisticService statisticService;
    @Resource
    CareService careService;

    @RequestMapping("selectManagerByManagerId")
    public Result selectManagerByManagerId(String managerId){
        return Result.ok(selectService.selectManagerByManagerId(managerId));
    }

    @RequestMapping("getDealData")
    public Result getDealData(){
        return Result.ok(statisticService.getDealData());
    }

    @RequestMapping("getStatisticData")
    public Result getStatisticData(){
        return Result.ok(statisticService.getStatisticData());
    }

    @RequestMapping("selectAllMovie")
    public Result selectAllMovie(String pageIndex, String pageSize){
        return Result.ok(selectService.selectAllMovie(pageIndex,pageSize));
    }

    @RequestMapping("selectAllGood")
    public Result selectAllGood(String pageIndex, String pageSize){
        return Result.ok(selectService.selectAllGood(pageIndex,pageSize));
    }

    @RequestMapping("selectAllMember")
    public Result selectAllMember(String pageIndex, String pageSize){
        return Result.ok(selectService.selectAllMember(pageIndex,pageSize));
    }

    @RequestMapping("selectAllCard")
    public Result selectAllCard(String pageIndex, String pageSize){
        return Result.ok(selectService.selectAllCard(pageIndex,pageSize));
    }

    @RequestMapping("selectAllConsumeRecord")
    public Result selectAllConsumeRecord(String pageIndex, String pageSize){
        return Result.ok(selectService.selectAllConsumeRecord(pageIndex,pageSize));
    }

    @RequestMapping("selectAllExchangeRecord")
    public Result selectAllExchangeRecord(String pageIndex, String pageSize){
        return Result.ok(selectService.selectAllExchangeRecord(pageIndex,pageSize));
    }


    @RequestMapping("selectMemberByCondition")
    public Result selectMemberByCondition(String pageIndex, String pageSize, String name, String birthdayType){
        return Result.ok(selectService.selectMemberByCondition(pageIndex,pageSize,name,birthdayType));
    }

    @RequestMapping("selectCardByCondition")
    public Result selectCardByCondition(String pageIndex, String pageSize, String memberId, String name, String cardId){
        return Result.ok(selectService.selectCardByCondition(pageIndex,pageSize,memberId,name,cardId));
    }

    @RequestMapping("selectCardByMemberId")
    public Result selectCardByMemberId(String memberId){
        return Result.ok(selectService.selectCardByMemberId(memberId));
    }

    @RequestMapping("selectAllCareInfo")
    public Result selectAllCareInfo(){
        return Result.ok(careService.selectAll());
    }

    @RequestMapping("flushCareInfo")
    public Result flushCareInfo(){
        return Result.ok(careService.flushAll());
    }

    @RequestMapping("getMemberAllInfo")
    public Result getMemberAllInfo(String name){
        System.out.println(name);
        return Result.ok(selectService.getMemberAllInfo(name));
    }
}
