package bg.softuni.MobLeLeLe.service.impl;

import bg.softuni.MobLeLeLe.model.dto.AddOfferDTO;
import bg.softuni.MobLeLeLe.model.dto.OfferDetailDTO;
import bg.softuni.MobLeLeLe.model.entity.Offer;
import bg.softuni.MobLeLeLe.repository.OfferRepository;
import bg.softuni.MobLeLeLe.service.OfferService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public long createOffer(AddOfferDTO addOfferDTO) {
        Offer offer = mapToOffer(addOfferDTO);
        offerRepository.save(offer);
        return offer.getId();
    }

    @Override
    public OfferDetailDTO getOfferById(Long id) {
        return offerRepository.findById(id)
                .map(OfferServiceImpl::mapToOfferDetailDTO)
                .orElseThrow();
    }

    @Override
    public List<OfferDetailDTO> getAllOffers() {
        return offerRepository.findAll()
                .stream().map(OfferServiceImpl::mapToOfferDetailDTO)
                .toList();
    }

    @Override
    public void deleteOfferById(Long id) {
        offerRepository.deleteById(id);
    }


    private static OfferDetailDTO mapToOfferDetailDTO(Offer offer) {
        return new OfferDetailDTO(
                offer.getId(),
                offer.getDescription(),
                offer.getMileage(),
                offer.getEngine()
        );
    }

    private static Offer mapToOffer(AddOfferDTO addOfferDTO) {

        return new Offer()
                .setDescription(addOfferDTO.description())
                .setEngine(addOfferDTO.engine())
                .setMileage(addOfferDTO.mileage());
    }
}
