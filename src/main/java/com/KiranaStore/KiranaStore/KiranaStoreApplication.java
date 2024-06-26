package com.KiranaStore.KiranaStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class KiranaStoreApplication {


	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(KiranaStoreApplication.class, args);
	}

//	@GetMapping("/hello")
//	public List<String> hello(){
//	return List.of("Hello","World");
//	}
}
