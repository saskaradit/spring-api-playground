package com.training.spring.springweb.service;

import com.training.spring.springweb.entity.Cart;

import java.util.List;

public interface ICartService {
    List<Cart> getCartByCustomerName(String customerName);
    Cart addToCart(Cart cart);
    Cart updateCart(Cart cart);
    String deleteCart(String itemName, String customerName);
}
