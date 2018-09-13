package com.groupproject.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
class UserServiceImpl implements UserService {

    @Override
    public List<UserDto> findAll() {
        return null;
    }

    @Override
    public UserDto findOneByUuid(String uuid) {
        return null;
    }

    @Override
    public UserDto create(UserCreateDto userCreateDto) {
        return null;
    }

    @Override
    public void delete(String uuid) {

    }
}
