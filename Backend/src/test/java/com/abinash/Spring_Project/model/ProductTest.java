package com.abinash.Spring_Project.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void testGetAndSetId() {
        Product product = new Product();
        product.setId(1);
        assertEquals(1, product.getId());
    }

    @Test
    void testGetAndSetName() {
        Product product = new Product();
        product.setName("Laptop");
        assertEquals("Laptop", product.getName());
    }

    @Test
    void testGetAndSetDescription() {
        Product product = new Product();
        product.setDescription("High-performance laptop");
        assertEquals("High-performance laptop", product.getDescription());
    }

    @Test
    void testGetAndSetBrand() {
        Product product = new Product();
        product.setBrand("Dell");
        assertEquals("Dell", product.getBrand());
    }

    @Test
    void testGetAndSetPrice() {
        Product product = new Product();
        BigDecimal price = new BigDecimal("999.99");
        product.setPrice(price);
        assertEquals(price, product.getPrice());
    }

    @Test
    void testGetAndSetCategory() {
        Product product = new Product();
        product.setCategory("Electronics");
        assertEquals("Electronics", product.getCategory());
    }

    @Test
    void testGetAndSetReleaseDate() {
        Product product = new Product();
        Date releaseDate = new Date();
        product.setReleaseDate(releaseDate);
        assertEquals(releaseDate, product.getReleaseDate());
    }

    @Test
    void testIsAndSetProductAvailable() {
        Product product = new Product();
        product.setProductAvailable(true);
        assertTrue(product.isProductAvailable());

        product.setProductAvailable(false);
        assertFalse(product.isProductAvailable());
    }

    @Test
    void testGetAndSetStockQuantity() {
        Product product = new Product();
        product.setStockQuantity(50);
        assertEquals(50, product.getStockQuantity());
    }

    @Test
    void testGetAndSetImageName() {
        Product product = new Product();
        product.setImageName("image.png");
        assertEquals("image.png", product.getImageName());
    }

    @Test
    void testGetAndSetImageType() {
        Product product = new Product();
        product.setImageType("image/png");
        assertEquals("image/png", product.getImageType());
    }

    @Test
    void testGetAndSetImageDate() {
        Product product = new Product();
        byte[] imageData = {1, 2, 3, 4};
        product.setimageDate(imageData);
        assertArrayEquals(imageData, product.getimageDate());
    }

    @Test
    void testAllArgsConstructor() {
        BigDecimal price = new BigDecimal("999.99");
        Date releaseDate = new Date();
        byte[] imageData = {1, 2, 3, 4};

        Product product = new Product(1, "Laptop", "High-performance laptop", "Dell", price,
                "Electronics", releaseDate, true, 50, "image.png", "image/png", imageData);

        assertEquals(1, product.getId());
        assertEquals("Laptop", product.getName());
        assertEquals("High-performance laptop", product.getDescription());
        assertEquals("Dell", product.getBrand());
        assertEquals(price, product.getPrice());
        assertEquals("Electronics", product.getCategory());
        assertEquals(releaseDate, product.getReleaseDate());
        assertTrue(product.isProductAvailable());
        assertEquals(50, product.getStockQuantity());
        assertEquals("image.png", product.getImageName());
        assertEquals("image/png", product.getImageType());
        assertArrayEquals(imageData, product.getimageDate());
    }
}
