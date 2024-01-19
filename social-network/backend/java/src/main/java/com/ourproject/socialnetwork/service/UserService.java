package com.ourproject.socialnetwork.service;

import com.ourproject.socialnetwork.entity.User;
import com.ourproject.socialnetwork.mapper.UserMapper;
import com.ourproject.socialnetwork.model.UserDto;
import com.ourproject.socialnetwork.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository, SequenceGeneratorService userSequenceService) {
        this.userRepository = userRepository;
    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    public User getUserByUserName(String name) throws EntityNotFoundException {
        var user = userRepository.findUserByUsername(name);
        return user.orElseThrow(() -> new EntityNotFoundException("User not found with name " + name));
    }

    @Transactional
    public User updateUser(UserDto userUpdate) throws EntityNotFoundException {
        var user = UserMapper.INSTANCE.UserDtoToUser(userUpdate);
        if (!userRepository.existsById(user.getUserId())) {
            throw new EntityNotFoundException("User not found with id: " + user.getUserId());
        }
        return userRepository.save(user);
    }

    public void deleteUser(Long id) throws EmptyResultDataAccessException {
        userRepository.deleteById(id);
    }
}