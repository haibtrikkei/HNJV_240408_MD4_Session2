package ra.rekkei.restapi_basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.rekkei.restapi_basic.model.dto.DataResponse;
import ra.rekkei.restapi_basic.model.entity.Product;
import ra.rekkei.restapi_basic.service.ProductService;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<DataResponse> getAllProducts(){
        return new ResponseEntity<>(new DataResponse(productService.getProducts(), HttpStatus.OK),HttpStatus.OK);
    }

    @GetMapping("/{proId}")
    public ResponseEntity<DataResponse> getById(@PathVariable("proId")Integer proId){
        return new ResponseEntity<>(new DataResponse(productService.getProductById(proId),HttpStatus.OK),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DataResponse> insertProductService(@RequestBody Product product){
        return new ResponseEntity<>(new DataResponse(productService.insertProduct(product),HttpStatus.CREATED),HttpStatus.CREATED);
    }

    @PutMapping("/{proId}")
    public ResponseEntity<DataResponse> upateProduct(@PathVariable("proId")Integer proId, @RequestBody Product product){
        return new ResponseEntity<>(new DataResponse(productService.upateProduct(proId,product),HttpStatus.OK),HttpStatus.OK);
    }

    @DeleteMapping("/{proId}")
    public ResponseEntity<DataResponse> deleteProduct(@PathVariable("proId")Integer proId){
        productService.deleteProduct(proId);
        return new ResponseEntity<>(new DataResponse("Đã xóa thành công category có mã: "+proId,HttpStatus.NO_CONTENT),HttpStatus.OK);
    }

    @GetMapping("/searchByName/{proName}")
    public ResponseEntity<DataResponse> searchProductByName(@PathVariable("proName")String proName){
        return  new ResponseEntity<>(new DataResponse(productService.getProductsByName(proName),HttpStatus.OK),HttpStatus.OK);
    }
}
