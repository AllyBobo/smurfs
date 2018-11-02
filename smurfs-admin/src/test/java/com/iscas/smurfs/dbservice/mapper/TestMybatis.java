package com.iscas.smurfs.dbservice.mapper;

import com.iscas.smurfs.core.admin.entity.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import tk.mybatis.spring.annotation.MapperScan;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author: lee
 * @date: 2018-11-02
 */
@MapperScan("com.iscas.smurfs.dbservice.mapper")
public class TestMybatis {
    public static void main(String[] args) throws IOException {
        //最基本的mybitas示例方法
        TestMybatis.testMethod();
    }

    public static void testMethod() throws IOException{
        String resource = "applicationContext.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        Properties properties = new Properties();
        properties.setProperty("jdbc.driver", "com.mysql.jdbc.Driver");
        properties.setProperty(
                "jdbc.url",
                "jdbc:mysql://localhost:3306/smurfs?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true");
        properties.setProperty("jdbc.username", "root");
        properties.setProperty("jdbc.password", "root");


        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream,properties);

        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.selectByPrimaryKey(1);
            System.out.println("good description:"+user.getUsername());
        } finally {
            session.close();
        }
    }

}
