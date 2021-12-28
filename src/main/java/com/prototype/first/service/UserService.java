package com.prototype.first.service;


import com.prototype.first.dto.SearchRequest;
import com.prototype.first.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto findUserByEmail(SearchRequest searchRequest);

    UserDto createUser(UserDto userDto);

    List<UserDto> getAll();

    UserDto getById(Long id);

    void deleteUserById(Long id);

    UserDto getCurrentUser();
}

