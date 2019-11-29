package com.reservation.service;

import com.reservation.converter.UserConverter;
import com.reservation.domain.User;
import com.reservation.dto.CostumerDto;
import com.reservation.dto.UserDto;
import com.reservation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    public User findByDocument(String cpf) {
        return userRepository.findByDocument(cpf).get();
    }

    public void save(List<UserDto> usersDto) {
        List<User> users = userConverter.convertFromDto(usersDto);
        users.stream().forEach(System.out::println);
        users.stream().map(user -> userRepository.save(user));
    }

    public List<CostumerDto> findAll() {
        return userConverter.convertFromDomain(userRepository.findAll());
    }
}
