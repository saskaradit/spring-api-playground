package com.training.spring.springweb.repository;

import com.training.spring.springweb.entity.Cart;

import java.util.List;

public interface ICartRepository {
    List<Cart> getCarts();
    String removeCarts(Cart cart);
    String addCart(Cart cart);
}
