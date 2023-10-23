package com.example.ecommerce.shoppingcart.repository;

import com.example.ecommerce.shoppingcart.model.CartItem;
import com.example.ecommerce.shoppingcart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
