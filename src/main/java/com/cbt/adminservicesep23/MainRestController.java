package com.cbt.adminservicesep23;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class MainRestController {

    private final  ProductRepository productRepository;

    private final  UserdetailService userdetailService;

    private final WebClient.Builder webclient;

    @PostMapping("save/product") //CREATE
    public ResponseEntity<String> saveProduct(@RequestBody Product product)
    {
        productRepository.save(product);
        return new ResponseEntity<>("New Product Added", HttpStatus.OK);
    }

    @PostMapping("update/product/{hscode}") //UPDATE
    public Product  updateProduct(@PathVariable("hscode") String hscode, @RequestBody Product product)
    {
        productRepository.updateNameAndUnitByHscode(product.getName(),product.getUnit(),hscode);
        return product;
    }

    @DeleteMapping("delete/product/{hscode}") //DELETE
    public ResponseEntity<String> deleteProduct(@PathVariable("hscode") String hscode)
    {
        productRepository.deleteById(hscode);
        return new ResponseEntity<>("Product Deleted", HttpStatus.OK);
    }

    @GetMapping("get/all/product") //READ ALL
    public List<Product> getAllProduct()
    {
        return productRepository.findAll();
    }

    @GetMapping("get/product/{hscode}") // READ
    public Product getProduct(@PathVariable("hscode") String hscode)
    {
        return productRepository.findById(hscode).get();
    }

    @GetMapping("get/all/users/type/{type}")
    public List<String> getAllUsersByType(@PathVariable("type") String type)
    {
        return this.userdetailService.getAllUsernamesByType(type);
    }

    @GetMapping("revert/auth/1")
    public ResponseEntity<Mono<String>> revertToAuthService()
    {
        Mono<String> authResp =  webclient.build().get().uri("http://localhost:8072/auth-service/api/v1/end/response").retrieve().bodyToMono(String.class);
        return ResponseEntity.ok(authResp);
    }


}
