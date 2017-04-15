package com.bishe.yuanye.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

/**
 * Created by yuanye on 2017/2/23.
 */
public class TimeInterceptor extends HandlerInterceptorAdapter {

    // 继承HandlerInterceptorAdapter类

    private int openingTime; // openingTime 属性指定开放时间
    private int closingTime; // closingTime属性指定关闭时间
    private String outsideOfficeHoursPage;// outsideOfficeHoursPage属性指定错误提示页面的URL

    // 重写 preHandle()方法，在业务处理器处理请求之前对该请求进行拦截处理
    public boolean preHandle(HttpServletRequest request,
							 HttpServletResponse response, Object handler) throws Exception {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY); // 获取当前时间
        if (openingTime <= hour && hour < closingTime) { // 判断当前是否处于工作时间段内
            return true;
        } else {
            response.sendRedirect(outsideOfficeHoursPage); // 返回提示页面
            return false;
        }
    }

    public void postHandle(HttpServletRequest request,
						   HttpServletResponse response, Object o, ModelAndView mav)
            throws Exception {
        System.out.println("postHandle");
    }

    public void afterCompletion(HttpServletRequest request,
								HttpServletResponse response, Object o, Exception excptn)
            throws Exception {
        System.out.println("afterCompletion");
    }

    public int getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(int openingTime) {
        this.openingTime = openingTime;
    }

    public int getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(int closingTime) {
        this.closingTime = closingTime;
    }

    public String getOutsideOfficeHoursPage() {
        return outsideOfficeHoursPage;
    }

    public void setOutsideOfficeHoursPage(String outsideOfficeHoursPage) {
        this.outsideOfficeHoursPage = outsideOfficeHoursPage;
    }

}

