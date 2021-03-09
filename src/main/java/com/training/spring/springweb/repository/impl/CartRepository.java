package com.training.spring.springweb.repository.impl;


import com.training.spring.springweb.entity.Cart;
import com.training.spring.springweb.repository.ICartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CartRepository implements ICartRepository {
    @Autowired
    private List<Cart> carts;


    @Override
    public List<Cart> getCarts() {
        return carts;
    }

    @Override
    public String removeCarts(Cart cart) {
        carts.remove(cart);
        return  cart.getCustomerName() + " Cart has been removed";
    }

    @Override
    public String addCart(Cart cart) {
        carts.add(cart);
        return cart.getItemName() + "Has been added";
    }
}
