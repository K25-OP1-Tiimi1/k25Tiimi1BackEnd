package k25tiimi1backend.k25tiimi1backend.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findByProductType(ProductType productType);

}
