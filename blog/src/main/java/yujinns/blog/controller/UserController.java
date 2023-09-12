package yujinns.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @GetMapping("/userlist")
    public String userList(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "userlist";
    }

    @PostMapping("/registerAction")
    public String signup(User user) {
        userService.insertUser(user);
        return "redirect:/home";
    }

    @GetMapping("/delete")
    public String delete() {
        return "/delete";
    }

//    @PostMapping("/delete")
//    public String delete(@RequestParam String id) {
//        userService.deleteUserById(id);
//        return "redirect:/home";
//    }

    @GetMapping("/delete/{userId}")
    public String delete(@PathVariable String userId, HttpSession session, Model model) {
        String loggedInUserId = (String) session.getAttribute("userId");

        if (loggedInUserId == null) {
            return "redirect:/login";
        }

        if(loggedInUserId.equals(userId)) {
            userService.deleteUserById(userId);
            session.removeAttribute("userId");
            session.removeAttribute("username");
            return "redirect:/home";
        } else {
            model.addAttribute("message","삭제 권한이 없습니다.");
            return "redirect:/home";
        }
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
    public String login() { return "loginForm"; }

    @PostMapping("/loginAction")
    public String login(@RequestParam String id, @RequestParam String password, HttpSession session) {
        User user = userService.selectUserById(id);
        if (user != null && userService.matchesPassword(password, user.getPassword())) {
            session.setAttribute("userId",user.getId());
            session.setAttribute("username",user.getNickname());
//            return "redirect:/user/" + id;
            session.setAttribute("intro", user.getIntro());
            return "redirect:/board";
        } else {
            return "redirect:/index";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("username");
        session.removeAttribute("userId");
        return "redirect:/index";
    }

    @GetMapping("/login_success")
    public String loginSuccess() { return "login_success";}

    @GetMapping("/login_fail")
    public String loginFail() { return "login_fail"; }

    @GetMapping("/users")
    public String getUsersByPage(Model model, @RequestParam(name="page", defaultValue = "1") int page) {
        int pageSize = 4;
        int totalUsers = userService.getTotalUserCount();

        List<User> users = userService.getUsersByPage(page, pageSize);

        model.addAttribute("users", users);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", (totalUsers + pageSize - 1) / pageSize);

        return "/userlist";
    }
    @GetMapping("/mypage")
    public String mypage() {
        return "mypage";
    }

    @GetMapping("/user/{userId}")
    public String myPage(@PathVariable String userId, HttpSession session, Model model) {
        String loggedInUserId = (String) session.getAttribute("userId");

        if (loggedInUserId != null) {
            if (loggedInUserId.equals(userId)) {
                User user = userService.selectUserById(userId);
                model.addAttribute("user",user);
                return "/mypage";
            } else {
                model.addAttribute("message", "회원 정보와 일치하지 않습니다.");
                return "redirect:/home";
            }
        } else {
            model.addAttribute("message","로그인이 필요한 페이지입니다.");
            return "redirect:/login";
        }
    }

    @GetMapping("/password_change/{userId}")
    public String changePassword(@PathVariable String userId, Model model) {
        User user = userService.selectUserById(userId);
        model.addAttribute("user",user);
        return "/password_change";
    }

    @PostMapping("/password_change/{id}")
    public String changePassword(@PathVariable String id, @RequestParam(name="password") String password, @RequestParam(name="newPassword") String newPassword) {
        User user = userService.selectUserById(id);

        if (userService.matchesPassword(password, user.getPassword())) {
            user.setPassword(newPassword);
            userService.changePassword(user);
            return "redirect:/user/{id}";
        }
        return "redirect:/home";
    }

    @PostMapping("/mypage_action/{id}")
    public String updateUserInfo(@PathVariable String id, @RequestParam(name="nickname") String nickname, @RequestParam(name="intro") String intro) {
        User user = userService.selectUserById(id);
        user.setNickname(nickname);
        user.setIntro(intro);
        userService.updateUserInfo(user);
        return "redirect:/user/{id}";
    }
}
