package com.reservation.service;

import com.reservation.converter.UserConverter;
import com.reservation.domain.User;
import com.reservation.dto.CostumerDto;
import com.reservation.dto.UserDto;
import com.reservation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    public User findByDocument(String cpf) {
        Optional<User> optionalUser = userRepository.findByDocument(cpf);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        return null;
    }

    public void save(List<UserDto> usersDto) {
        List<User> users = userConverter.convertFromDto(usersDto);
        users.stream().map(user -> saveUser(user)).collect(Collectors.toList());
    }

    private User saveUser(User user) {
        Optional<User> optionalUser = userRepository.findByDocument(user.getDocument());
        if (optionalUser.isPresent()) {
            User existsUser = optionalUser.get();
            existsUser.setName(user.getName());
            existsUser.setActive(user.getActive());
            existsUser.setPhone(user.getPhone());
            return userRepository.save(existsUser);
        } else {
            return userRepository.save(user);
        }
    }

    public List<CostumerDto> findAll() {
        List<User> users = userRepository.findAll();
        return userConverter.convertFromDomain(users);
    }

    public User findByName(String name) {
        List<User> users = userRepository.findByName(name);
        if (!users.isEmpty()) {
            return users.get(0);
        }
        return null;
    }
}
