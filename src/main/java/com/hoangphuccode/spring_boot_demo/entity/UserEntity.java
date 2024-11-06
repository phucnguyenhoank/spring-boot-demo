package com.hoangphuccode.spring_boot_demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "User")
@DynamicInsert
@DynamicUpdate
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "NVARCHAR(100)", nullable = false)
    private String name;

    @Column(columnDefinition = "NVARCHAR(100)")
    private String address;

    @Column(precision = 4, scale = 2)
    private BigDecimal grade;

}
