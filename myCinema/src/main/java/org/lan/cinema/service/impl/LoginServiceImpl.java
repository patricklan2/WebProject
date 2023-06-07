package org.lan.cinema.service.impl;

import org.lan.cinema.mapper.ManagerMapper;
import org.lan.cinema.pojo.Manager;
import org.lan.cinema.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author zrk
 * @version 1.0
 * @date 2020/5/1 0001 11:45
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    ManagerMapper managerMapper;

    @Override
    public Manager managerLogin(String managerId, String password) {

//        Manager manager = managerMapper.managerLogin(managerId,password);
//        if(manager!=null){
//            managerMapper.updateManagerTime(manager.getManagerId());
//            return manager;
//        }
        return null;
    }
}
