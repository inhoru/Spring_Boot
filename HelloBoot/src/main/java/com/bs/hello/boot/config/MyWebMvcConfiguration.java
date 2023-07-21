package com.bs.hello.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.bs.hello.boot.common.interceptor.LoggerInterceptor;
import com.bs.hello.boot.websocket.ChattingServer;

@Configuration
@EnableWebSocket
public class MyWebMvcConfiguration implements WebMvcConfigurer,WebSocketConfigurer{
	
	
	private ChattingServer chatting;
	public MyWebMvcConfiguration(ChattingServer chatting) {
		this.chatting=chatting;
	}
	
	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(chatting, "/chatting");
		
	}
	
	//view에 대한 설정
	//기본 화면전환에 대한 설정을 하는 메소드를 재정의 할 수 있다.
		



	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//기본주소로 연결했을때 특정한페이지로 이동시키는 메소드
		//데이터를 가져갈필요없는 화면전환용으로 쓸때 사용할수있다. 예) 회원가입페이지이동
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/test").setViewName("test");
		registry.addViewController("/chattingpage").setViewName("chattingpage");
	}

	//Interceptor설정
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoggerInterceptor()).addPathPatterns("/member/*");
	}

	
	//cors에 대한 허용설정
	//cors(cross-origin resource sharing) error
	//자바스크립트가 발생시키는 에러,
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("http://localost:3000");
	}

	
	
	
	

}
