package ru.javamentor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.javamentor.model.User;
import ru.javamentor.service.UsersService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping()
    public String getUsers(ModelMap model) {
        List<User> userList = usersService.getUsers();
        model.addAttribute("users", userList);
        return "index";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "create";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") User user) {
        usersService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", usersService.getUserById(id));
        return "edit";

    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user) {
        usersService.updateUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        usersService.deleteUser(id);
        return "redirect:/users";
    }
}
