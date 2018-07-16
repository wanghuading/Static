package com.microservice.springcloudstream;

import com.microservice.springcloudstream.MessageConverter.CustomeMessageConverter;
import com.microservice.springcloudstream.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.annotation.StreamMessageConverter;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.converter.MessageConverter;


@SpringBootApplication
@EnableBinding(Processor.class)
public class SpringCloudStreamApplication {

//	@Autowired
//	private Processor processor;

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStreamApplication.class, args);
	}

//	@StreamListener(Sink.INPUT)
	public void message(Person person) {
 		System.out.printf("person.id:%s,person.name:%s",
				person.getId(), person.getName());
	}

//	@Bean
//	@StreamMessageConverter
	public MessageConverter customMessageConverter() {
		return new CustomeMessageConverter();
	}
}
