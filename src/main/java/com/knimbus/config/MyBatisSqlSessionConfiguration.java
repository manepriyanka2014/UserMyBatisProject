package com.knimbus.config;

import java.io.IOException;
import java.io.InputStream;

//import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.mysql.cj.x.protobuf.MysqlxConnection.Close;

@Configuration
// @EnableConfigurationProperties
public class MyBatisSqlSessionConfiguration {

	@Bean(name = "session", destroyMethod = "close")
	@Lazy
	public SqlSession getSqlSession() {
		SqlSessionFactory sqlSessionFactory;

		//InputStream inputStream;
		
		try {
			final Resource resource = new ClassPathResource("/mybatis-config.xml");
			//inputStream = Resources.getResourceAsStream("/mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource.getInputStream());
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e );
		}

		return sqlSessionFactory.openSession();
	}

}
