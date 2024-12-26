package bg.softuni.MobLeLeLe.web;

import bg.softuni.MobLeLeLe.model.dto.AddOfferDTO;
import bg.softuni.MobLeLeLe.model.entity.enums.Engine;
import bg.softuni.MobLeLeLe.service.OfferService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @ModelAttribute("allEngineTypes")
    public Engine[] getAllEngineTypes() {
        return Engine.values();
    }

    @GetMapping("/add")
    public String addOffer(Model model) {
        if (!model.containsAttribute("addOfferDTO")) {
            model.addAttribute("addOfferDTO", AddOfferDTO.empty());
        }

       // model.addAttribute("allEngineTypes", Engine.values());
        return "offer-add";
    }

    @PostMapping("/add")
    public String createOffer(@Valid AddOfferDTO addOfferDTO,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addOfferDTO", addOfferDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.addOfferDTO", bindingResult);
            return "redirect:/offers/add";
        }

        long offerId = offerService.createOffer(addOfferDTO);

        return "redirect:/offers/" + offerId;
    }

    @GetMapping("/{id}")
    public String getOfferDetails(@PathVariable("id") Long id, Model model){
        model.addAttribute("offer", offerService.getOfferById(id));
        return "details";
    }

    @DeleteMapping("/{id}")
    public String deleteOffer(@PathVariable("id") Long id) {
        offerService.deleteOfferById(id);
        return "redirect:/offers/all";
    }

}
