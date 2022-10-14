//package com.knimbus.util.config;
//
//import java.io.IOException;
//import java.io.Reader;
//
//import javax.annotation.Resource;
//
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//import org.springframework.stereotype.Component;
//@Component
//public class MyBatisUtil {
//	

	

//	private static SqlSessionFactory sqlSessionFactory;
//	static {
//		Reader reader;
//		try {
//			System.out.println("-------------Inside MyBatisUtil------------");
//			reader = Resources.getResourceAsReader("resources/mybatis-config.xml");
//			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	public static SqlSessionFactory getSqlSessionFactory(){
//		return sqlSessionFactory;
//	}


//}