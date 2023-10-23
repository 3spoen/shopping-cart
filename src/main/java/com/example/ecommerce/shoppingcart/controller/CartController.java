package com.example.ecommerce.shoppingcart.controller;


import com.example.ecommerce.shoppingcart.model.CartItem;
import com.example.ecommerce.shoppingcart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add/{productId}")
    public CartItem addToCart(@PathVariable Long productId, @RequestParam int quantity) {
        return cartService.addToCart(productId, quantity);
    }

    @DeleteMapping("/remove/{cartItemId}")
    public void removeFromCart(@PathVariable Long cartItemId) {
        cartService.removeFromCart(cartItemId);
    }

    @PutMapping("/update/{cartItemId}")
    public CartItem updateQuantity(@PathVariable Long cartItemId, @RequestParam int quantity) {
        return cartService.updateQuantity(cartItemId, quantity);
    }

    @GetMapping
    public List<CartItem> getCartItems() {
        return cartService.getCartItems();
    }

    @GetMapping("/total")
    public BigDecimal getCartTotal() {
        return cartService.getCartTotal();
    }
}
