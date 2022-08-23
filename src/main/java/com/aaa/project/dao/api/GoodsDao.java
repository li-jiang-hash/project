package com.aaa.project.dao.api;

import com.aaa.project.entity.Goods;

import java.util.List;

/**
 * @Author:江Sir
 * @Date:22 2022/08/22 23:05
 * @description: Exercise
 * @Version 1.0.0
 */
public interface GoodsDao {
    List<Goods> selectAllGoods();

    //获取水果信息
    Goods getGoodsByGid(String gid);

    void updateGood(Goods goods);

    void delFruit(Integer gid);

    void addFruit(Goods goods);
}
