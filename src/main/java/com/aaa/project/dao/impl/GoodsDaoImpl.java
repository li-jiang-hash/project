package com.aaa.project.dao.impl;

import com.aaa.project.dao.BaseDao;
import com.aaa.project.dao.api.GoodsDao;
import com.aaa.project.entity.Goods;

import java.util.List;

/**
 * @Author:江Sir
 * @Date:22 2022/08/22 23:07
 * @description: Exercise
 * @Version 1.0.0
 */
public class GoodsDaoImpl extends BaseDao<Goods> implements GoodsDao {
    @Override
    public List<Goods> selectAllGoods() {

        String sql = "select goods_id goodId," +
                "goods_name goodName," +
                "goods_price goodPrice," +
                "goods_slogan goodSlogan from project_goods;";
        System.out.println(getBeanList(sql, Goods.class));
        return getBeanList(sql, Goods.class);
    }

    @Override
    public Goods getGoodsByGid(String gid) {
        String sql = "select goods_id goodId," +
                "goods_name goodName," +
                "goods_price goodPrice," +
                "goods_slogan goodSlogan from project_goods where goods_id=?;";
        return  getSingleBean(sql, Goods.class, gid);
    }

    @Override
    public void updateGood(Goods goods) {
        String sql = "update project_goods set goods_name=?,goods_price=?,goods_slogan=? where goods_id=?";
        update(sql,goods.getGoodName(),goods.getGoodPrice(),goods.getGoodSlogan(),goods.getGoodId());
    }

    @Override
    public void delFruit(Integer gid) {
        String sql = "delete from project_goods where goods_id=?";
        super.update(sql,gid);
    }

    @Override
    public void addFruit(Goods goods) {
        String sql = "insert into project_goods values(0,?,?,?)";
        System.out.println("受影响的行数："+update(sql, goods.getGoodName(), goods.getGoodPrice(), goods.getGoodSlogan()));
    }
}
