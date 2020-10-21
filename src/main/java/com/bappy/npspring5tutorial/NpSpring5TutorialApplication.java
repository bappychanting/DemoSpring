package com.bappy.npspring5tutorial;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages={"com.bappy"})
@EnableAutoConfiguration
@EnableTransactionManagement
public class NpSpring5TutorialApplication {

	private static final Logger logger = LoggerFactory.getLogger(NpSpring5TutorialApplication.class);
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = SpringApplication.run(NpSpring5TutorialApplication.class, args);
	
		logger.info("Beans in application context:");
		
		String beanNames[] = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		
		for(String beanName: beanNames)
			logger.info(beanName);
	}

}
