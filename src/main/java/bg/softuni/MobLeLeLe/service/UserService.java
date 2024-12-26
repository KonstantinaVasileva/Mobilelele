package bg.softuni.MobLeLeLe.service;

import bg.softuni.MobLeLeLe.model.dto.UserLoginDTO;
import bg.softuni.MobLeLeLe.model.dto.UserRegistrationDTO;

public interface UserService {

    void registerUser(UserRegistrationDTO userRegistrationDTO);

    boolean loginUser(UserLoginDTO userLoginDTO);
    void logoutUser();
}
