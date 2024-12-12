package bg.softuni.MobLeLeLe.web;

import bg.softuni.MobLeLeLe.model.dto.AddOfferDTO;
import bg.softuni.MobLeLeLe.model.entity.enums.Engine;
import bg.softuni.MobLeLeLe.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/offers/add")
    public String addOffer(Model model) {
        if (!model.containsAttribute("addOfferDTO")) {
            model.addAttribute("addOfferDTO", AddOfferDTO.empty());
        }

        model.addAttribute("allEngineTypes", Engine.values());
        return "offer-add";
    }

    @PostMapping("/offers/add")
    public String createOffer(AddOfferDTO addOfferDTO) {

        offerService.createOffer(addOfferDTO);

        return "offer-add";
    }
}
