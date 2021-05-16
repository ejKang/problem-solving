package com.joo.book.springboot.springbootwebservice.web;

import com.joo.book.springboot.springbootwebservice.web.dto.HelloResponseDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // 컨트롤러를 json을 반환하는 컨트롤러로 만들어 준다.
                // 예전에는 @ResponseBody를 각 메소드마다 선언했던 것을 한번에 사용할 수 있게 해준다고 생각하면 된다.
public class HelloController {

    @GetMapping("/hello") // http method인 get 요청을 방을 수 있는 api
                          // 예전에는 @RequestMapping(method = RequestMethod.GET)으로 사용되었다
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
