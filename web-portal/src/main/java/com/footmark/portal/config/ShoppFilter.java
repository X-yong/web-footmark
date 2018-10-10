/*
package com.footmark.portal.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

*/
/**
 * @Description : 请求过滤器
 * @Author : xiongyong
 * @Date : 2018/5/29
 *//*


@WebFilter(filterName = "ShoppFilter", urlPatterns = {"/dpca-shopp/*"})
public class ShoppFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(ShoppFilter.class);
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
        InterfaceResult interfaceResult = new InterfaceResult();
        try {
            //获取header参数
            String token = httpServletRequest.getHeader("token");
            if (StringUtils.isNoneBlank(token)&&redisService.hasKey(token)){
                if (redisService.get(token) == null) {
                    httpServletResponse.setHeader("Content-type", "application/json;charset=UTF-8");

                    PrintWriter pw = httpServletResponse.getWriter();
                    interfaceResult.setCode(ResultEnum.TOKEN_INVALID_ERROR.getCode());
                    interfaceResult.setMsg(ResultEnum.TOKEN_INVALID_ERROR.getMessage());

                    pw.write(objectMapper.writeValueAsString(interfaceResult));
                    logger.error("token过期，请重新登录");
                    return;
                }
                try {
                    NtspAppUserinfo ntspAppUserinfo = (NtspAppUserinfo) redisService.get(token);
                }catch (ClassCastException e){
                    redisService.expire(token,600);
                }
            }else{
                if((!httpServletRequest.getRequestURI().contains("/dpca-shopp/user/login"))&&(!httpServletRequest.getRequestURI().contains("/dpca-shopp/user/logout"))&&(!httpServletRequest.getRequestURI().contains("/dpca-shopp/user/app/login"))){
                    httpServletResponse.setHeader("Content-type", "application/json;charset=UTF-8");
                    PrintWriter pw = httpServletResponse.getWriter();
                    interfaceResult.setCode(ResultEnum.TOKEN_INVALID_ERROR.getCode());
                    interfaceResult.setMsg(ResultEnum.TOKEN_INVALID_ERROR.getMessage());

                    pw.write(objectMapper.writeValueAsString(interfaceResult));
                    logger.error("token过期，请重新登录");
                    return;
                }
            }

        } catch (Exception e) {
            logger.error(e.toString());
            httpServletResponse.setHeader("Content-type", "application/json;charset=UTF-8");
            interfaceResult.setCode(ResultEnum.UNKONW_ERROR.getCode());
            interfaceResult.setMsg(ResultEnum.UNKONW_ERROR.getMessage());

            PrintWriter pw = (servletResponse).getWriter();
            pw.write(objectMapper.writeValueAsString(interfaceResult));
            return;
        }
        filterChain.doFilter(requestWrapper, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("-----------------过滤器销毁-----------------》");
    }
}
*/
