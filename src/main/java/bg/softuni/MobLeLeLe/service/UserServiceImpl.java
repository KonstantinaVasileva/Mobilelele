package bg.softuni.MobLeLeLe.service;

import bg.softuni.MobLeLeLe.model.dto.UserRegistrationDTO;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void registerUser(UserRegistrationDTO userRegistrationDTO) {
        System.out.println("The user received is " + userRegistrationDTO);
    }
}
