package k25tiimi1backend.k25tiimi1backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import k25tiimi1backend.k25tiimi1backend.domain.Product;
import k25tiimi1backend.k25tiimi1backend.domain.ProductRepository;
import k25tiimi1backend.k25tiimi1backend.domain.Valmistaja;
import k25tiimi1backend.k25tiimi1backend.domain.ValmistajaRepository;

@SpringBootApplication
public class K25tiimi1backendApplication {

    private final ValmistajaRepository valmistajaRepository;

    K25tiimi1backendApplication(ValmistajaRepository valmistajaRepository) {
        this.valmistajaRepository = valmistajaRepository;
    }

	public static void main(String[] args) {
		SpringApplication.run(K25tiimi1backendApplication.class, args);
	}

	// Luotu omaa testaamista varten. Saa muokata oman maun ja tarpeiden mukaan t:
	// Jussi
	@Bean
	public CommandLineRunner demo(ProductRepository productRepository, ValmistajaRepository valmistajaRepository) {
		return (args) -> {
			
			Valmistaja valmistaja1 = new Valmistaja();
			valmistaja1.setNimi("Nike");

			Valmistaja valmistaja2 = new Valmistaja();
			valmistaja2.setNimi("Rukka");

			valmistajaRepository.save(valmistaja1);
			valmistajaRepository.save(valmistaja2);


			// Testi tuotteet
			Product A = new Product("Testituote 1", "Testituotteen 1 kuvaus");
			A.setValmistaja(valmistaja1);
		

			Product B = new Product("Testituote 2", "Testituotteen 2 kuvaus");
			B.setValmistaja(valmistaja2);

			Product C = new Product("Testituote 3", "Testituotteen 3 kuvaus");
			C.setValmistaja(valmistaja1);

			productRepository.save(A);
			productRepository.save(B);
			productRepository.save(C);
		};
	}

}
