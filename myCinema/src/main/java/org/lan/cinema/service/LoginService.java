package org.lan.cinema.service;

import org.lan.cinema.pojo.Manager;

/**
 * @author zrk
 * @version 1.0
 * @date 2020/5/1 0001 11:45
 */
public interface LoginService {
   Manager managerLogin(String managerId,String password);
}
