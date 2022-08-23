package com.aaa.project.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author:江Sir
 * @Date:13 2022/08/13 14:51
 * @description: Exercise
 * @Version 1.0.0
 */
public class JDBCUtils {

    private static DataSource dataSource;


    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    //    静态代码块初始化数据源
    static {
        //1操作思路分析：
        //从jdbc.properties文件中读取连接数据库的信息
        //为了保证程序代码的可移植性，需要基于一个确定的基准来读取这个文件
        //确定的基准：类路径的根目录。resources目录下的内容经过构建操作中的打包操作后会确定放在wEB-INF/classes目录下。
        //wEB - INF /classes目录存放编译好的 *.class字节码文件，所以这个目录我们就称之为类路径。
        //类路径无论在本地运行还是在服务器端运行都是一个确定的基谁。
        Properties properties = new Properties();

//        ClassLoader classLoader = JDBCUtils.class.getClassLoader();
//
        InputStream stream = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");

        try {
            properties.load(stream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
// 为了避免在真正抛出异常后，catch快补货到异常从而掩盖问题
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
//        1.尝试从线程检查是否有
        Connection connection = null;


        try {
            connection = threadLocal.get();

            if (connection == null) {
                connection = dataSource.getConnection();

                threadLocal.set(connection);
            }
            System.out.println(connection+"=======");
        } catch (SQLException e) {
            e.printStackTrace();

//                不能掩盖问题
            throw new RuntimeException(e);
        }


        return connection;
    }

    public static void releaseConnection(Connection connection) {
        if (connection != null) {
            try {
                //数据库连接池中将当前连接对象标记为空
                connection.close();

                //将当前数据库连接从当前线程上移除
                threadLocal.remove();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
}
