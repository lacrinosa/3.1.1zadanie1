package zadacha31._zadanie1.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import zadacha31._zadanie1.service.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showListUsers(Model model) {
        model.addAttribute("users", userService.showUsers());
        return "users";
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "addUser";
    }

    @PostMapping("/add")
    public String addUser(
            @RequestParam("name") String name,
            @RequestParam("surname") String surname) {

        userService.addUser(name, surname);

        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam("id") Long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "editUser";
    }

    @PostMapping("/update")
    public String updateUser(
            @RequestParam("id") Long id,
            @RequestParam("name") String name,
            @RequestParam("surname") String surname) {

        userService.updateUser(id, name, surname);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
