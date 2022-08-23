package com.aaa.project.dao;

import com.aaa.project.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author:江Sir
 * @Date:13 2022/08/13 17:10
 * @description: Exercise
 * @Version 1.0.0
 */
public class BaseDao<T> {
    // DBU
    private QueryRunner runner = new QueryRunner();

    public List<T> getBeanList(String sql,Class<T> entityClass,Object... parameters){
        Connection connection = JDBCUtils.getConnection();
//        <List>T entity =null;
        try {
//            T entity
            return runner.query(connection, sql, new BeanListHandler<>(entityClass), parameters);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
//        return entity;
    }

    public T getSingleBean(String sql, Class<T> entityClass, Object... parameters) {
//        获取数据库连接
        Connection connection = JDBCUtils.getConnection();
//        T entity =null;
        try {
//            T entity
           return runner.query(connection, sql, new BeanHandler<>(entityClass), parameters);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
//        return entity;
    }

    /**
     * 通用的增删改方法
     * @param sql  执行操作的SQL语句
     * @param parameters  语句参数
     * @return  受影响的行数
     */
    public  int update(String sql,Object... parameters){
        Connection connection = JDBCUtils.getConnection();
        try {
            int affectedRowNumbers = runner.update(connection, sql, parameters);
            return affectedRowNumbers;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
//            return 0;
        }
    }
        
}
