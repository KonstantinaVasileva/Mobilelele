package bg.softuni.MobLeLeLe.service.impl;

import bg.softuni.MobLeLeLe.model.dto.UserRegistrationDTO;
import bg.softuni.MobLeLeLe.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void registerUser(UserRegistrationDTO userRegistrationDTO) {
        System.out.println("The user received is " + userRegistrationDTO);
    }
}
