package yujinns.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import yujinns.blog.DTO.User;
import yujinns.blog.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String signup() {
        return "/signup";
    }

    @PostMapping("/signup")
    public String signup(User user) {
        userService.insertUser(user);
        return "/login";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/delete")
    public String delete() {
        return "/delete";
    }

}
