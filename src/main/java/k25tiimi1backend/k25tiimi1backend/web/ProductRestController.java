package k25tiimi1backend.k25tiimi1backend.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import k25tiimi1backend.k25tiimi1backend.domain.Product;
import k25tiimi1backend.k25tiimi1backend.domain.ProductRepository;
import k25tiimi1backend.k25tiimi1backend.domain.ProductType;

@RestController
@CrossOrigin
public class ProductRestController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/clothing")
    public List<Product> getAllClothingProducts() {
        return productRepository.findByProductType(ProductType.CLOTHING);
    }

}
