package ra.rekkei.restapi_basic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.rekkei.restapi_basic.model.entity.Product;
import ra.rekkei.restapi_basic.repository.ProductRepository;
import ra.rekkei.restapi_basic.service.ProductService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer proId) {
        return productRepository.findById(proId).orElseThrow(()->new NoSuchElementException("Khong ton tai prduct co ma: "+proId));
    }

    @Override
    public Product insertProduct(Product p) {
        return productRepository.save(p);
    }

    @Override
    public Product upateProduct(Integer proId, Product p) {
        productRepository.findById(proId).orElseThrow(()->new NoSuchElementException("Khong ton tai prduct co ma: "+proId));
        p.setProId(proId);
        return productRepository.save(p);
    }

    @Override
    public void deleteProduct(Integer proId) {
        productRepository.deleteById(proId);
    }

    @Override
    public List<Product> getProductsByName(String proName) {
        return productRepository.findProductsByProNameContains(proName);
    }
}
