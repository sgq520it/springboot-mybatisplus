package com.sgq.xcx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.sgq.xcx.Controller")
@ComponentScan("com.sgq.xcx.Service")
@MapperScan("com.sgq.xcx.Mapper")
public class XcxApplication {

	public static void main(String[] args) {
		SpringApplication.run(XcxApplication.class, args);
	}

}
