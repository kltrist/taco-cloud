package by.grsu.edu.controller;

import by.grsu.edu.repository.UserRepository;
import by.grsu.edu.security.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegistrationController {

    private UserRepository userRepo;
    private PasswordEncoder passEncoder;

    @Autowired
    public RegistrationController(UserRepository userRepo, PasswordEncoder passEncoder) {
        this.userRepo = userRepo;
        this.passEncoder = passEncoder;
    }

    @GetMapping
    public String registerForm() {
        return "registration";
    }

    @PostMapping
    public String processRegistration(RegistrationForm form) {
        userRepo.save(form.toUser(passEncoder));
        return "redirect:/login";
    }

}
