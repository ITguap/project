package com.example.probaex.Controller;

import com.example.probaex.Model.User;
import com.example.probaex.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    //Переход на главную страницу
    @GetMapping("")
    public String mainPage(){return "main";}

    @GetMapping("/all")
    String findAllUser(Model model, String name){
    if (name == null){
        model.addAttribute("users", userService.findAll());
        return "userList";
    } else {
        model.addAttribute("users", userService.findUserByName(name));
    }
        return "userList";
    }
}



