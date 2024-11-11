package com.hoangphuccode.spring_boot_demo;

import com.hoangphuccode.spring_boot_demo.entity.CustomerEntity;
import com.hoangphuccode.spring_boot_demo.entity.OrderEntity;
import com.hoangphuccode.spring_boot_demo.repository.CustomerRepository;
import com.hoangphuccode.spring_boot_demo.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CustomerOrderCascadeTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void testCascadeSaveAndDelete() {

        // customerRepository.deleteById(4L);


        // Step 4: Create Customer and Orders
        CustomerEntity customer = new CustomerEntity();
        customer.setName("Murad");
        customer.setId(5L);

        OrderEntity order1 = new OrderEntity();
        order1.setId(11L);
        order1.setProduct("Iphonee");
        order1.setCustomerEntity(customer);

        OrderEntity order2 = new OrderEntity();
        order2.setId(12L);
        order2.setProduct("Ipadd");
        order2.setCustomerEntity(customer);

        // Associate orders with customer
        customer.setOrderEntities(Arrays.asList(order1, order2));

        // Step 5: Save Customer (Cascades to Orders)
        customerRepository.save(customer);


        /*
        // Step 6: Verify that both Customer and Orders were saved
        CustomerEntity savedCustomer = customerRepository.findById(customer.getId()).orElse(null);
        assertThat(savedCustomer).isNotNull();
        assertThat(savedCustomer.getOrderEntities()).hasSize(2);

        List<OrderEntity> savedOrders = orderRepository.findAll();
        assertThat(savedOrders).hasSize(2);
        assertThat(savedOrders.get(0).getCustomerEntity().getName()).isEqualTo("Alice");

        // Step 7: Delete Customer (Cascades to Orders)
        customerRepository.delete(savedCustomer);


         */

    }
}
