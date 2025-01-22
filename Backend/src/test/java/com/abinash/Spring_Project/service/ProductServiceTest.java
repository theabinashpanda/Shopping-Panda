package com.abinash.Spring_Project.service;

import com.abinash.Spring_Project.model.Product;
import com.abinash.Spring_Project.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

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

        when(productRepository.findAll()).thenReturn(products);

        List<Product> result = productService.getAllProducts();

        assertEquals(2, result.size());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void getProductById() {
        Product product = new Product(1, "Product1", "Description1", "Brand1", new BigDecimal("100.00"),
                "Category1", new Date(), true, 10, "image1.png", "image/png", new byte[]{1, 2, 3});

        when(productRepository.findById(1)).thenReturn(Optional.of(product));

        Product result = productService.getProductById(1);

        assertNotNull(result);
        assertEquals("Product1", result.getName());
        verify(productRepository, times(1)).findById(1);
    }

    @Test
    void addProduct() throws Exception {
        Product product = new Product();
        MultipartFile imageFile = mock(MultipartFile.class);

        when(imageFile.getOriginalFilename()).thenReturn("image.png");
        when(imageFile.getContentType()).thenReturn("image/png");
        when(imageFile.getBytes()).thenReturn(new byte[]{1, 2, 3});
        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.addProduct(product, imageFile);

        assertNotNull(result);
        assertEquals("image.png", result.getImageName());
        verify(productRepository, times(1)).save(product);
    }

    @Test
    void updateProduct() throws Exception {
        Product product = new Product();
        MultipartFile imageFile = mock(MultipartFile.class);

        when(imageFile.getOriginalFilename()).thenReturn("updated_image.png");
        when(imageFile.getContentType()).thenReturn("image/png");
        when(imageFile.getBytes()).thenReturn(new byte[]{4, 5, 6});
        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.updateProduct(1, product, imageFile);

        assertNotNull(result);
        assertEquals("updated_image.png", result.getImageName());
        verify(productRepository, times(1)).save(product);
    }

    @Test
    void deleteProduct() {
        doNothing().when(productRepository).deleteById(1);

        productService.deleteProduct(1);

        verify(productRepository, times(1)).deleteById(1);
    }

    @Test
    void searchProducts() {
        List<Product> products = Arrays.asList(
                new Product(1, "Product1", "Description1", "Brand1", new BigDecimal("100.00"),
                        "Category1", new Date(), true, 10, "image1.png", "image/png", new byte[]{1, 2, 3})
        );

        when(productRepository.searchProducts("Product1")).thenReturn(products);

        List<Product> result = productService.searchProducts("Product1");

        assertEquals(1, result.size());
        verify(productRepository, times(1)).searchProducts("Product1");
    }
}
