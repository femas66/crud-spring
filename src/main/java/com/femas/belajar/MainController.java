package com.femas.belajar;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(path = "/user")
public class MainController {
    private final UserRepository userRepository;

    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(path = "/add")
    public @ResponseBody String addUser(@RequestParam String name, @RequestParam String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return "success";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PutMapping(path = "/update")
    public @ResponseBody String updateUser(@RequestParam String id, @RequestParam String name, @RequestParam String email) {
        User user = new User();
        user.setId(Integer.parseInt(id));
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return "Berhasil update";
    }

    @DeleteMapping(path = "/delete")
    public @ResponseBody String deleteUser(@RequestParam String id) {
        User user = new User();
        user.setId(Integer.parseInt(id));
        userRepository.delete(user);
        return "success delete";
    }
}
