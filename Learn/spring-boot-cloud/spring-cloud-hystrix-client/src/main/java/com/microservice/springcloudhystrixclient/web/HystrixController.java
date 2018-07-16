package com.microservice.springcloudhystrixclient.web;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@Controller
public class HystrixController {
    Random random = new Random(200);

    @HystrixCommand(fallbackMethod = "errorMethod",
            commandProperties = {
            @HystrixProperty(
                name = "execution.isolation.thread.timeoutInMilliseconds", value = "100"
            )}
    )
    @GetMapping("/testHystrix")
    public String testHystrix() {
        int val = random.nextInt();
        try {
            System.out.println("Random = "+val);
            Thread.sleep(val);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "success";
    }

    @GetMapping("/testHystrix2")
    public String testHystrix2() {
        return new MyHystrixCommand().execute();
    }

    public String errorMethod() {
        System.out.println("错误执行方法");
        return "error";
    }

    public class MyHystrixCommand extends com.netflix.hystrix.HystrixCommand<String> {

        protected MyHystrixCommand() {
            super(HystrixCommandGroupKey.Factory.asKey("HelloWorld"),
                    100
            );
        }

        @Override
        protected String run() throws Exception {
            // 如果随机时间 大于 100 ，那么触发容错
            int value = random.nextInt(200);
            System.out.println("helloWorld() costs " + value + " ms.");
            Thread.sleep(value);
            return "Hello,World";
        }

        // 容错执行
        protected String getFallback() {
            return HystrixController.this.errorMethod();
        }
    }
}
