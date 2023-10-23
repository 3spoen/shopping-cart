package com.example.ecommerce.shoppingcart;


import com.example.ecommerce.shoppingcart.model.CartItem;
import com.example.ecommerce.shoppingcart.model.Product;
import com.example.ecommerce.shoppingcart.repository.CartItemRepository;
import com.example.ecommerce.shoppingcart.repository.ProductRepository;
import com.example.ecommerce.shoppingcart.service.CartService;
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

class CartServiceTest {

    @InjectMocks
    private CartService cartService;

    @Mock
    private CartItemRepository cartItemRepository;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAddToCart() {
        Product product = new Product();
        product.setId(1L);

        CartItem expectedCartItem = new CartItem();
        expectedCartItem.setProduct(product);
        expectedCartItem.setQuantity(2);

        given(productRepository.findById(1L)).willReturn(Optional.of(product));
        given(cartItemRepository.save(any(CartItem.class))).willReturn(expectedCartItem);

        CartItem cartItem = cartService.addToCart(1L, 2);

        assertNotNull(cartItem);
        assertEquals(2, cartItem.getQuantity());
    }


    @Test
    void testGetCartItems() {
        List<CartItem> cartItems = Arrays.asList(new CartItem(), new CartItem());
        given(cartItemRepository.findAll()).willReturn(cartItems);

        List<CartItem> fetchedCartItems = cartService.getCartItems();

        assertEquals(cartItems.size(), fetchedCartItems.size());
    }

}
