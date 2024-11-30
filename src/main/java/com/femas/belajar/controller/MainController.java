package com.femas.belajar.controller;
import com.femas.belajar.Router;
import com.femas.belajar.entity.User;
import com.femas.belajar.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = Router.API_PREFIX)
public class MainController {
    private final UserRepository userRepository;

    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(path = Router.USERS)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody String addUser(@RequestParam String name, @RequestParam String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return "success";
    }

    @GetMapping(path = Router.USERS)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PutMapping(path = Router.USERS + "/{id}")
    public @ResponseBody String updateUser(@PathVariable Integer id, @RequestParam String name, @RequestParam String email) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return "Berhasil update";
    }

    @DeleteMapping(path = Router.USERS + "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody String deleteUser(@PathVariable Integer id) {
        User user = new User();
        user.setId(id);
        userRepository.delete(user);
        return "success delete";
    }
}
