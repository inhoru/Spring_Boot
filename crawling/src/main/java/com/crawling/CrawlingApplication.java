package com.crawling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.crawling.controller.JsoupComponentLocalMain;

@SpringBootApplication
public class CrawlingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrawlingApplication.class, args);
		
		new JsoupComponentLocalMain().getStockPriceList();
	}

}
