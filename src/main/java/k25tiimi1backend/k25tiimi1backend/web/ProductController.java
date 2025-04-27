package k25tiimi1backend.k25tiimi1backend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

import k25tiimi1backend.k25tiimi1backend.domain.Product;
import k25tiimi1backend.k25tiimi1backend.domain.ProductRepository;
import k25tiimi1backend.k25tiimi1backend.domain.ProductType;
import k25tiimi1backend.k25tiimi1backend.domain.Size;
import k25tiimi1backend.k25tiimi1backend.domain.Manufacturer;
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
        model.addAttribute("sizeList", Size.values());
        model.addAttribute("productTypeList", ProductType.values());
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

    @PostMapping("/products/update")
    public String updateQuantity(@RequestParam Long id, @RequestParam String action) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if ("increase".equals(action)) {
            product.setQuantity(product.getQuantity() + 1);
        } else if ("decrease".equals(action)) {
            product.setQuantity(Math.max(product.getQuantity() - 1, 0));
        }

        productRepository.save(product);
        return "redirect:/productlist";
    }

    // get all products by manufacturer
    @GetMapping("/manufacturer/{id}/products")
    public String viewManufacturersProducts(@PathVariable("id") Long manufacturerId,
            RedirectAttributes redirectAttributes,
            Model model) {

        Manufacturer manufacturer = manufacturerRepository.findById(manufacturerId).orElse(null);

        if (manufacturer == null) {
            redirectAttributes.addFlashAttribute("error", "Manufacturer not found");
            return "redirect:/manufacturerlist";
        }

        // fetch all products by manufacturer
        List<Product> products = productRepository.findByManufacturer(manufacturer);

        // add manufacturer and products to model
        model.addAttribute("manufacturer", manufacturer);
        model.addAttribute("products", products);

        return "manufacturers-products";
    }

}
