package com.sravs.service;

import com.sravs.entity.Product;

import java.util.List;

public interface ProductService {
    public Product saveProduct(Product product);

    public List<Product> getAllProducts();

    public Product getProductById(Integer id);

    public String deleteProductById(Integer id);

    public Product editProduct(Product product, Integer id);
}
