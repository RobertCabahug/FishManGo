package com.example.fishmango.sysarch.api.controller;

import com.example.fishmango.sysarch.api.model.Product;
import com.example.fishmango.sysarch.api.model.User;
import com.example.fishmango.sysarch.repository.ProductRepository;
import com.example.fishmango.sysarch.repository.UserRepository;
import com.example.fishmango.sysarch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    @ApiIgnore
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }



    @GetMapping("/user")
    public User getUser(@RequestParam String username){


        Optional<User> user = userService.getUser(username);
        if(user.isPresent()){
            ResponseEntity.status(200).body("error message");
        }
        return (User) user.orElse(null);

    }

    @PostMapping("/user/login")
    public ResponseEntity<String> loginUser(@RequestBody Map<String, String> loginData) {

        String username = loginData.get("username");
        String password = loginData.get("password");

        if (username == null || password == null) {
            return ResponseEntity.badRequest().body("Message: Either of the parameter is null");
        }

        User user = userService.getUserByUsername(username);

        if (user == null || !user.getPassword().equals(password)) {
            // Check against default user if not found in custom users
            if ("sysarch".equals(username) && "12345678".equals(password)) {
                return ResponseEntity.ok("Message: Log in successfully");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Message: Invalid Credentials");
            }
        }

        return ResponseEntity.ok("Message: Log in successfully");
    }
    @PostMapping("/user/Signup")
    public User SignUp(@RequestBody User user) {
        return userRepository.save(user);

    }

    @PostMapping("/user/Add")
    public Product addProduct(@RequestBody Product product){
        return productRepository.save(product);
    }


    //GET ALL PRODUCTS
    @GetMapping("/allProduct")
    public List<Product> getAllProduct  (){
        {

            return productRepository.findAll();
        }
    }
    //GET ALL PRODUCTS BY ID

    @GetMapping("getProductById/{prod_id}")
    public ResponseEntity<Product> getProductById(@PathVariable("prod_id") Integer prodId) {
        Product prod = userService.getProductById(prodId);
        if (prod != null) {
            return ResponseEntity.ok(prod); // Return 200 OK with the prod object
        } else {
            return ResponseEntity.notFound().build(); // Return 404 Not Found if prod is not found
        }
    }


}

