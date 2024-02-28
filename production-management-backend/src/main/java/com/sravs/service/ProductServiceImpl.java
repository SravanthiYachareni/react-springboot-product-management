package com.sravs.service;

import com.sravs.entity.Product;
import com.sravs.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepo productRepo;
    @Override
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepo.findById(id).get();
    }

    @Override
    public String deleteProductById(Integer id) {
      Product product=productRepo.findById(id).get();
      if(product != null) {
          productRepo.delete(product);
          return "Product Deleted Successfully";
      }
        return "Something went wrong";

    }

    @Override
    public Product editProduct(Product product,Integer id) {
Product oldProduct=productRepo.findById(id).get();
   oldProduct.setProductName(product.getProductName());
   oldProduct.setDescription(product.getDescription());
   oldProduct.setPrice(product.getPrice());
   oldProduct.setStatus(product.getStatus());
        return productRepo.save(oldProduct);
    }


}
