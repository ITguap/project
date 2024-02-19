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

    @GetMapping("/form-add")
    String getAddUserForm(){
    return "add-user";}
    @PostMapping("/save")
    String saveUser(User user){
    userService.save(user);
    return "redirect:/all";
    }

    @GetMapping("/delete-user/{id}")
    String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return "redirect:/all";
    }

    @PostMapping("/update-user/{id}")
    String updateUser(@ModelAttribute User user){
        userService.save(user);
        return "redirect:/all";}

    @GetMapping("/edit-user/{id}")
    String showEditForm(@PathVariable Long id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "edit-user";
}
}



