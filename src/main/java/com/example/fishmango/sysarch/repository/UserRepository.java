package com.example.fishmango.sysarch.repository;

import com.example.fishmango.sysarch.api.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface UserRepository extends MongoRepository<User, String> {
}
  