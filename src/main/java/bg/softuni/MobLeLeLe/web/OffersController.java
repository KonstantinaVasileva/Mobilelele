package bg.softuni.MobLeLeLe.web;

import bg.softuni.MobLeLeLe.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/offers")
public class OffersController {

    private final OfferService offerService;

    public OffersController(OfferService offerService) {
        this.offerService = offerService;
    }


    @GetMapping("/all")
    public String allOffers(Model model){
        model.addAttribute("allOffers", offerService.getAllOffers());
        return "offers";
    }


}
