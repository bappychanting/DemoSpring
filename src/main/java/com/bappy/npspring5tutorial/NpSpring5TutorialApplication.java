package com.bappy.npspring5tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.bappy"})
public class NpSpring5TutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(NpSpring5TutorialApplication.class, args);
	}

}
