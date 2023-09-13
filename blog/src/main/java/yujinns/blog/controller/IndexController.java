package yujinns.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/home")
    public String home() { return "/home"; }

    @GetMapping("/index")
    public String index(){
        return "index";
    }

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

}
