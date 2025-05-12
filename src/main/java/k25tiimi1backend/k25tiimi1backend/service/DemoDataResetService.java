// Recreates demo data in the database
// and clears existing data

package k25tiimi1backend.k25tiimi1backend.service;

import k25tiimi1backend.k25tiimi1backend.domain.Manufacturer;
import k25tiimi1backend.k25tiimi1backend.domain.ManufacturerRepository;
import k25tiimi1backend.k25tiimi1backend.domain.Product;
import k25tiimi1backend.k25tiimi1backend.domain.ProductRepository;
import k25tiimi1backend.k25tiimi1backend.domain.ProductType;
import k25tiimi1backend.k25tiimi1backend.domain.ReservationRepository;
import k25tiimi1backend.k25tiimi1backend.domain.Size;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class DemoDataResetService {

    private final ManufacturerRepository manufacturerRepository;
    private final ProductRepository productRepository;
    private final ReservationRepository reservationRepository;

    public DemoDataResetService(ManufacturerRepository manufacturerRepository, ProductRepository productRepository, ReservationRepository reservationRepository) {
        this.manufacturerRepository = manufacturerRepository;
        this.productRepository = productRepository;
        this.reservationRepository = reservationRepository;
    }

    public void resetDemoData() {
        // Clear existing data
        reservationRepository.deleteAll();
        productRepository.deleteAll();
        manufacturerRepository.deleteAll();

        // Insert original demo data
        Manufacturer manufacturer1 = new Manufacturer();
        manufacturer1.setName("Nike");
        Manufacturer manufacturer2 = new Manufacturer();
        manufacturer2.setName("Rukka");

        manufacturerRepository.save(manufacturer1);
        manufacturerRepository.save(manufacturer2);

        // Insert demo products
        Product toy = new Product(
                "Dog Toy",
                ProductType.TOY,
                "Red",
                Size.M,
                new BigDecimal("12.99"),
                12);
        toy.setManufacturer(manufacturer1);

        Product clothing = new Product(
                "Dog Sweater",
                ProductType.CLOTHING,
                "Blue",
                Size.S,
                new BigDecimal("24.50"),
                9);
        clothing.setManufacturer(manufacturer2);

        Product food = new Product(
                "Premium Dog Food",
                ProductType.FOOD,
                "Brown",
                Size.ONE_KG,
                new BigDecimal("19.95"),
                32);
        food.setManufacturer(manufacturer1);

        productRepository.save(toy);
        productRepository.save(clothing);
        productRepository.save(food);
    }
}

