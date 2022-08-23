package com.aaa.project.filter;

import com.aaa.project.util.JDBCUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author:江Sir
 * @Date:22 2022/08/22 22:48
 * @description: Exercise
 * @Version 1.0.0
 */
public class BrandFilter implements Filter {
    private static Set<String> staticResourceExtNameSet;
    static {
        staticResourceExtNameSet = new HashSet<>();
        staticResourceExtNameSet.add(".png");
        staticResourceExtNameSet.add(".jpg");
//        staticResourceExtNameSet.add(".css");
//        staticResourceExtNameSet.add(".js");
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //前置方法,排除静态资源
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String servletPath = request.getServletPath();
        if(servletPath.contains(".")){

            String extName = servletPath.substring(servletPath.lastIndexOf("."));
            if(staticResourceExtNameSet.contains(extName)){
                filterChain.doFilter(servletRequest,servletResponse);


                return;
            }
        }


        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();

            connection.setAutoCommit(false);

            filterChain.doFilter(servletRequest,servletResponse);

            connection.commit();
        }catch (Exception e){
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            String message = e.getMessage();
            request.setAttribute("systemMessage",message);
            request.getRequestDispatcher("/").forward(request,servletResponse);
        }finally {
            JDBCUtils.releaseConnection(connection);
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void destroy() {

    }
}
