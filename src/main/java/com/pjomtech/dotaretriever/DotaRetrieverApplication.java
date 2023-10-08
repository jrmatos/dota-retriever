package com.pjomtech.dotaretriever;

import com.pjomtech.dotaretriever.service.ParsedMatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@RequiredArgsConstructor
public class DotaRetrieverApplication implements ApplicationRunner {
	private final ParsedMatchService parsedMatchService;

	public static void main(String[] args) {
		SpringApplication.run(DotaRetrieverApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Running some code after startup");

//		parsedMatchService.getParsedMatches();
	}
}
