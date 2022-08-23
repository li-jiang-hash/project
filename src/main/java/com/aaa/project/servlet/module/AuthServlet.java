package com.aaa.project.servlet.module;

import com.aaa.project.entity.User;
import com.aaa.project.exception.LoginFailedException;
import com.aaa.project.service.api.UserService;
import com.aaa.project.service.impl.UserServiceImpl;
import com.aaa.project.servlet.base.ModelBaseServlet;
import com.aaa.project.util.ImperialCourtConst;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author:江Sir
 * @Date:22 2022/08/22 21:03
 * @description: Exercise
 * @Version 1.0.0
 */
@WebServlet("/auth")
public class AuthServlet extends ModelBaseServlet {

    private UserService userService = new UserServiceImpl();

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String loginAccount =request.getParameter("loginAccount");
            String loginPassword =request.getParameter("loginPassword");
            User user = userService.getUidByLoginAccount(loginAccount,loginPassword);
            HttpSession session = request.getSession();
            session.setAttribute(ImperialCourtConst.LOGIN_EMP_ATTR_NAME, user);
            response.sendRedirect(request.getContextPath()+"/work?method=showCartDigestList");



        }catch (Exception e){
            if(e instanceof LoginFailedException){
                request.setAttribute("message",e.getMessage());

                processTemplate("login",request,response);
            }else {
                throw new RuntimeException(e);
            }

        }
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.invalidate();

//        回到首页
        String templateName = "login";
        processTemplate(templateName, request, response);
    }
}
