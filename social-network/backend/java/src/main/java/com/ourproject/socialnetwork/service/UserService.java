package com.ourproject.socialnetwork.service;

import com.ourproject.socialnetwork.entity.User;
import com.ourproject.socialnetwork.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    public User getUserByUserName(String name) {
        var user = userRepository.findUserByUsername(name);

        return user.orElseThrow();
    }

    public User addUser(User user) throws DuplicateKeyException {
        return userRepository.insert(user);
    }

    public User updateUser(User user) throws DuplicateKeyException {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) throws DuplicateKeyException {
        userRepository.deleteById(id);
    }
}