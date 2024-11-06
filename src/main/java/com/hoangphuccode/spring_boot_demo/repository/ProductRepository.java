package com.hoangphuccode.spring_boot_demo.repository;

import com.hoangphuccode.spring_boot_demo.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findByName(String name);
    List<ProductEntity> findByNameContaining(String keyword);

    @Query(value = "SELECT p FROM Product p WHERE p.price > :price")
    List<ProductEntity> findByPriceGreaterT(@Param("price") BigDecimal price);

    void deleteById(Long id);

}
