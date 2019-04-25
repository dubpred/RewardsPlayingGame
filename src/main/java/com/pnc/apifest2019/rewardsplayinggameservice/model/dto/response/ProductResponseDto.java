package com.pnc.apifest2019.rewardsplayinggameservice.model.dto.response;

import com.pnc.apifest2019.rewardsplayinggameservice.model.entity.Product;

//TODO: determine what all fields need to be returned
public class ProductResponseDto {

    private long id;

    private String name;

    private Product.ProductCatagory productCatagory;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product.ProductCatagory getProductCatagory() {
        return productCatagory;
    }

    public void setProductCatagory(Product.ProductCatagory productCatagory) {
        this.productCatagory = productCatagory;
    }
}
