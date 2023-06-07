package org.lan.cinema.controller;

import org.lan.cinema.pojo.CareInfo;
import org.lan.cinema.pojo.Good;
import org.lan.cinema.pojo.Member;
import org.lan.cinema.pojo.Movie;
import org.lan.cinema.service.CUDService;
import org.lan.cinema.service.CardService;
import org.lan.cinema.service.CareService;
import org.lan.cinema.utils.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@CrossOrigin
@RestController
public class ModifyController {
    @Resource
    CareService careService;
    @Resource
    CUDService cudService;
    @Resource
    CardService cardService;

    @RequestMapping("modifyMovie")
    public Result updateMovie(Movie movie){
        return Result.ok(cudService.updateMovie(movie));
    }

    @RequestMapping("modifyGood")
    public Result modifyGood(Good good){
        return Result.ok(cudService.modifyGood(good));
    }

    @RequestMapping("modifyMember")
    public Result modifyMember(Member member){
        return Result.ok(cudService.modifyMember(member));
    }

    @RequestMapping("cardCancel")
    public Result handleCancel(String cardId){
        return Result.ok(cardService.handleCancel(cardId));
    }

    @RequestMapping("cardLose")
    public Result handleLose(String cardId){
        System.out.println(cardId);
        return Result.ok(cardService.handleLose(cardId));
    }

    @RequestMapping("setGradeInfo")
    public Result setGradeInfo(String grade_1, String grade_2, String grade_3){
        return Result.ok(careService.setGradeInfo(grade_1,grade_2,grade_3));
    }

    @RequestMapping("setBlessing")
    public Result setBlessing(String blessing){
        return Result.ok(careService.setBlessing(blessing));
    }
}
