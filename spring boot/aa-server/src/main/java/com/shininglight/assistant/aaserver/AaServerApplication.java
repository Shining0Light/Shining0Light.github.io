package com.shininglight.assistant.aaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AaServerApplication {
	/**
	 * 基于cs架构的spring boot项目所用技术：
	 * 请求响应格式统一
	 * 全局异常处理
	 * 基于jwt的token验证
	 * 基于SHA的密码不可逆加密
	 * 基于RSA的密码可逆加密
	 * 基于aop的service日志记录
	 * 项目地址：github
	 * @author: Shane Liu
	 * @date: Created in 14:44 12/05/18
	 */
	public static void main(String[] args) {
		SpringApplication.run(AaServerApplication.class, args);
	}
}
