package cn.pangxi.service.impl;

import cn.pangxi.mapper.MenuMapper;
import cn.pangxi.pojo.Menu;
import cn.pangxi.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 庞小西
 * @date 2019/10/22 16:54
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuMapper menuMapper;
    @Override
    public List<Menu> showMenu(int rid) {
        return menuMapper.selByRid(rid,0);
    }
}
