package com.abinash.Spring_Project.controller;

import com.abinash.Spring_Project.model.Product;
import com.abinash.Spring_Project.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductControllerTest {

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllProducts() {
        List<Product> products = Arrays.asList(
                new Product(1, "Product1", "Description1", "Brand1", new BigDecimal("100.00"),
                        "Category1", new Date(), true, 10, "image1.png", "image/png", new byte[]{1, 2, 3}),
                new Product(2, "Product2", "Description2", "Brand2", new BigDecimal("200.00"),
                        "Category2", new Date(), true, 20, "image2.png", "image/png", new byte[]{4, 5, 6})
        );

        when(productService.getAllProducts()).thenReturn(products);

        ResponseEntity<List<Product>> response = productController.getAllProducts();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
        verify(productService, times(1)).getAllProducts();
    }

    @Test
    void getProduct() {
        Product product = new Product(1, "Product1", "Description1", "Brand1", new BigDecimal("100.00"),
                "Category1", new Date(), true, 10, "image1.png", "image/png", new byte[]{1, 2, 3});

        when(productService.getProductById(1)).thenReturn(product);

        ResponseEntity<Product> response = productController.getProduct(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(product, response.getBody());
        verify(productService, times(1)).getProductById(1);
    }

    @Test
    void addProduct() throws IOException {
        Product product = new Product();
        MultipartFile imageFile = mock(MultipartFile.class);

        when(productService.addProduct(product, imageFile)).thenReturn(product);

        ResponseEntity<?> response = productController.addProduct(product, imageFile);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(product, response.getBody());
        verify(productService, times(1)).addProduct(product, imageFile);
    }

    @Test
    void getImageByProductId() {
        Product product = new Product(1, "Product1", "Description1", "Brand1", new BigDecimal("100.00"),
                "Category1", new Date(), true, 10, "image1.png", "image/png", new byte[]{1, 2, 3});

        when(productService.getProductById(1)).thenReturn(product);

        ResponseEntity<byte[]> response = productController.getImageByProductId(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertArrayEquals(product.getimageDate(), response.getBody());
        verify(productService, times(1)).getProductById(1);
    }

    @Test
    void updateProduct() throws IOException {
        Product product = new Product();
        MultipartFile imageFile = mock(MultipartFile.class);

        when(productService.updateProduct(1, product, imageFile)).thenReturn(product);

        ResponseEntity<String> response = productController.updateProduct(1, product, imageFile);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Updated", response.getBody());
        verify(productService, times(1)).updateProduct(1, product, imageFile);
    }

    @Test
    void deleteProduct() {
        Product product = new Product();

        when(productService.getProductById(1)).thenReturn(product);
        doNothing().when(productService).deleteProduct(1);

        ResponseEntity<String> response = productController.deleteProduct(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Deleted", response.getBody());
        verify(productService, times(1)).getProductById(1);
        verify(productService, times(1)).deleteProduct(1);
    }

    @Test
    void searchProducts() {
        List<Product> products = Arrays.asList(
                new Product(1, "Product1", "Description1", "Brand1", new BigDecimal("100.00"),
                        "Category1", new Date(), true, 10, "image1.png", "image/png", new byte[]{1, 2, 3})
        );

        when(productService.searchProducts("Product1")).thenReturn(products);

        ResponseEntity<List<Product>> response = productController.searchProducts("Product1");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        verify(productService, times(1)).searchProducts("Product1");
    }
}
