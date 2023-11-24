package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.respository.UserRespository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {

    private UserRespository userRepository;
    private PasswordEncoder passEncoder;
    private UserMapper userMapper;

    public UserDto save(UserDto userDto) {
        User user = userMapper.mapToEntity(userDto);
        user.setPassword(passEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);
        return userMapper.mapToDto(savedUser);
    }

    public User updateUserById(User user, Long id) {
        Optional<User> existingUser = userRepository.findById(id);

        if (existingUser.isPresent()) {
            existingUser.get().setFirstName(user.getFirstName());
            existingUser.get().setLastName(user.getLastName());
            existingUser.get().setEmail(user.getEmail());
            existingUser.get().setRoles(user.getRoles());
            existingUser.get().setUsername(user.getUsername());
            existingUser.get().setPassword(passEncoder.encode(user.getPassword()));
            existingUser.get().setId(id);

            userRepository.save(existingUser.get());

        } else {
            throw new RuntimeException("User with id: " + id + " was not found");
        }

        return existingUser.get();
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(long id) {
        Optional<User> existingUser = userRepository.findById(id);
        return existingUser.orElseThrow(() -> new RuntimeException("User with id: " + id + " was not found"));
    }

    public void deleteUserById(long id) {
        Optional<User> existingUser = userRepository.findById(id);
        existingUser.ifPresent(userRepository::delete);
    }
}
