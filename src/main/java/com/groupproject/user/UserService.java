package com.groupproject.user;

import java.util.List;

interface UserService {

    List<UserDto> findAll();

    UserDto findOneByUuid(String uuid);

    UserDto create(UserCreateDto userCreateDto);

    void delete(String uuid);
}
