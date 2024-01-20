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

    public List<UserDto> findAllUser() {
        var users = userRepository.findAll();
        return users.stream()
                .map(UserMapper.INSTANCE::UserToUserDto)
                .toList();
    }

    public UserDto getUserByUserName(String name) throws EntityNotFoundException {
        var optionalUser = userRepository.findUserByUsername(name);
        var user = optionalUser.orElseThrow(() -> new EntityNotFoundException("User not found with name " + name));
        return UserMapper.INSTANCE.UserToUserDto(user);
    }

    @Transactional
    public UserDto updateUser(UserDto userUpdate) throws EntityNotFoundException {
        var user = UserMapper.INSTANCE.UserDtoToUser(userUpdate);
        if (!userRepository.existsById(user.getUserId())) {
            throw new EntityNotFoundException("User not found with id: " + user.getUserId());
        }
        user = userRepository.save(user);
        return UserMapper.INSTANCE.UserToUserDto(user);
    }

    public void deleteUser(Long id) throws EntityNotFoundException {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException("User with id: " + id + " doesn't exist");
        }
        userRepository.deleteById(id);
    }
}