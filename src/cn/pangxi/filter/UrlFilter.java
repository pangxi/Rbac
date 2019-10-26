package cn.pangxi.filter;

import cn.pangxi.pojo.Url;
import cn.pangxi.pojo.Users;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author 庞小西
 * @date 2019/10/22 19:10
 */
public class UrlFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        //js css放行  图片
        HttpServletRequest request=(HttpServletRequest)req;
        String uri = request.getRequestURI();
        if(uri.endsWith(".js")||uri.endsWith(".css")||uri.endsWith(".html")||uri.endsWith(".jpg")||uri.endsWith(".png")||uri.endsWith(".gif")){
            filterChain.doFilter(req, res);
        }else{
            if(uri.equals("/Rbac_war_exploded/login")||uri.equals("/Rbac_war_exploded/index.jsp")){
                filterChain.doFilter(req, res);
            }else{
                HttpSession session = request.getSession();
                //登录验证
                Object obj = session.getAttribute("user");
                if(obj!=null){
                    List<Url> listUrl = (List<Url>) session.getAttribute("allurl");
                    boolean isExists=false;
                    for (Url url : listUrl) {
                        if(url.getName().equals(uri)){
                            isExists = true;
                        }
                    }
                    //如果该url需要进行权限控制
                    if(isExists){
                        Users users = (Users) obj;
                        boolean isRight = false;
                        for (Url url : users.getUrls()) {
                            if(url.getName().equals(uri)){
                                isRight = true;
                            }
                        }
                        //登录用户对该uri具有访问权限
                        if(isRight){
                            filterChain.doFilter(req, res);
                        }else{
                            //清除sessin中内容
                            session.removeAttribute("user");
                            session.removeAttribute("allurl");
                            ((HttpServletResponse)res).sendRedirect("/Rbac_war_exploded/index.jsp");
                        }
                    }else{
                        filterChain.doFilter(req, res);
                    }
                }else{
                    //没有登录
                    ((HttpServletResponse)res).sendRedirect("/Rbac_war_exploded/index.jsp");
                }
            }
        }
    }

    @Override
    public void destroy() {

    }
}
