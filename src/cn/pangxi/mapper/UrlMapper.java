package cn.pangxi.mapper;

import cn.pangxi.pojo.Url;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 庞小西
 * @date 2019/10/22 18:49
 */
public interface UrlMapper {
    @Select("select * from url where id in (select uid from role_url where rid=#{rid})")
    List<Url> selByRid(int rid);
    /**
     * 查询全部
     * @return
     */
    @Select("select * from url")
    List<Url> selAll();
}
