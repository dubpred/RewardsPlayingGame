package com.pnc.apifest2019.rewardsplayinggameservice.controller;

import com.pnc.apifest2019.rewardsplayinggameservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

//TODO: Review proper use of Response Entity
@RestController
@RequestMapping(value = "api/product", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(final ProductService productService){
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody @Valid ProductDto productDto){
        return ResponseEntity.ok(productService.createProduct(productDto));
    }

    //TODO: add get methods
}