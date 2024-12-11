package bg.softuni.MobLeLeLe.web;

import bg.softuni.MobLeLeLe.model.dto.UserRegistrationDTO;
import bg.softuni.MobLeLeLe.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register(){
        return "auth-register";
    }

    @PostMapping("/register")
    public String register(UserRegistrationDTO userRegistrationDTO){

        userService.registerUser(userRegistrationDTO);

        return "index";
    }

}
