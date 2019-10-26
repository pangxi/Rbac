package cn.pangxi.service;

import cn.pangxi.pojo.Menu;

import java.util.List;

/**
 * @author 庞小西
 * @date 2019/10/22 16:54
 */
public interface MenuService {
    List<Menu> showMenu(int rid);
}
