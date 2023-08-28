package yujinns.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import yujinns.blog.DTO.User;
import yujinns.blog.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String signup() {
        return "/signup";
    }

    @PostMapping("/signup")
    public String signup(@RequestParam String id,
                         @RequestParam String password,
                         @RequestParam String nickname,
                         @RequestParam String email) {
        User user = new User(id, password, nickname, email);
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
