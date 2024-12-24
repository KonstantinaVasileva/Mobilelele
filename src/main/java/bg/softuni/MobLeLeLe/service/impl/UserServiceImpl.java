package bg.softuni.MobLeLeLe.service.impl;

import bg.softuni.MobLeLeLe.model.dto.UserRegistrationDTO;
import bg.softuni.MobLeLeLe.model.entity.User;
import bg.softuni.MobLeLeLe.repository.UserRepository;
import bg.softuni.MobLeLeLe.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserServiceImpl(ModelMapper modelMapper, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(UserRegistrationDTO userRegistrationDTO) {
        userRepository.save(map(userRegistrationDTO));
    }

    private User map(UserRegistrationDTO userRegistrationDTO) {

        User map = modelMapper.map(userRegistrationDTO, User.class);

        map.setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));
        return map;
    }
}
