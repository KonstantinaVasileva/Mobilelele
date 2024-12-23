package bg.softuni.MobLeLeLe.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRegistrationDTO(
        @NotBlank
        @Size(min = 3, max = 30)
        String firstName,
        @NotBlank
        @Size(min = 3, max = 30)
        String lastName,
        @NotBlank
        String password,
        @NotBlank
        @Email
        String email) {
}
