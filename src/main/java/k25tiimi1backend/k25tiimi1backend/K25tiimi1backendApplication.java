package k25tiimi1backend.k25tiimi1backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import k25tiimi1backend.k25tiimi1backend.domain.Product;
import k25tiimi1backend.k25tiimi1backend.domain.ProductRepository;
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
			manufacturer1.setNimi("Nike");

			Manufacturer manufacturer2 = new Manufacturer();
			manufacturer2.setNimi("Rukka");

			manufacturerRepository.save(manufacturer1);
			manufacturerRepository.save(manufacturer2);


			// Testi tuotteet
			Product A = new Product("Testituote 1", "Testituotteen 1 kuvaus");
			A.setmanufacturer(manufacturer1);
		

			Product B = new Product("Testituote 2", "Testituotteen 2 kuvaus");
			B.setmanufacturer(manufacturer2);

			Product C = new Product("Testituote 3", "Testituotteen 3 kuvaus");
			C.setmanufacturer(manufacturer1);

			productRepository.save(A);
			productRepository.save(B);
			productRepository.save(C);
		};
	}

}
