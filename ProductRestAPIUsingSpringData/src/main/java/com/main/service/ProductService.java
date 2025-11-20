package com.main.service;

import com.main.bean.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.main.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service

public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public String storeProduct(Product product) {
//        productRepository.save(product);
//        return "Product stored successfully";

       Optional<Product> result =  productRepository.findById(product.getPid());
       if(result.isPresent()) {
           return "Product id must be unique";
       } else {
           return "Record inserted successfully";
       }
    }

    public String updateProduct(Product product) {
//        productRepository.save(product);
//        return "Product stored successfully";

        Optional<Product> result =  productRepository.findById(product.getPid());
        if(result.isPresent()) {

            Product productFromDb = result.get();
            productFromDb.setPname(product.getPname());
            productFromDb.setPrice(product.getPrice());
            productFromDb.setPname(product.getPname());
            productRepository.saveAndFlush(productFromDb);
            return "Product updated successfully";
        } else {
            return "Product not updated";
        }
    }

    public String deleteProduct(int pid) {
//        productRepository.save(product);
//        return "Product stored successfully";

        Optional<Product> result =  productRepository.findById(pid);
        if(result.isPresent()) {

           productRepository.deleteById(pid);
            return "Product deleted successfully";
        } else {
            return "Product not present";
        }
    }

    public String findProductById(int pid){
        Optional<Product> result= productRepository.findById(pid);
        if(result.isPresent()){
            Product productFromDb =  result.get();
            return productFromDb.toString();
        }else {
            return "Product not present";
        }
    }

}
