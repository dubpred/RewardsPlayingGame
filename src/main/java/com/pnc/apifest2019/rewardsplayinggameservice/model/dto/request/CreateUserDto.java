package com.pnc.apifest2019.rewardsplayinggameservice.model.dto.request;

import java.util.List;

/**
 * use @NotNull or @NotBlank for strings, include a message
 */

public class CreateUserDto {

    private String name;

    private List<String> products;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> items) {
        this.products = items;
    }
}
