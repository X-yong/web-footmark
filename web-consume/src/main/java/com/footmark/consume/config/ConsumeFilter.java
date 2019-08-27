package com.footmark.consume.config;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;
/*
 * @Description : 请求过滤器
 * @Author : xiongyong
 * @Date : 2018/5/29
 */


@WebFilter(filterName = "ConsumeFilter", urlPatterns = {"/*"})
@Log
public class ConsumeFilter implements Filter {

    @Autowired
    private RedisService redisService;

    @Override
    public void init(FilterConfig filterConfig)  {
        log.info("-----------------过滤器初始化----------------->");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        log.info("请求{}：IP:"+servletRequest.getRemoteAddr()+"---->"+((HttpServletRequest) servletRequest).getRequestURI());
        Map<String,String[]> pmap = servletRequest.getParameterMap();

        if (pmap != null) {
            pmap.forEach((k,v) -> {
                log.info("param:"+k+"---->"+v[0]);
            });
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        log.info("-----------------过滤器销毁-----------------》");
    }
}
