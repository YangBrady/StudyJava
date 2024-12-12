package me.yangjun.study.config;

import lombok.extern.slf4j.Slf4j;
import me.yangjun.study.vo.MyResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

//@Component
@ControllerAdvice
@Slf4j
public class ResultAdvice implements ResponseBodyAdvice<Object> {
    /**
     * 判断是否需要装饰
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return ReqContext.getDecoration();
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        log.info("重写返回类型");
        return MyResult.success(body);
    }
}
