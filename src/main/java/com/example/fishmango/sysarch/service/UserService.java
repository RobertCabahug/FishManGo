package com.example.fishmango.sysarch.service;

import com.example.fishmango.sysarch.api.model.Product;
import com.example.fishmango.sysarch.api.model.User;
import com.example.fishmango.sysarch.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private List<User> userList;


    private final ProductRepository productRepository;

    public UserService(ProductRepository productRepository) {

        userList = new ArrayList<>();


        User user1 = new User("Rob", 20, "Rob@gmail.com", "Rob", "password1");
        User user2 = new User("Art", 21, "Art@gmail.com", "Art", "password2");
        User user3 = new User( "Joem", 22, "Joem@gmail.com", "Joem", "password3");
        User user4 = new User("Kevin", 23, "Kevin@gmail.com", "Kevin", "password4");
        User user5 = new User( "Kurtz", 24, "Kurtz@gmail.com", "Kurtz", "password5");
        User defaultUser = new User( "System Architect", 0, "", "sysarch", "12345678");

        userList.addAll(Arrays.asList(user1, user2, user3, user4, user5, defaultUser));

    this.productRepository = productRepository;

    }

    public User getUserByUsername(String username) {
        return userList.stream()
                .filter(user -> username.equals(user.getUsername()))
                .findFirst()
                .orElse(null);
    }

    //GET
    public Product getProductById(Integer prod_id) {
        try{
            Product product = productRepository.findById(prod_id).orElse(null);
            System.out.println(product);
            return product;
        }catch(Exception e){
            System.out.println(e);
        return  null;
        }

    }

    public Optional<User> getUser(String username) {
        Optional optional = Optional.empty();
        for (User user : userList) {
            if (username == user.getUsername()) {
                optional = Optional.of(user);
                return optional;
            }
        }
        return optional;
    }


}