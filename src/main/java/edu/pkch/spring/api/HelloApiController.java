package edu.pkch.spring.api;

import edu.pkch.spring.domain.Member;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloApiController {

    @GetMapping("/hello")
    public String hello() {
        return "hello world!";
    }

    @GetMapping("/person")
    public Member person() {
        return new Member("pkch", 29);
    }
}
