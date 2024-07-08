package com.example.fishmango.sysarch.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.fishmango.sysarch.api.model.Product;
import com.google.common.base.Optional;


public interface ProductRepository extends MongoRepository<Product, Integer> {

    Optional<Product> findById(int prod_id);
}
