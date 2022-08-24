package com.aaa.project.filter;

import com.aaa.project.util.ImperialCourtConst;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author:江Sir
 * @Date:23 2022/08/23 22:53
 * @description: Exercise
 * @Version 1.0.0
 */
@WebFilter("/work")
public class LoginFiter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        //2、尝试从Session域获取已登录的对象
        Object loginUser = session.getAttribute(ImperialCourtConst.LOGIN_EMP_ATTR_NAME);


        //判断是否为空
        if (loginUser != null) {
            //4、若不为空则说明当前请求己登录，直接放行
            filterChain.doFilter(request, servletResponse);
            return;
        }

        request.setAttribute("systemMessage", ImperialCourtConst.ACCESS_DENIED_MESSAGE);
        request.getRequestDispatcher("/").forward(request, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
