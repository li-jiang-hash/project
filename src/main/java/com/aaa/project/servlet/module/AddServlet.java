package com.aaa.project.servlet.module;

import com.aaa.project.dao.api.GoodsDao;
import com.aaa.project.dao.impl.GoodsDaoImpl;
import com.aaa.project.entity.Goods;
import com.aaa.project.servlet.base.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author:江Sir
 * @Date:23 2022/08/23 21:06
 * @description: Exercise
 * @Version 1.0.0
 */
@WebServlet("/add.do")
public class AddServlet extends ViewBaseServlet {
    private GoodsDao goodsDao = new GoodsDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processTemplate("add", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String gname = req.getParameter("gname");
        String gpriceStr = req.getParameter("gprice");
        String gslogan = req.getParameter("gslogan");
        Double gprice = Double.parseDouble(gpriceStr);
        Goods good = new Goods(0,gname,gprice,gslogan);
        goodsDao.addFruit(good);
        resp.sendRedirect("work?method=showCartDigestList");


    }

}
