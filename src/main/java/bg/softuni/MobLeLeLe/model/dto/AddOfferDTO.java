package bg.softuni.MobLeLeLe.model.dto;

import bg.softuni.MobLeLeLe.model.entity.enums.Engine;

public record AddOfferDTO(
        String description,
        Engine engine,
        int mileage
) {
    public static AddOfferDTO empty() {
        return new AddOfferDTO(null, null, 0);
    }
}
