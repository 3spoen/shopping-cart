package com.example.ecommerce.shoppingcart;


import com.example.ecommerce.shoppingcart.model.Product;
import com.example.ecommerce.shoppingcart.repository.ProductRepository;
import com.example.ecommerce.shoppingcart.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetProductById() {
        Product product = new Product();
        product.setId(1L);

        given(productRepository.findById(1L)).willReturn(Optional.of(product));

        Product foundProduct = productService.getProductById(1L).orElse(null);

        assertNotNull(foundProduct);
        assertEquals(product.getId(), foundProduct.getId());
    }

    @Test
    void testGetAllProducts() {
        List<Product> products = Arrays.asList(new Product(), new Product());
        given(productRepository.findAll()).willReturn(products);

        List<Product> fetchedProducts = productService.getAllProducts();

        assertEquals(products.size(), fetchedProducts.size());
    }
}
