package cn.pangxi.controller;

import cn.pangxi.service.UrlService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 庞小西
 * @date 2019/10/22 19:03
 */
@Controller
public class UrlController {
    @Resource
    private UrlService urlServiceImpl;
    @RequestMapping("showAllUrl")
    public String showAll(){
        return "redirect:/main.jsp";
    }
}
