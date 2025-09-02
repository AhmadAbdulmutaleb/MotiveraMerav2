package com.butiksystem.motiveramerav2.Service;


import com.butiksystem.motiveramerav2.Entity.User;
import com.butiksystem.motiveramerav2.Repostory.TaskRepository;
import com.butiksystem.motiveramerav2.Repostory.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskRepository taskRepository;


    public List<User> getAllUsers() { return userRepository.findAll();}
    public Optional<User> findUserById(int id) { return userRepository.findById(id);}

    public Optional<User> findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
        //Spara en ny användare
    }
    @Transactional
    public boolean deleteUser(int id) {
        if (userRepository.existsById(id)) {
                taskRepository.deleteByUserId(id);
                userRepository.deleteById(id);


            return true;
        }
        return false;
    }

    public User updateUser(int id, User user) {
        user.setId(id);
        return userRepository.save(user);
    }




}
