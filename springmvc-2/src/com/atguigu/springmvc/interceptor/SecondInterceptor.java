package com.atguigu.springmvc.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by miaomiao on 18-2-4.
 */
public class SecondInterceptor implements HandlerInterceptor {


    /**
     * 该方法在目标方法之前被调用
     * 若返回 true 则继续调用后续的拦截器，
     * 若返回 false 则不会再调用后续拦截器和目标方法
     *
     * 考虑做权限，日志，事务等等
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("[SecondInterceptor] preHandle");
        return true;
    }

    /**
     * 在目标方法之后，渲染视图之前调用
     *
     * 修改请求域中的属性或视图
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("[SecondInterceptor] postHandle");
    }

    /**
     *  渲染视图之后被调用
     *
     *  释放资源
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("[SecondInterceptor] afterCompletion");
    }
}
