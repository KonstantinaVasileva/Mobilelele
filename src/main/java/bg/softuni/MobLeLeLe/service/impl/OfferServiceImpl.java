package bg.softuni.MobLeLeLe.service.impl;

import bg.softuni.MobLeLeLe.model.dto.AddOfferDTO;
import bg.softuni.MobLeLeLe.model.entity.Offer;
import bg.softuni.MobLeLeLe.model.repository.OfferRepository;
import bg.softuni.MobLeLeLe.service.OfferService;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public void createOffer(AddOfferDTO addOfferDTO) {
        Offer offer = mapToOffer(addOfferDTO);
        offerRepository.save(offer);
    }

    private static Offer mapToOffer(AddOfferDTO addOfferDTO) {
//        Offer offer = new Offer();
//        offer.setDescription(addOfferDTO.description());
//        offer.setEngine(addOfferDTO.engine());
        return new Offer()
                .setDescription(addOfferDTO.description())
                .setEngine(addOfferDTO.engine());
    }
}
