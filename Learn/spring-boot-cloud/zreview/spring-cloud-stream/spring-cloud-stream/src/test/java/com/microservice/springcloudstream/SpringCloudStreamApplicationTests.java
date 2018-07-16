package com.microservice.springcloudstream;

import com.microservice.springcloudstream.entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringCloudStreamApplicationTests {
//    @Autowired
    private Processor processor;
//    @Autowired
//    @Qualifier(Processor.OUTPUT)
    MessageChannel messageChannel;

//    @Autowired
    private Sink sink;

    @Autowired
    private ApplicationRunner poller;

	@Test
	public void contextLoads() {
	    assertNotNull(this.sink.input());
	}


	@Test
    public void sendMessgge() {
        Person person = new Person();
        person.setName("ceshi11");
        processor.output().send(MessageBuilder.withPayload(person).build());
    }

    @Test
    public void polletdMsg() {
        try {
            poller.run(new ApplicationArguments() {
                @Override
                public String[] getSourceArgs() {
                    return new String[0];
                }

                @Override
                public Set<String> getOptionNames() {
                    return null;
                }

                @Override
                public boolean containsOption(String name) {
                    return false;
                }

                @Override
                public List<String> getOptionValues(String name) {
                    return null;
                }

                @Override
                public List<String> getNonOptionArgs() {
                    return null;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
