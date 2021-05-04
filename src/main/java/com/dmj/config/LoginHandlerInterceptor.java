package com.dmj.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//拦截器
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登陆成功，就有用户的session
        Object loginUser = request.getSession().getAttribute("loginUser");//loginUser存在就证明已经登录了
        if (loginUser==null){//没有登录
            request.setAttribute("msg","没有权限访问，请先登录！");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;//返回回去，不许访问
        }else {
            return true;
        }
    }

}
