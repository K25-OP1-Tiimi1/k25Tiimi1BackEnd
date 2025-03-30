package k25tiimi1backend.k25tiimi1backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import k25tiimi1backend.k25tiimi1backend.domain.Product;
import k25tiimi1backend.k25tiimi1backend.domain.ProductRepository;

@SpringBootApplication
public class K25tiimi1backendApplication {

	public static void main(String[] args) {
		SpringApplication.run(K25tiimi1backendApplication.class, args);
	}


	//Luotu omaa testaamista varten. Saa muokata oman maun ja tarpeiden mukaan t: Jussi
	@Bean
	public CommandLineRunner demo(ProductRepository productRepository) {
		return (args) -> {
			//Testi tuotteet
			Product A = new Product("Testituote 1", "Testituotteen 1 kuvaus");
			Product B = new Product("Testituote 2", "Testituotteen 2 kuvaus");
			Product C = new Product("Testituote 3", "Testituotteen 3 kuvaus");

			productRepository.save(A);
			productRepository.save(B);
			productRepository.save(C);
		};
	}

}
