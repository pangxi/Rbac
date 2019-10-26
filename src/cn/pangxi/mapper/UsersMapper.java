package cn.pangxi.mapper;

import cn.pangxi.pojo.Users;
import org.apache.ibatis.annotations.Select;

/**
 * @author 庞小西
 * @date 2019/10/22 16:01
 */
public interface UsersMapper {
    @Select("select * from users where username = #{username} and password = #{password}")
    Users selByUser(Users users);
}
