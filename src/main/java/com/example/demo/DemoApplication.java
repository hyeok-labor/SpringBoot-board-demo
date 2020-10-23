package com.example.demo;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

// MapperScan : Mapper 인터페이스를 인식할 수 있도록 설정
@SpringBootApplication
@MapperScan(value={"com.example.demo.board.mapper"})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	/*
	 * SqlSessionFactory 설정
	 * 	: 스프링에 필요한 객체를 생성 ==> MyBatis의 SqlSessionFactory를 반환.
	 *    스프링에 DataSource객체를 이 메서드 실행 시 주입해서 결과 만듦.
	 *    그 결괄ㄹ 스프링 내 빈으로 사용함.
	 */
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();

		sessionFactory.setDataSource(dataSource);
		return sessionFactory.getObject();
	}

}
