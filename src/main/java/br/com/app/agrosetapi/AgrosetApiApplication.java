package br.com.app.agrosetapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("br.com.app")
public class AgrosetApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgrosetApiApplication.class, args);
	}
}
