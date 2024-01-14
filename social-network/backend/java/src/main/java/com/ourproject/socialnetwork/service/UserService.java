package com.ourproject.socialnetwork.service;

import com.ourproject.socialnetwork.config.Role;
import com.ourproject.socialnetwork.entity.User;
import com.ourproject.socialnetwork.mapper.UserMapper;
import com.ourproject.socialnetwork.model.UserDto;
import com.ourproject.socialnetwork.repository.UserRepository;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final SequenceGeneratorService userSequenceService;

    @Autowired
    public UserService(UserRepository userRepository, SequenceGeneratorService userSequenceService) {
        this.userRepository = userRepository;
        this.userSequenceService = userSequenceService;
    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    public User getUserByUserName(String name) {
        var user = userRepository.findUserByUsername(name);
        return user.orElseThrow(() -> new NoSuchElementException("User not found with name " + name));
    }

    public User updateUser(UserDto userUpdate) {
        var user = UserMapper.INSTANCE.UserDtoToUser(userUpdate);
        return userRepository.save(user);
    }

    public void deleteUser(Long id) throws DuplicateKeyException {
        userRepository.deleteById(id);
    }
}