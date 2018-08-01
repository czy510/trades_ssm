package com.st.trade;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = {"com.st.trade.modules.*.dao"})
public class TradeApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(TradeApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TradeApplication.class);
	}
}
