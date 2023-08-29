package yujinns.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete() {
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam String id) {
        userService.deleteUserById(id);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String update() {
        return "update";
    }

    @GetMapping("/update_info")
    public String updateInfoForm(@RequestParam String id, Model model) {
        User user = userService.selectUserById(id);
        model.addAttribute("user", user);
        return "update_info"; // update_info.html로 리턴
    }

    @PostMapping("/update")
    public String updateUser(User user) {
        userService.updateUser(user);
        return "redirect:/"; // 업데이트 후 웰컴 페이지로 리다이렉트
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

}
