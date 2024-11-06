package com.hoangphuccode.spring_boot_demo.service;

import com.hoangphuccode.spring_boot_demo.entity.ProductEntity;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public interface ProductService {
    List<ProductEntity> getAllProducts();
    List<ProductEntity> getProductsByName(String name);
    List<ProductEntity> getProductsByMissedName(String missedName);
    List<ProductEntity> getProductsByPriceGreaterThan(BigDecimal price);
    ProductEntity saveOrUpdateProduct(ProductEntity productEntity);
    void deleteProduct(Long productId);
}
