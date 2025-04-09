package k25tiimi1backend.k25tiimi1backend;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import k25tiimi1backend.k25tiimi1backend.domain.Product;
import k25tiimi1backend.k25tiimi1backend.domain.ProductRepository;
import k25tiimi1backend.k25tiimi1backend.domain.ProductType;
import k25tiimi1backend.k25tiimi1backend.domain.Manufacturer;
import k25tiimi1backend.k25tiimi1backend.domain.ManufacturerRepository;

@SpringBootApplication
public class K25tiimi1backendApplication {

	private final ManufacturerRepository ManufacturerRepository;

	K25tiimi1backendApplication(ManufacturerRepository manufacturerRepository) {
		this.ManufacturerRepository = manufacturerRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(K25tiimi1backendApplication.class, args);
	}

	// Luotu omaa testaamista varten. Saa muokata oman maun ja tarpeiden mukaan t:
	// Jussi
	@Bean
	public CommandLineRunner demo(ProductRepository productRepository, ManufacturerRepository manufacturerRepository) {
		return (args) -> {

			Manufacturer manufacturer1 = new Manufacturer();
			manufacturer1.setName("Nike");

			Manufacturer manufacturer2 = new Manufacturer();
			manufacturer2.setName("Rukka");

			manufacturerRepository.save(manufacturer1);
			manufacturerRepository.save(manufacturer2);

			// Testi tuotteet
			Product toy = new Product(
					"Dog Toy",
					ProductType.TOY,
					"Red",
					"Medium",
					new BigDecimal("12.99"));
			
			toy.setManufacturer(manufacturer1);

			Product clothing = new Product(
					"Dog Sweater",
					ProductType.CLOTHING,
					"Blue",
					"Small",
					new BigDecimal("24.50"));
			
			clothing.setManufacturer(manufacturer2);

			Product food = new Product(
					"Premium Dog Food",
					ProductType.FOOD,
					"Brown",
					"1kg",
					new BigDecimal("19.95"));
			
			food.setManufacturer(manufacturer1);

			productRepository.save(toy);
			productRepository.save(clothing);
			productRepository.save(food);
		};
	}

}
