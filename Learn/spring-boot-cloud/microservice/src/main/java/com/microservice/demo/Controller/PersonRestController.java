package com.microservice.demo.Controller;

import com.microservice.demo.entity.Person;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author whd
 * @Date 2018/5/30 0:15
 * @Description {@link RestController}
 **/
@RestController
public class PersonRestController {
    @GetMapping("/getPerson/{id}")
    public Person getPerson(@PathVariable(value = "id") int id,
                            @RequestParam(required = false) String name) {
        Person person = new Person();
        person.setId(id);
        person.setName(name);
        return person;
    }



    @PostMapping(value = "/person/propertiesToJson"/*,
            consumes = "application/properties+person",
            produces = "application/json"*/
    )
    public Object propertiesToJson(@RequestBody Person person) {
        return person;
    }

    @PostMapping(value = "/person/jsonToProperties"
            /*// 接受类型
            consumes = "application/json",
            // 响应类型
            produces = "application/properties+person"*/
    )
    public Object jsonToProperties(@RequestBody Person person) {
        return person;
    }
    @GetMapping("/404.html")
    public Object pageNotFound(HttpServletRequest request,
                               Throwable throwable) {
        Map<String, Object> error = new HashMap<>();
        error.put("message", request.getAttribute("javax.servlet.error.message"));
        error.put("uri", request.getAttribute("javax.servlet.error.request_uri"));
        error.put("tmessage", throwable.getMessage());
        return error;
    }

    @RequestMapping("/npe")
    public String npNullPointerExceptione(){
        throw new NullPointerException("故意抛异常！");
    }

    @ExceptionHandler(NullPointerException.class)
    public Object handlerNpe(HttpServletRequest request, Throwable throwable) {

        Map<String, Object> data = new HashMap<>();
        data.put("message", throwable.getMessage());
        data.put("uri", request.getAttribute("javax.servlet.error.request_uri"));
        return data;
    }
}
