package spring.building_pc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WindowsController {
    
    @GetMapping("/")
    public String openSite(Model model) {
        model.addAttribute("class", "closed");
        return "site/index";
    }

    @PostMapping("/hide")
    public String hide(Model model) {
        model.addAttribute("class", "closed");
        System.out.println("Hide!");
        return "site/index";
    }

    @PostMapping("/show")
    public String show(Model model) {
        model.addAttribute("class", "");
        System.out.println("Show!");
        return "site/index";
    }

}
