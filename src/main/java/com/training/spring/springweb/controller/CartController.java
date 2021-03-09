package com.training.spring.springweb.controller;

import com.training.spring.springweb.entity.Cart;
import com.training.spring.springweb.service.impl.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping
    public List<Cart> getCartByCustomer(@RequestParam String customerName){
        return cartService.getCartByCustomerName(customerName);
    }

    @PostMapping
    public Cart addToCart(@RequestBody Cart cart){
        return cartService.addToCart(cart);
    }

    @PutMapping
    public Cart updateCart(@RequestBody Cart cart){
        return cartService.updateCart(cart);
    }

    @DeleteMapping
    public String delete(@RequestParam String itemName, @RequestParam String customerName){
        cartService.deleteCart(itemName,customerName);
        return itemName + " Has been deleted";
    }
}
