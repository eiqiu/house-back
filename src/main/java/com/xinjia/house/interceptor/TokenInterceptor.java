package com.xinjia.house.interceptor;

import com.alibaba.fastjson.JSON;
import com.xinjia.house.util.JWTUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String method = request.getMethod();
        if(method.equals(HttpMethod.OPTIONS.name())){
            return true;
        }
        String token = request.getHeader("token");
        int status = 0;
        String msg = "";
        JWTUtils.verify(token);
        status = 200;
        msg = "验证成功";
        Map<String, String> res = new HashMap<>();
        res.put("status", String.valueOf(status));
        res.put("msg", msg);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(JSON.toJSONString(res));
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
