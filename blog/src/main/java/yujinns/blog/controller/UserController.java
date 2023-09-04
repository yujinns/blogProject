package yujinns.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import yujinns.blog.DTO.User;
import yujinns.blog.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/home")
    public String home() { return "/home"; }

//    @GetMapping("/home")
//    public String home(Model model) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        boolean isAuthenticated = authentication != null && authentication.isAuthenticated();
//        model.addAttribute("isAuthenticated", isAuthenticated);
//        if (isAuthenticated) {
//            model.addAttribute("username", authentication.getName());
//        }
//        return "/home";
//    }

    @GetMapping("/signup")
    public String signup() {
        return "/signup";
    }

    @GetMapping("/userlist")
    public String userList(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "userlist";
    }

    @PostMapping("/signup")
    public String signup(User user) {
        userService.insertUser(user);
        return "redirect:/home";
    }

    @GetMapping("/delete")
    public String delete() {
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam String id) {
        userService.deleteUserById(id);
        return "redirect:/home";
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
        return "redirect:/home"; // 업데이트 후 웰컴 페이지로 리다이렉트
    }

    @GetMapping("/login")
    public String login() { return "login"; }

    @PostMapping("/login")
    public String login(@RequestParam String id, @RequestParam String password, HttpSession session) {
        User user = userService.selectUserById(id);
        if (user != null && userService.matchesPassword(password, user.getPassword())) {
            session.setAttribute("username",user.getNickname());
            return "redirect:/home";
        } else {
            return "redirect:/login_fail";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("username");
        return "redirect:/home";
    }

    @GetMapping("/login_success")
    public String loginSuccess() { return "login_success";}

    @GetMapping("/login_fail")
    public String loginFail() { return "login_fail"; }

}
