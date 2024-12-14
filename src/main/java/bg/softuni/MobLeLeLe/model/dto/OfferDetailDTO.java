package bg.softuni.MobLeLeLe.model.dto;

import bg.softuni.MobLeLeLe.model.entity.enums.Engine;

public record OfferDetailDTO (
        long id,
        String description,
        int mileage,
        Engine engine
){
}
