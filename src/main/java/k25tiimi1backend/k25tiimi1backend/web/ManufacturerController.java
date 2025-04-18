package k25tiimi1backend.k25tiimi1backend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import k25tiimi1backend.k25tiimi1backend.domain.Manufacturer;
import k25tiimi1backend.k25tiimi1backend.domain.ManufacturerRepository;

@Controller
public class ManufacturerController {

     @Autowired
    private ManufacturerRepository manufacturerRepository;



      @GetMapping("/manufacturerlist")
    public String manufacturerlist(Model model) {
        model.addAttribute("manufacturerList", manufacturerRepository.findAll());
        return "manufacturerlist";
    }

    @GetMapping("/addmanufacturer")
    public String addManufacturer(Model model) {
        model.addAttribute("manufacturer", new Manufacturer());
        model.addAttribute("manufacturerList", manufacturerRepository.findAll());
        return "addmanufacturer";
    }
    
    @PostMapping("/savemanufacturer")
    public String saveProduct(Manufacturer manufacturer) {
        manufacturerRepository.save(manufacturer);
        return "redirect:/manufacturerlist";
    }

    @GetMapping("/deletemanufacturer/{id}")
    public String deleteManufacturer(@PathVariable("id") Long manufacturerId,  RedirectAttributes redirectAttributes) {
    Manufacturer manufacturer = manufacturerRepository.findById(manufacturerId).orElse(null);

    if (manufacturer == null) {
        redirectAttributes.addFlashAttribute("error", "Manufacturer not found");
        return "redirect:/manufacturerlist";
    }

    
    if (manufacturer.getProducts() != null && !manufacturer.getProducts().isEmpty()) {
        redirectAttributes.addFlashAttribute("error", "Cannot delete manufacturer with existing products :-( ");
        return "redirect:/manufacturerlist";
    }

    
    manufacturerRepository.deleteById(manufacturerId);
    return "redirect:/manufacturerlist";
}

    



}
