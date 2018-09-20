package com.groupproject.user;

import java.util.List;

interface UserService {

    List<UserDto> findAll();

    UserDto findOneByUuid(String uuid);

    void deletedAsTrue(String uuid);

    UserDto register(UserRegistrationDto dto);
}
