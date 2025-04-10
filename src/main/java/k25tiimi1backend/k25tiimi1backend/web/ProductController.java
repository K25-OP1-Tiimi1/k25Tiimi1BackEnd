package k25tiimi1backend.k25tiimi1backend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import k25tiimi1backend.k25tiimi1backend.domain.Product;
import k25tiimi1backend.k25tiimi1backend.domain.ProductRepository;
import k25tiimi1backend.k25tiimi1backend.domain.ManufacturerRepository;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @GetMapping("/productlist")
    public String productlist(Model model) {
        model.addAttribute("productList", productRepository.findAll());
        model.addAttribute("manufacturerList", manufacturerRepository.findAll());
        return "productlist";
    }

    @GetMapping("/addproduct")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("manufacturerList", manufacturerRepository.findAll());
        return "addproduct";
    }
    
    @PostMapping("/saveproduct")
    public String saveProduct(@ModelAttribute Product product) {
        productRepository.save(product);
        return "redirect:/productlist";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long productId) {
        productRepository.deleteById(productId);
        return "redirect:/productlist";
}

@GetMapping("/edit/{id}")
public String editProduct(@PathVariable("id") Long id, Model model) {
    Product product = productRepository.findById(id).orElse(null); 
    model.addAttribute("product", product);
    model.addAttribute("manufacturerList", manufacturerRepository.findAll());

    return "editproduct";
}

}

