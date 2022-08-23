package com.aaa.project.servlet.module;

import com.aaa.project.servlet.base.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author:江Sir
 * @Date:22 2022/08/22 20:13
 * @description: Exercise
 * @Version 1.0.0
 */
@WebServlet(urlPatterns = "/login")
public class PortalServlet extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String templateName = "login";
        processTemplate(templateName,req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
