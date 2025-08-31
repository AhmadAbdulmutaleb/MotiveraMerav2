package com.butiksystem.motiveramerav2.Service;


import com.butiksystem.motiveramerav2.Entity.User;
import com.butiksystem.motiveramerav2.Repostory.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public List<User> getAllUsers() { return userRepository.findAll();}
    public User findUserById(int id) { return userRepository.findById(id);}

    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
        //Spara en ny användare
    }

    public User updateUser(int Id, User user) {
        return userRepository.save(user);
    }


}
