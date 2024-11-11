package com.hoangphuccode.spring_boot_demo.controller;

import com.hoangphuccode.spring_boot_demo.entity.ProductEntity;
import com.hoangphuccode.spring_boot_demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

// @RestController
@Controller
@RequestMapping("/v1")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String getAllProducts(Model model) {
        List<ProductEntity> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "product/product-list";  // Tên của template Thymeleaf
    }

    @GetMapping("/products/search")
    public String getProductsByName(Model model, @RequestParam("name") String name){
        List<ProductEntity> productEntities = this.productService.getProductsByName(name);
        model.addAttribute("products", productEntities);
        return "product/product-search";
    }

    @GetMapping("/products/search/missed")
    public String getProductsByMissedName(Model model, @RequestParam("name") String missedName){
        System.out.println(missedName);
        List<ProductEntity> productEntities =  this.productService.getProductsByMissedName(missedName);
        model.addAttribute("products", productEntities);
        model.addAttribute("missedName", missedName);
        return "product/product-search-missed";
    }

    @GetMapping("/products/search/price")
    public String getProductsByPriceGreaterThan(Model model, @RequestParam("price") BigDecimal price){
        List<ProductEntity> productEntities = this.productService.getProductsByPriceGreaterThan(price);
        model.addAttribute("products", productEntities);
        return "product/product-search-price";
    }

    @GetMapping("/products/create")
    public String showProductForm(Model model) {
        model.addAttribute("product", new ProductEntity());
        return "product/product-form";
    }

    @PostMapping("/products/create")
    public String showProductForm(@ModelAttribute("product") ProductEntity productEntity) {
        this.productService.saveOrUpdateProduct(productEntity);
        return "product/product-success";
    }

    @GetMapping("/products/delete")
    public String showFormDeleteProduct(Model model) {
        model.addAttribute("product", new ProductEntity());
        return "product/product-delete";
    }

    @DeleteMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        this.productService.deleteProductById(id);
        return "redirect:/v1/products";
    }

    @GetMapping("/products/update")
    public String showFormUpdateProduct(Model model) {
        model.addAttribute("product", new ProductEntity());
        return "product/product-update";
    }

    @PutMapping("/products/update/{id}")
    public String updateProduct(@PathVariable("id") Long id, @ModelAttribute("product") ProductEntity product) {
        product.setId(id);
        productService.saveOrUpdateProduct(product);
        return "redirect:/v1/products";
    }



    /*
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
    */



}
