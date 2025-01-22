package com.abinash.Spring_Project.repository;

import com.abinash.Spring_Project.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        Product product1 = new Product(1, "Laptop", "High-performance laptop", "Dell", new BigDecimal("1500.00"),
                "Electronics", new Date(), true, 50, "laptop.png", "image/png", new byte[]{1, 2, 3});

        Product product2 = new Product(2, "Smartphone", "Latest smartphone model", "Samsung", new BigDecimal("800.00"),
                "Electronics", new Date(), true, 100, "smartphone.png", "image/png", new byte[]{4, 5, 6});

        Product product3 = new Product(3, "Headphones", "Noise-cancelling headphones", "Sony", new BigDecimal("200.00"),
                "Accessories", new Date(), true, 30, "headphones.png", "image/png", new byte[]{7, 8, 9});

        productRepository.saveAll(List.of(product1, product2, product3));
    }

    @Test
    void searchProducts() {
        List<Product> results = productRepository.searchProducts("laptop");
        assertEquals(1, results.size());
        assertEquals("Laptop", results.getFirst().getName());

        results = productRepository.searchProducts("electronics");
        assertEquals(4, results.size());

        results = productRepository.searchProducts("Sony");
        assertEquals(1, results.size());
        assertEquals("Headphones", results.getFirst().getName());

        results = productRepository.searchProducts("nonexistent");
        assertTrue(results.isEmpty());
    }
}