package cn.pangxi.mapper;

import cn.pangxi.pojo.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 庞小西
 * @date 2019/10/22 16:30
 */
public interface MenuMapper {
    List<Menu> selByRid(@Param("rid") int rid , @Param("pid")int pid);
}
