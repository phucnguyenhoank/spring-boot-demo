package com.hoangphuccode.spring_boot_demo.controller;

import com.hoangphuccode.spring_boot_demo.entity.ProductEntity;
import com.hoangphuccode.spring_boot_demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("v1/api/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<ProductEntity> getAddProducts(){
        return this.productService.getAllProducts();
    }

    @GetMapping("/products/search")
    public List<ProductEntity> getProductsByName(@RequestParam String name){
        return this.productService.getProductsByName(name);
    }

    @GetMapping("/products/search/missed")
    public List<ProductEntity> getProductsByMissedName(@RequestParam String missedName){
        return this.productService.getProductsByMissedName(missedName);
    }

    @GetMapping("/products/search/price")
    public List<ProductEntity> getProductsByPriceGreaterThan(@RequestParam BigDecimal price){
        return this.productService.getProductsByPriceGreaterThan(price);
    }

    @PostMapping("/products")
    public ProductEntity saveOrUpdateProduct(@RequestBody ProductEntity productEntity){
        return this.productService.saveOrUpdateProduct(productEntity);
    }

    @PutMapping("/products/{id}")
    public ProductEntity updateProduct(@PathVariable Long id, @RequestBody ProductEntity productEntity){
        productEntity.setId(id);
        return this.productService.saveOrUpdateProduct(productEntity);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

}
