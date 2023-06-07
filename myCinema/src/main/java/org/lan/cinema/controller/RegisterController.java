package org.lan.cinema.controller;

import org.lan.cinema.pojo.Good;
import org.lan.cinema.pojo.Movie;
import org.lan.cinema.service.CUDService;
import org.lan.cinema.utils.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@CrossOrigin
@RestController
public class RegisterController {
    @Resource
    CUDService cudService;
    @RequestMapping("registerMember")
    public Result registerMember(String name, String password, String sex, String birthday){
        return Result.ok(cudService.registerMember(name,password,sex,birthday));
    }

    @RequestMapping("registerCard")
    public Result registerCard(String memberId, int grade){
        return Result.ok(cudService.registerCard(memberId,grade));
    }

    @RequestMapping("addMovie")
    public Result addMovie(Movie movie){
        return Result.ok(cudService.insertMovie(movie));
    }

    @RequestMapping("addGood")
    public Result addGood(Good good){
        return Result.ok(cudService.addGood(good));
    }

    @RequestMapping("deleteMember")
    public Result deleteMember(String memberId){
        return Result.ok(cudService.deleteMember(memberId));
    }

    @RequestMapping("deleteGood")
    public Result deleteGood(String name){
        return Result.ok(cudService.deleteGood(name));
    }

    @RequestMapping("deleteMovie")
    public Result deleteMovie(String name){
        return Result.ok(cudService.deleteMovie(name));
    }
}
