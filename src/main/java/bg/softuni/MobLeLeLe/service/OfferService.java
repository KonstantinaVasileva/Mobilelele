package bg.softuni.MobLeLeLe.service;

import bg.softuni.MobLeLeLe.model.dto.AddOfferDTO;
import bg.softuni.MobLeLeLe.model.dto.OfferDetailDTO;

public interface OfferService {
    long createOffer(AddOfferDTO addOfferDTO);
    OfferDetailDTO getOfferById(Long id);
}
