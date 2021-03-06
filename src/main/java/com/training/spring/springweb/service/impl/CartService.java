package com.training.spring.springweb.service.impl;

import com.training.spring.springweb.entity.Cart;
import com.training.spring.springweb.repository.impl.CartRepository;
import com.training.spring.springweb.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartService implements ICartService {

    @Autowired
    private CartRepository cartRepository;


    @Override
    public List<Cart> getCartByCustomerName(String customerName) {
        return cartRepository.getCarts().stream().filter(cart -> cart.getCustomerName().equals(customerName))
                .collect(Collectors.toList());
    }

    @Override
    public Cart addToCart(Cart cart) {
        cartRepository.addCart(cart);
        return cart;
    }

    @Override
    public Cart updateCart(Cart cart) {
        for(Cart currentCart: cartRepository.getCarts()){
            if(currentCart.getCustomerName().equals(cart.getCustomerName()) && currentCart.getItemName().equals(cart.getItemName())){
                currentCart.setQuantity(cart.getQuantity());
                return currentCart;
            }
        }
        return null;
    }

    @Override
    public String deleteCart(String itemName, String customerName) {
        Cart existingCart = null;
        for(Cart currentCart: cartRepository.getCarts()){
            if(currentCart.getCustomerName().equals(customerName) && currentCart.getItemName().equals(itemName)){
                existingCart = currentCart;
                break;
            }
        }
        return cartRepository.removeCarts(existingCart);
    }
}
