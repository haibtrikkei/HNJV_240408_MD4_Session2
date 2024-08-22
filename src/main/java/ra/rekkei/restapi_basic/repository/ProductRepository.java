package ra.rekkei.restapi_basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.rekkei.restapi_basic.model.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findProductsByProNameContains(String proName);
}
