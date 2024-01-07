package com.hsenid.talkbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:application-service.xml")
public class TalkbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(TalkbookApplication.class, args);
	}

}
