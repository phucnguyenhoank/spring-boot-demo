package com.hoangphuccode.spring_boot_demo.service.impl;

import com.hoangphuccode.spring_boot_demo.entity.ProductEntity;
import com.hoangphuccode.spring_boot_demo.repository.ProductRepository;
import com.hoangphuccode.spring_boot_demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<ProductEntity> getAllProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public List<ProductEntity> getProductsByName(String name) {
        return this.productRepository.findByName(name);
    }

    @Override
    public List<ProductEntity> getProductsByMissedName(String missedName){
        return this.productRepository.findByNameContaining(missedName);
    }

    @Override
    public List<ProductEntity> getProductsByPriceGreaterThan(BigDecimal price) {
        return this.productRepository.findByPriceGreaterT(price);
    }

    @Override
    public ProductEntity saveOrUpdateProduct(ProductEntity productEntity) {
        return this.productRepository.save(productEntity);
    }

    @Override
    public void deleteProductById(Long productId) {
        this.productRepository.deleteById(productId);
    }


}
