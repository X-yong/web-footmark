package com.footmark.portal.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
 * @Description : 请求过滤器
 * @Author : xiongyong
 * @Date : 2018/5/29
 */


@WebFilter(filterName = "PortalFilter", urlPatterns = {"/web-portal/*"})
public class PortalFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(PortalFilter.class);
    private final static ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private RedisService redisService;

    @Override
    public void init(FilterConfig filterConfig)  {
        System.out.println("-----------------过滤器初始化-----------------》");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("-----------------执行过滤操作-----------------》");

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        ServletRequest requestWrapper = new BodyReaderHttpServletRequestWrapper(httpServletRequest);
       /* InterfaceResult interfaceResult = new InterfaceResult();
        try {
            //获取header参数
            String token = httpServletRequest.getHeader("token");
            if (StringUtils.isNotEmpty(token)&&redisService.hasKey(token)){
                if (redisService.get(token) == null) {
                    httpServletResponse.setHeader("Content-type", "application/json;charset=UTF-8");

                    PrintWriter pw = httpServletResponse.getWriter();
                    interfaceResult.setCode("000");
                    interfaceResult.setMsg("token过期，请重新登录");

                    pw.write(objectMapper.writeValueAsString(interfaceResult));
                    logger.error("token过期，请重新登录");
                    return;
                }

            } else {
                throw new RuntimeException("系统异常");
            }

        } catch (Exception e) {
            logger.error(e.toString());
            httpServletResponse.setHeader("Content-type", "application/json;charset=UTF-8");
            interfaceResult.setCode("000");
            interfaceResult.setMsg("系统异常");

            PrintWriter pw = (servletResponse).getWriter();
            pw.write(objectMapper.writeValueAsString(interfaceResult));
            return;
        }*/
        filterChain.doFilter(requestWrapper, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("-----------------过滤器销毁-----------------》");
    }
}
