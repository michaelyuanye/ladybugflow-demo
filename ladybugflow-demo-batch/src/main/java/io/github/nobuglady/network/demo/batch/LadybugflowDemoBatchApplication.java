package io.github.nobuglady.network.demo.batch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import io.github.nobuglady.network.demo.batch.ladybugflow.Flow1;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class LadybugflowDemoBatchApplication implements ApplicationRunner {

	@Autowired
	private Flow1 flow1;
	
	public static void main(String[] args) {
		SpringApplication.run(LadybugflowDemoBatchApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		flow1.startFlow(true);
		System.out.println(flow1.getResult());
		
	}

}
