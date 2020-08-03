package com.itheima.web.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Intercepter01 implements HandlerInterceptor {
    @Override
    //在达到目标方法之前执行(拦截的方法)
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws IOException {
        System.out.println("Intercepter01 收到了请求...");
        // 重定向
        // 转发
        //request.getRequestDispatcher("").forward(request, response);

//        response.sendRedirect("success");
        return true;//返回true放行, 返回false拦截
    }
}
