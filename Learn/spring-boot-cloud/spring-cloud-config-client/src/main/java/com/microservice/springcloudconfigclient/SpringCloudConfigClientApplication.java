package com.microservice.springcloudconfigclient;

import com.microservice.springcloudconfigclient.system.MyHealthIndicator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.util.Set;

@SpringBootApplication
public class SpringCloudConfigClientApplication {

	private final ContextRefresher contextRefresher;
	private final Environment environment;

	public SpringCloudConfigClientApplication(ContextRefresher contextRefresher,
											  Environment environment) {
		this.contextRefresher = contextRefresher;
		this.environment = environment;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigClientApplication.class, args);
	}

	// 自动刷新配置
//	@Scheduled(fixedDelay = 5 * 1000, initialDelay = 3 * 1000)
	public void autoRefresh() {
		Set<String> configs = contextRefresher.refresh();

		configs.forEach(config ->
				System.err.printf("刷新的属性key=%s，value=%s",
						config, environment.getProperty(config)));
	}

	@Bean
	public MyHealthIndicator myHealthIndicator(){
		return new MyHealthIndicator();
	}

}
