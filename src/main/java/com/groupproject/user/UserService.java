package com.groupproject.user;

import java.util.List;

interface UserService {

    List<UserDto> findAll();

    UserDto findOneByUuid(String uuid);

    UserDto findOneByLogin(String login);

    void deletedAsTrue(String uuid);

    UserDto register(UserRegistrationDto dto);

    boolean checkIfLoginExist(String login);
}
