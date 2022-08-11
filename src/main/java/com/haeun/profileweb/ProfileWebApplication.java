package com.haeun.profileweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ProfileWebApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ProfileWebApplication.class, args);
	}
	
	@Override	//서버에서 돌아가게 설정
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(ProfileWebApplication.class);
	}

}
