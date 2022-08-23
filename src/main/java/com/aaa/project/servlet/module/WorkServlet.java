package com.aaa.project.servlet.module;

import com.aaa.project.dao.api.GoodsDao;
import com.aaa.project.entity.Goods;
import com.aaa.project.service.api.GoodsService;
import com.aaa.project.service.impl.GoodsServiceImpl;
import com.aaa.project.servlet.base.ModelBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author:江Sir
 * @Date:22 2022/08/22 22:53
 * @description: Exercise
 * @Version 1.0.0
 */
@WebServlet("/work")
public class WorkServlet extends ModelBaseServlet {
    private GoodsService goodsService = new GoodsServiceImpl();

    protected void showCartDigestList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用数据库查数据
        List<Goods> goodsList = goodsService.getAllGoods();
        request.setAttribute("goodsList",goodsList);
        String templateName = "index";
        processTemplate(templateName, request, response);
    }

}
