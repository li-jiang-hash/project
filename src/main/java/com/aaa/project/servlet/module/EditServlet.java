package com.aaa.project.servlet.module;

import com.aaa.project.dao.api.GoodsDao;
import com.aaa.project.dao.impl.GoodsDaoImpl;
import com.aaa.project.entity.Goods;
import com.aaa.project.servlet.base.ViewBaseServlet;
import com.aaa.project.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author:江Sir
 * @Date:23 2022/08/23 17:24
 * @description: Exercise
 * @Version 1.0.0
 */
@WebServlet("/edit.do")
public class EditServlet extends ViewBaseServlet {
    private GoodsDao goodsDao = new GoodsDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String gidStr = req.getParameter("gid");
//        if(StringUtils.isNotEmpty(gidStr)){
//            int gid = Integer.parseInt(gidStr);
        Goods good = goodsDao.getGoodsByGid(gidStr);
        req.setAttribute("good", good);
        processTemplate("edit", req, resp);
//        resp.sendRedirect();


//        }
    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
//    }
}
