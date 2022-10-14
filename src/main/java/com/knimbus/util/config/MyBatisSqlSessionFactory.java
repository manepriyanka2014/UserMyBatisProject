//package com.knimbus.util.config;
//
//import java.io.IOException;
//import java.io.InputStream;
//import org.apache.ibatis.session.*; 
//
//import javax.enterprise.context.spi.Context;
//
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//
//import org.apache.ibatis.io.Resources; 
//
//public class MyBatisSqlSessionFactory {
//	
//	private static SqlSessionFactory sqlSessionFactory;
//
//	private static SqlSessionFactory getSqlSessionFactory() {
//		if (sqlSessionFactory == null) {
//			InputStream inputStream;
//			try {
//				inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//			} catch (IOException e) {
//				throw new RuntimeException(e.getCause());
//			}
//		}
//		return sqlSessionFactory;
//	}
//
//	public static SqlSession openSession() {
//		return getSqlSessionFactory().openSession();
//	}
//}
