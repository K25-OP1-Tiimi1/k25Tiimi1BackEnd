package k25tiimi1backend.k25tiimi1backend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import k25tiimi1backend.k25tiimi1backend.domain.ProductRepository;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/productlist")
    public String productlist(Model model) {
        model.addAttribute("productList", productRepository.findAll());
        return "productlist";
    }
    
}
