package org.lan.cinema.controller;

import org.lan.cinema.pojo.Manager;
import org.lan.cinema.pojo.Member;
import org.lan.cinema.service.LoginService;
import org.lan.cinema.service.SelectService;
import org.lan.cinema.utils.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@CrossOrigin
@RestController
public class LoginController {
    @Resource
    SelectService selectService;
    @Resource
    LoginService loginService;

    @RequestMapping("getManagerData")
    public Result getManagerData(String managerId){
        return Result.ok(selectService.selectManagerByManagerId(managerId));
    }

    @RequestMapping("managerLogin")
    public Result managerLogin(String id, String password){
        Manager manager = selectService.selectManagerByManagerId(id);
        if (manager == null){
            return Result.ok(false);
        }
        if (manager.getPassword().equals(password)) {
            return Result.ok(true);
        }else{
            return Result.ok(false);
        }
    }

    @RequestMapping("memberLogin")
    public Result memberLogin(String id, String password){
        Member member = selectService.selectMemberByName(id);
        if (member == null){
            return Result.ok(false);
        }
        if (member.getPassword().equals(password)) {
            return Result.ok(true);
        }else{
            return Result.ok(false);
        }
    }
}
