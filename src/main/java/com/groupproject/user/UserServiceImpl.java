package com.groupproject.user;

import com.groupproject.player.PlayerFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PlayerFacade playerFacade;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PlayerFacade playerFacade) {
        this.userRepository = userRepository;
        this.playerFacade = playerFacade;
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
        User user = new User(dto.getLogin(), dto.getPassword(), dto.getEmail());
        userRepository.save(user);
        playerFacade.createPlayer(user.getUuid());
        return new UserDto(user);
    }

    @Override
    public void deletedAsTrue(String uuid) {
        userRepository.findOneByUuid(uuid).setDeleted(true);
    }

}
