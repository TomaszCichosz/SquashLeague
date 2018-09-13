package com.groupproject.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(UserDto::new).collect(Collectors.toList());
    }

    @Override

    public UserDto findOneByUuid(String uuid) {
        return new UserDto(userRepository.findOneByUuid(uuid));
    }

    @Override
    public UserDto create(UserCreateDto dto) {
        User user = new User(dto.getName(), dto.getSurname(),
                dto.getEmail(), dto.getLogin(), dto.getPassword(), dto.getStartingRanking());
        return new UserDto(userRepository.save(user));
    }

    @Override
    public void delete(String uuid) {
        userRepository.deleteByUuid(uuid);
    }
}
