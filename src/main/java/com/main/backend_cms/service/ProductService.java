package com.main.backend_cms.service;

import com.main.backend_cms.model.Product;
import com.main.backend_cms.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product createProduct(Product product) throws Exception {
        if( product.getAmount() >= 0 &&
            product.getPrice() >= 0 &&
            !product.getName().isEmpty() &&
            product.getCategory().length > 0 &&
            !product.getPicture().isEmpty() &&
            productRepository.findByName(product.getName()).isEmpty()){
            return productRepository.save(product);
        }
        throw new Exception("invalid data");
    }

    public Product deleteProductByName(String name) throws Exception{ //hard-delete
        if(productRepository.findByName(name).isPresent()){
            return productRepository.deleteByName(name);
        }
        throw new Exception("invalid data");
    }

    public Product updateProduct(Product product) throws Exception{
        //TODO: implement update Product
        return null;
    }
}
