package com.pnc.apifest2019.rewardsplayinggameservice.service;

import com.pnc.apifest2019.rewardsplayinggameservice.model.dto.request.ProductDto;
import com.pnc.apifest2019.rewardsplayinggameservice.model.dto.response.ProductResponseDto;
import com.pnc.apifest2019.rewardsplayinggameservice.model.entity.Product;

import java.util.List;

//TODO: create new Dto's to capture full detail of product and implement service
public interface ProductService {

    ProductResponseDto createProduct(ProductDto productDto);

    Product validateAndGetProduct(String name);

    List<ProductDto> getProductById(long id);

    List<ProductDto> getProducts();
}
