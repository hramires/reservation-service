package com.reservation.converter;

import com.reservation.domain.User;
import com.reservation.dto.CostumerDto;
import com.reservation.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverter {

    public List<User> convertFromDto(List<UserDto> usersDto) {
        return usersDto.stream()
                .map(userDto-> convert(userDto))
                .collect(Collectors.toList());
    }

    private User convert(UserDto userDto) {
        return new User(userDto.getName(), getDocument(userDto), userDto.getTelefone(), userDto.getDeletado());
    }

    private String getDocument(UserDto userDto) {
        return userDto.getCpf().replace(".", "").replace("-", "");
    }

    public List<CostumerDto> convertFromDomain(List<User> users) {
        return users.stream()
                .filter(user -> user.getActive())
                .map(user -> convert(user))
                .collect(Collectors.toList());
    }

    private CostumerDto convert(User user) {
        return new CostumerDto(user.getName(), user.getDocument());
    }

}
