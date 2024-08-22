package ra.rekkei.restapi_basic.service;

import ra.rekkei.restapi_basic.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    Product getProductById(Integer proId);
    Product insertProduct(Product p);
    Product upateProduct(Integer proId, Product p);
    void deleteProduct(Integer proId);
    List<Product> getProductsByName(String proName);
}
