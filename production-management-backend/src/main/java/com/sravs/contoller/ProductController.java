package com.sravs.contoller;

import com.sravs.entity.Product;
import com.sravs.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("product")
public class ProductController {
    @Autowired
    ProductServiceImpl productService;

    @PostMapping("add")
    public String saveProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        return "Product has been added";
    }

    @GetMapping("getAll")
    public List<Product> getAllProduct() {
        return productService.getAllProducts();
    }

    @GetMapping("getProduct/{id}")
    public Product getById(@PathVariable("id") Integer id) {
        return productService.getProductById(id);
    }

    @GetMapping("deleteProduct/{id}")
    public void deleteproduct(@PathVariable("id") Integer id) {
        productService.deleteProductById(id);
    }

    @PutMapping("update/{id}")
    public Product updateStudent(@RequestBody Product product, @PathVariable("id") Integer id) {
        return productService.editProduct(product, id);
    }
}
