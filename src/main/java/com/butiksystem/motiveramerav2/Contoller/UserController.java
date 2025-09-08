package com.butiksystem.motiveramerav2.Contoller;


import com.butiksystem.motiveramerav2.DTO.UserRegistrationDTO;
import com.butiksystem.motiveramerav2.Entity.User;
import com.butiksystem.motiveramerav2.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping ("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {  //ResponseEntiry för att visa hur det gick för metoden att köras
       boolean deleted=  userService.deleteUser(id) ; //skapar en variabel för att dubbel kolla om den lyckades köras
        return deleted ? ResponseEntity.noContent().build() //detta är en förkortning istället för if (deleted) {return detta rad}
                        : ResponseEntity.notFound().build(); // else Retunera detta.

    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.findUserById(id).orElse(null);
    }
    @GetMapping("/users/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.findUserByEmail(email).orElse(null);
    }

    @PatchMapping("/users/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }



}
