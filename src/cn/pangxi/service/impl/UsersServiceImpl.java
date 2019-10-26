package cn.pangxi.service.impl;

import cn.pangxi.mapper.MenuMapper;
import cn.pangxi.mapper.UsersMapper;
import cn.pangxi.pojo.Users;
import cn.pangxi.service.ElementService;
import cn.pangxi.service.MenuService;
import cn.pangxi.service.UrlService;
import cn.pangxi.service.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 庞小西
 * @date 2019/10/22 16:08
 */
@Service
public class UsersServiceImpl implements UsersService {
    @Resource
    private UsersMapper usersMapper;
    @Resource
    private MenuService menuServiceImpl;
    @Resource
    private ElementService elementServiceImpl;
    @Resource
    private UrlService urlServiceImpl;
//    @Override
//    public Users login(Users users) {
//        Users user = usersMapper.selByUser(users);
//        user.setMenus(menuServiceImpl.showMenu(user.getRid()));
//        user.setElements(elementServiceImpl.selByRid(user.getRid()));
//        user.setUrls(urlServiceImpl.selByRid(user.getRid()));
//        return user;
//    }
    @Override
    public Map<String,Object> login(Users users) {
        Map<String,Object> map = new HashMap<>();
        Users user = usersMapper.selByUser(users);
        if (user!=null){
            user.setMenus(menuServiceImpl.showMenu(user.getRid()));
            user.setElements(elementServiceImpl.selByRid(user.getRid()));
            user.setUrls(urlServiceImpl.selByRid(user.getRid()));
            map.put("allurl", urlServiceImpl.showAll());
        }
        map.put("user", user);
        return map;
    }
}
