package com.bishe.yuanye.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Renhai on 2016/11/21.
 *
 * 自定义拦截器
 */
public class MyHandlerInterceptor implements HandlerInterceptor {
    //在handler之前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI().toString();
        if (requestURI.contains("login")){
            return true;
        }
        // a)拦截用户请求，判断用户是否登录
        Object user = request.getSession().getAttribute("user");
        if (user!=null){
            //根据用户类型拦截请求
           return true ;
        }
        // c)如果用户未登录，跳转到登录页面。
        response.sendRedirect(request.getContextPath() + "/html/login.html");
        return false;
    }

    //在handler返回 modelandview之前执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    //在handler返回 modelandview之后执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
