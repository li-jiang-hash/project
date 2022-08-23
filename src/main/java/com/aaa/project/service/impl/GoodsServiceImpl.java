package com.aaa.project.service.impl;

import com.aaa.project.dao.api.GoodsDao;
import com.aaa.project.dao.impl.GoodsDaoImpl;
import com.aaa.project.entity.Goods;
import com.aaa.project.service.api.GoodsService;

import java.util.List;

/**
 * @Author:江Sir
 * @Date:22 2022/08/22 23:10
 * @description: Exercise
 * @Version 1.0.0
 */
public class GoodsServiceImpl implements GoodsService {
    private GoodsDao goodsDao = new GoodsDaoImpl();
    @Override
    public List<Goods> getAllGoods() {
        return goodsDao.selectAllGoods();
    }
}
