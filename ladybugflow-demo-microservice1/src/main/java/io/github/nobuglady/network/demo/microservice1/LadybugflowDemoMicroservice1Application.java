package io.github.nobuglady.network.demo.microservice1;

import javax.annotation.PreDestroy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.github.nobuglady.network.fw.starter.FlowStarter;

@SpringBootApplication
@EnableFeignClients
public class LadybugflowDemoMicroservice1Application {

	public static void main(String[] args) {
		SpringApplication.run(LadybugflowDemoMicroservice1Application.class, args);
	}

	@PreDestroy
	public void onExit() {
		FlowStarter.shutdown();
	}
}
