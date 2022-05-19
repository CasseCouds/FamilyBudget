package com.seiton.familybudget.service;

import com.seiton.familybudget.exception.UserNotFoundException;
import com.seiton.familybudget.model.User;
import com.seiton.familybudget.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(long id){
        return userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException()
        );
    }

    public long addUser(User user){
        return userRepository.save(user).getId();
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    public void updateUser(long id, User user) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            userRepository.save(user);
        } else {
            throw new UserNotFoundException();
        }
    }


}
