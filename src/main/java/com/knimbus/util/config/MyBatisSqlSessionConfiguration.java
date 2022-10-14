//package com.knimbus.util.config;
//
//import java.io.IOException;
//import java.io.InputStream;
//
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.mysql.cj.x.protobuf.MysqlxConnection.Close;
//
//@Configuration
////@EnableConfigurationProperties
//
//public class MyBatisSqlSessionConfiguration {
//
//	@Bean(name = "mybatisSqlSession", destroyMethod = "close")
//	public static SqlSession getSqlSession() {
//		SqlSessionFactory sqlSessionFactory;
//
//		InputStream inputStream;
//		try {
//			inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//		} catch (IOException e) {
//			throw new RuntimeException(e.getCause());
//		}
//
//		return sqlSessionFactory.openSession();
//	}
//
//}
