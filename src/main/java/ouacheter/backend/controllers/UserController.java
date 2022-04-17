package ouacheter.backend.controllers;

import net.bytebuddy.utility.RandomString;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ouacheter.backend.entities.User;
import ouacheter.backend.exceptions.UserNotFoundException;
import ouacheter.backend.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/getByMail")
    public ResponseEntity<User> getUserByMail(@RequestBody User email) {
        User tmp = userService.getUserByMail(email);
        return new ResponseEntity<>(tmp, HttpStatus.OK);

    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers () {
        List<User> Users = userService.findAllUsers();
        return new ResponseEntity<>(Users, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<User> getUserById (@PathVariable("id") int id) {
        User User = userService.findUserById(id);
        return new ResponseEntity<>(User, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User User) {
        User newUser = userService.addUser(User);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User User) {
        User updateUser = userService.updateUser(User);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/log")
    public ResponseEntity<Boolean> getUserById (@RequestBody User User) {
        boolean doesExist = userService.findUserByLog(User);
        System.out.println(doesExist);
        return new ResponseEntity<>(doesExist, HttpStatus.OK);
    }
}
