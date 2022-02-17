package ouacheter.backend.controllers;

import org.springframework.web.bind.annotation.*;
import ouacheter.backend.entities.User;
import ouacheter.backend.services.UserService;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users")
    List<User> all() {
        return userService.all();
    }
    @PostMapping("/users")
    User newUser(@RequestBody User newUser) {
        return userService.newUser(newUser);
    }

    // Single item

    @GetMapping("/user/{id}")
    User one(@PathVariable int id) {

        return userService.one(id);

    }

    @PutMapping("/user/{id}")
    User replaceUser(@RequestBody User newUser, @PathVariable int id) {

        return userService.replaceUser(newUser,id);

    }

    @DeleteMapping("/user/{id}")
    void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}
