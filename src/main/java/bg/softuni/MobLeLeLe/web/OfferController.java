package bg.softuni.MobLeLeLe.web;

import bg.softuni.MobLeLeLe.model.entity.enums.Engine;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OfferController {
    @GetMapping("/offers/add")
    public String addOffer(Model model){
        model.addAttribute("allEngineTypes", Engine.values());
        return "offer-add";
    }
}
