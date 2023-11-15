package com.example.exam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {
    @GetMapping(value = "/test")
    public User test(){

        User User = new User();
        User.setName("zi");
        User.setAge(20);

        return User;
    }

}
