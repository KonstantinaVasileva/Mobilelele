package bg.softuni.MobLeLeLe.service.impl;

import bg.softuni.MobLeLeLe.model.dto.UserLoginDTO;
import bg.softuni.MobLeLeLe.model.dto.UserRegistrationDTO;
import bg.softuni.MobLeLeLe.model.entity.User;
import bg.softuni.MobLeLeLe.repository.UserRepository;
import bg.softuni.MobLeLeLe.service.CurrentUser;
import bg.softuni.MobLeLeLe.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;

    public UserServiceImpl(ModelMapper modelMapper, PasswordEncoder passwordEncoder, UserRepository userRepository, CurrentUser currentUser) {
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(UserRegistrationDTO userRegistrationDTO) {
        User user = map(userRegistrationDTO);
        user.setUsername(userRegistrationDTO.getEmail());
        userRepository.save(user);
    }

    @Override
    public boolean loginUser(UserLoginDTO userLoginDTO) {

        User user = userRepository.findByUsername(userLoginDTO.username()).orElse(null);

        List<User> all = userRepository.findAll();
        for (User user1 : all) {
            System.out.println(user1.getUsername());
        }

        if (userLoginDTO.password() == null ||
                user == null ||
                user.getPassword() == null) {
            return false;
        }

        boolean matches = passwordEncoder.matches(userLoginDTO.password(), user.getPassword());

        if (matches) {
            currentUser.setFullName(user.getFirstName() + " " + user.getLastName());
            currentUser.setLoggedIn(true);
        } else {
            currentUser.clean();
        }

        return false;
    }

    private User map(UserRegistrationDTO userRegistrationDTO) {

        User map = modelMapper.map(userRegistrationDTO, User.class);

        map.setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));
        return map;
    }
}
