package bg.softuni.MobLeLeLe.model.dto;

import bg.softuni.MobLeLeLe.model.entity.enums.Engine;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AddOfferDTO(
        @NotNull
        @Size(min = 3, max = 2000)
        String description,
        Engine engine,
        @NotNull
        int mileage
) {
    public static AddOfferDTO empty() {
        return new AddOfferDTO(null, null, 0);
    }
}
