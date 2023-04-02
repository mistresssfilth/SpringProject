package com.mistressfilth.spring.controller;

import com.mistressfilth.spring.entity.User;
import com.mistressfilth.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    UserService userService;

    @GetMapping("/admin")
    public String getAllUsers(Model model){
        List<User> userList = userService.getAll();
        model.addAttribute("userList", userList);
        model.addAttribute("userSize", userList.size());
        return "adminPanel";
    }
    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.delete(id);
        return "/admin";
    }
    @RequestMapping("/user/{user}")
    public String editUser(@PathVariable User user){
        return "userEdit";
    }

}
