package cn.pangxi.service;


import cn.pangxi.pojo.Users;

import java.util.Map;

/**
 * @author 庞小西
 * @date 2019/10/22 16:07
 */
public interface UsersService {
//    Users login(Users users);
    Map<String,Object> login(Users users);
}

