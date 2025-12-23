package com.butiksystem.motiveramerav2.Service;


import com.butiksystem.motiveramerav2.DTO.UserRegistrationDTO;

import com.butiksystem.motiveramerav2.Entity.ParentStudentRelationship;
import com.butiksystem.motiveramerav2.Entity.Role;
import com.butiksystem.motiveramerav2.Entity.User;
import com.butiksystem.motiveramerav2.Repostory.ParentStudentRepository;
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
    @Autowired
    private ParentStudentRepository relationRepository;


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

    public ParentStudentRelationship addRelationship(int parentId, int studentId) {
        User parent = userRepository.findById(parentId)
                .orElseThrow(() -> new RuntimeException("Parent not found"));
        User student = userRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Child not found"));

        if (parent.getRole() != Role.Parent || student.getRole() != Role.Student) {
            throw new RuntimeException("Invalid roles for relationship");
        }

        ParentStudentRelationship relation = new ParentStudentRelationship();
        relation.setParent(parent);
        relation.setStudent(student);
        return relationRepository.save(relation);
    }


    public User updateUser(int id, User user) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (user.getName() != null && !user.getName().trim().isEmpty()) {
            existingUser.setName(user.getName());
        }

        if (user.getEmail() != null && !user.getEmail().trim().isEmpty()) {
            existingUser.setEmail(user.getEmail());
        }

        if (user.getPassword() != null && !user.getPassword().trim().isEmpty()) {
            existingUser.setPassword(user.getPassword());
        }

        if (user.getRole() != null) {
            existingUser.setRole(user.getRole());
        }

        return userRepository.save(existingUser);
    }




}
