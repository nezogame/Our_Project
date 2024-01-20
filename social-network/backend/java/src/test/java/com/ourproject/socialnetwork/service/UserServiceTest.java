package com.ourproject.socialnetwork.service;

import com.ourproject.socialnetwork.config.Role;
import com.ourproject.socialnetwork.entity.User;
import com.ourproject.socialnetwork.enums.Gender;
import com.ourproject.socialnetwork.model.UserDto;
import com.ourproject.socialnetwork.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.EmptyResultDataAccessException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    UserService service;

    @Mock
    UserRepository repository;

    @Mock
    SequenceGeneratorService sequenceGeneratorService;


    @SneakyThrows
    @DisplayName("Unit test for FindAllUser method")
    @Test
    void testFindAllTwoUser() {
        // Given
        List<User> list = new ArrayList<User>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
        String firstDateInString = "07.04.2013";
        String firstJoindDateInString = "12.08.2018";
        String secondDateInString = "12.01.2001";
        String secondJoindDateInString = "21.10.2010";
        Date firstUserDob = formatter.parse(firstDateInString);
        Date firstUserJoinDate = formatter.parse(firstJoindDateInString);
        Date secondUserDob = formatter.parse(secondDateInString);
        Date secondUserJoinDate = formatter.parse(secondJoindDateInString);
        User userOne = User.builder()
                .userId(1L)
                .mail("Alex@gmail.com")
                .password("eu@t^>`RB8p!ayU2WA&_J6")
                .username("Alexius")
                .dob(firstUserDob)
                .userBio(null)
                .chatId(null)
                .followers(3)
                .following(14)
                .postId(null)
                .joinDate(firstUserJoinDate)
                .photoPtr(null)
                .gender(Gender.MALE)
                .role(Role.USER)
                .build();

        User userTwo = User.builder()
                .userId(2L)
                .mail("Steve@gmail.com")
                .password("k}3c-^6yveupb+/&T2BE;n")
                .username("Steve")
                .dob(secondUserDob)
                .userBio(null)
                .chatId(null)
                .followers(100)
                .following(23)
                .postId(null)
                .joinDate(secondUserJoinDate)
                .photoPtr(null)
                .gender(Gender.MALE)
                .role(Role.USER)
                .build();

        list.add(userOne);
        list.add(userTwo);

        when(repository.findAll()).thenReturn(list);

        // When
        List<UserDto> result = service.findAllUser();

        // Then
        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(2);
        verify(repository, times(1)).findAll();
    }


    @DisplayName("Unit test for FindAllUser method when no user exist")
    @Test
    void testFindUserWhenNoUserExist() {
        // Given
        List<User> list = new ArrayList<User>();

        when(repository.findAll()).thenReturn(list);

        // When
        List<User> result = repository.findAll();

        // Then
        assertThat(result).isEmpty();
        verify(repository, times(1)).findAll();
    }

    @DisplayName("Test getUserByUserName method when user is present")
    @Test
    void testGetUserByUserNameWhenUserExist() {
        User user = User.builder()
                .userId(1L)
                .mail("Alex@gmail.com")
                .password("eu@t^>`RB8p!ayU2WA&_J6")
                .username("Alexius")
                .dob(null)
                .userBio(null)
                .chatId(null)
                .followers(3)
                .following(14)
                .postId(null)
                .joinDate(null)
                .photoPtr(null)
                .gender(Gender.MALE)
                .role(Role.USER)
                .build();
        // Given
        UserDto mappedUser = new UserDto(
                1L,
                "Alexius",
                "eu@t^>`RB8p!ayU2WA&_J6",
                "Alex@gmail.com",
                Gender.MALE,
                null,
                null,
                null,
                3,
                14,
                null,
                null,
                null,
                Role.USER);

        when(repository.findUserByUsername("Alexius")).thenReturn(Optional.of(user));

        // When
        UserDto result = service.getUserByUserName("Alexius");

        // Then
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(mappedUser);
        verify(repository, times(1)).findUserByUsername("Alexius");
    }

    @DisplayName("Test getUserByUserName method when a user doesn't exist")
    @Test()
    void testGetUserByUserNameWhenUserDoesNotExist() {
        // Given
        when(repository.findUserByUsername("Alexius")).thenReturn(Optional.empty());

        // When
        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class,
                () -> service.getUserByUserName("Alexius"),
                "User not found with name Alexius");
        assertEquals("User not found with name Alexius", exception.getMessage());
    }

    @DisplayName("Test getUserByUserName method when null passed as argument")
    @Test()
    void testGetUserByUserNameWhenNullPassedAsArgument() {
        // When
        assertThrows(EntityNotFoundException.class, () -> service.getUserByUserName(null));
    }

    @DisplayName("Test updateUser method when null passed as argument")
    @Test()
    void testUpdateUserWhenNullPassedAsArgument() {
        // When
        NullPointerException exception = assertThrows(NullPointerException.class,
                () -> service.updateUser(null));
    }

    @SneakyThrows
    @DisplayName("Test updateUser method when all ok ")
    @Test()
    void testUpdateUserWhenAllOk() {
        // Given
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
        String secondDateInString = "12.01.2001";
        String secondJoindDateInString = "21.10.2010";
        Date secondUserDob = formatter.parse(secondDateInString);
        Date secondUserJoinDate = formatter.parse(secondJoindDateInString);
        User user = User.builder()
                .userId(1L)
                .mail("Steve@gmail.com")
                .password("k}3c-^6yveupb+/&T2BE;n")
                .username("Steve")
                .dob(secondUserDob)
                .userBio(null)
                .chatId(null)
                .followers(100)
                .following(23)
                .postId(null)
                .joinDate(secondUserJoinDate)
                .photoPtr(null)
                .gender(Gender.MALE)
                .role(Role.USER)
                .build();

        UserDto userForUpdate = new UserDto(
                1L,
                "Steve",
                "k}3c-^6yveupb+/&T2BE;n",
                "Steve@gmail.com",
                Gender.MALE,
                null,
                null,
                null,
                100,
                23,
                null,
                secondDateInString,
                secondJoindDateInString,
                Role.USER);
        when(repository.existsById(1L)).thenReturn(true);
        when(repository.save(user)).thenReturn(user);

        // When
        var result = service.updateUser(userForUpdate);
        // Then
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(userForUpdate);
        verify(repository, times(1)).save(user);

    }

    @DisplayName("Test updateUser method when null passed as argument")
    @Test()
    void testUpdateUserWhenAllOkf() {
        // Given
        UserDto userForUpdate = new UserDto(
                1L,
                "Steve",
                "k}3c-^6yveupb+/&T2BE;n",
                "Steve@gmail.com",
                Gender.MALE,
                null,
                null,
                null,
                100,
                23,
                null,
                null,
                null,
                Role.USER);
        when(repository.existsById(1L)).thenReturn(false);

        // When
        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class,
                () -> service.updateUser(userForUpdate));
        assertEquals("User not found with id: 1", exception.getMessage());
    }

    @DisplayName("Test deleteUser method when id doesn't exist")
    @Test()
    void testDeleteUserWhenEntityDoesNotExist() {
        // Give
        Long userId = 123L;

        when(repository.existsById(userId)).thenReturn(false);
        // When
        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class,
                () -> service.deleteUser(userId));
        assertEquals("User with id: 123 doesn't exist", exception.getMessage());
    }

    @DisplayName("Test deleteUser method when all ok")
    @Test()
    void testDeleteUserWhenAllOk() {
        // Give
        Long userId = 123L;

        when(repository.existsById(userId)).thenReturn(true);
        // When
        service.deleteUser(userId);
        // Then
        verify(repository, times(1)).deleteById(userId);
    }
}