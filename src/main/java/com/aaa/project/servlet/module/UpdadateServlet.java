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
 * @Date:23 2022/08/23 19:18
 * @description: Exercise
 * @Version 1.0.0
 */
@WebServlet("/update.do")
public class UpdadateServlet extends ViewBaseServlet {
    GoodsDao goodsDao = new GoodsDaoImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String gidStr = req.getParameter("gid");
        Integer gid = Integer.parseInt(gidStr);
        String gname = req.getParameter("gname");
        String gpriceStr = req.getParameter("gprice");
        Double gprice = Double.parseDouble(gpriceStr);
        String gslogan = req.getParameter("gslogan");
        goodsDao.updateGood(new Goods(gid,gname,gprice,gslogan));
//        super.processTemplate("",req,resp);
        resp.sendRedirect("work?method=showCartDigestList");
    }
}
