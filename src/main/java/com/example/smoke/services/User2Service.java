package com.example.smoke.services;

import com.example.smoke.models.User2;
import com.example.smoke.repositories.User2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class User2Service {
    @Autowired
    private User2Repository userRepository;

    public User2 createUser(User2 user){
        return userRepository.save(user);
    }

    public List<User2> createUsers(List<User2> users){
        return userRepository.saveAll(users);
    }

    public User2 getUserById(int id){
    return  userRepository.findById(id).orElse(null);
    }

    public List<User2> GetUsers(){
        return  userRepository.findAll();
    }

    public User2 UpdateUser(User2 user){
        User2 oldUser = null;
        Optional<User2> optionalUser = userRepository.findById(user.getId());
        if(optionalUser.isPresent()){

            oldUser = optionalUser.get();
            oldUser.setName(user.getName());
            oldUser.setPassword(user.getPassword());
            oldUser.setAddress(user.getAddress());
            userRepository.save(oldUser);
        }
        else {
            return new User2();
        }
        return oldUser;
    }

    public String DeleteUserById(int id){
        userRepository.deleteById(id);
        return "User got deleted";
    }
}
