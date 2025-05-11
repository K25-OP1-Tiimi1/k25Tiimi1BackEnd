package k25tiimi1backend.k25tiimi1backend;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import k25tiimi1backend.k25tiimi1backend.domain.Manufacturer;
import k25tiimi1backend.k25tiimi1backend.domain.ManufacturerRepository;
import k25tiimi1backend.k25tiimi1backend.domain.Product;
import k25tiimi1backend.k25tiimi1backend.domain.ProductRepository;
import k25tiimi1backend.k25tiimi1backend.domain.ProductType;
import k25tiimi1backend.k25tiimi1backend.domain.Size;

// testing with postgres database
@SpringBootTest(classes = K25tiimi1backendApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class K25tiimi1backendApplicationTests {

	@Autowired
	private ProductRepository repository;
	@Autowired
	private ManufacturerRepository mRepository;

	// testing that the application context loads without issues
	@Test
	void contextLoads() {
	}

	// testing the creation of Product
	@Test
	public void createProduct() {
		// Create and save Product with data
		Product product = new Product();
		product.setProductName("Clothing 1");
		product.setProductType(ProductType.CLOTHING);
		product.setColor("red");
		product.setSize(Size.M);
		product.setPrice(new BigDecimal("35.50"));
		product.setQuantity(50);
		repository.save(product);

		// check if the Product exists
		assertThat(product.getId()).isNotNull();
		// check if the Product has the name "Clothing 1"
		assertEquals(product.getProductName(), "Clothing 1");
		// check that the Product does not have the type FOOD
		assertNotEquals(ProductType.FOOD, product.getProductType());
	}

	// testing the findByManufacturer method
	@Test
	public void findByManufacturerShouldReturnProductsByManufacturer() {
		// Create and save Manufacturer
		Manufacturer manufacturer = new Manufacturer();
		manufacturer.setName("manufacturer 1");
		mRepository.save(manufacturer);

		// Create and save Product
		Product clothing = new Product();
		clothing.setProductName("Clothing 1");
		clothing.setManufacturer(manufacturer);
		repository.save(clothing);

		// Check if the findByManufacturer works
		List<Product> products = repository.findByManufacturer(manufacturer);
		assertThat(products.get(0).getProductName()).isEqualTo("Clothing 1");
	}

}
