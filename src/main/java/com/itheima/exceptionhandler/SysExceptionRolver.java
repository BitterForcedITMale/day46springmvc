package com.itheima.exceptionhandler;

import com.itheima.exception.BusinessException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 自定义异常处理器
public class SysExceptionRolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();

        if (ex instanceof BusinessException){
            BusinessException businessException = (BusinessException) ex;
            modelAndView.addObject("code",businessException.getCode());
            modelAndView.addObject("msg",businessException.getMsg());
        }else {
                modelAndView.addObject("code",BusinessException.SYSTEM_ERROR_CODE);
                modelAndView.addObject("msg",BusinessException.SSYSTEM_ERROR_MSG);
        }
        modelAndView.setViewName("cuowu");
        return modelAndView;
    }
}
