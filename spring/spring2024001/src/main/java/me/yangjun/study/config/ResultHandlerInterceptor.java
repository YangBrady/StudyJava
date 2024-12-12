package me.yangjun.study.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
@Slf4j
public class ResultHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.info("进入拦截器");
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Class<?> beanType = handlerMethod.getBeanType();
            if (beanType.isAnnotationPresent(ResultDecoration.class)) {
                log.info("识别到类上有装饰注解");
                ReqContext.setDecoration();
            }
            Method method = handlerMethod.getMethod();
            if (method.isAnnotationPresent(ResultDecoration.class)) {
                log.info("识别到方法上有装饰注解");
                ReqContext.setDecoration();
            }
        }
        return true;
    }
}
