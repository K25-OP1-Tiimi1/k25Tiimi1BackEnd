package k25tiimi1backend.k25tiimi1backend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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



}
