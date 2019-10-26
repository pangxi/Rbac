package cn.pangxi.mapper;

import cn.pangxi.pojo.Element;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 庞小西
 * @date 2019/10/22 17:42
 */
public interface ElementMapper {
    @Select("select * from element where id in (select eid from role_element where rid=#{rid})")
    List<Element> selByRid(int rid);
}
