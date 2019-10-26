package cn.pangxi.controller;

import cn.pangxi.pojo.Users;
import cn.pangxi.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author 庞小西
 * @date 2019/10/22 16:12
 */
@Controller
public class UserController {
    @Resource
    private UsersService usersServiceImpl;
    @RequestMapping("login")
    public String login(Users users, HttpSession session){

        Map<String,Object> map = usersServiceImpl.login(users);
        if (map.get("user")!=null){
            session.setAttribute("user",map.get("user"));
            session.setAttribute("allurl",map.get("allurl"));
//            return "showAllUrl";
            return "redirect:/main.jsp";
        }
        return "redirect:/index.jsp";
    }

    @RequestMapping("demo")
    public String demo(){
        System.out.println("执行demo");
       return "main.jsp" ;
    }
}
