package com.groupproject.user;

import com.groupproject.player.PlayerFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PlayerFacade playerFacade;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PlayerFacade playerFacade, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.playerFacade = playerFacade;
        this.passwordEncoder = passwordEncoder;
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
    public UserDto findOneByLogin(String login) {
        return new UserDto(userRepository.findOneByLogin(login));
    }

    @Override
    public void deletedAsTrue(String uuid) {
        User user = userRepository.findOneByUuid(uuid);
        user.setDeleted(true);
        user.setPassword(passwordEncoder.encode(UUID.randomUUID().toString()));
    }

    @Override
    public UserDto register(UserRegistrationDto dto) {
        User user = new User(dto.getLogin(), passwordEncoder.encode(dto.getPassword()), dto.getEmail());
        userRepository.save(user);
        playerFacade.createPlayer(user.getUuid());
        return new UserDto(user);
    }

    @Override
    public boolean checkIfLoginExist(String login) {
        return userRepository.existsByLogin(login);
    }
}
