package com.pnc.apifest2019.rewardsplayinggameservice.service.impl;

import com.pnc.apifest2019.rewardsplayinggameservice.intregration.jpa.ProductRepository;
import com.pnc.apifest2019.rewardsplayinggameservice.model.dto.request.ProductDto;
import com.pnc.apifest2019.rewardsplayinggameservice.model.dto.response.ProductResponseDto;
import com.pnc.apifest2019.rewardsplayinggameservice.model.entity.EventDetail;
import com.pnc.apifest2019.rewardsplayinggameservice.model.entity.Product;
import com.pnc.apifest2019.rewardsplayinggameservice.model.entity.TransactionEarnRate;
import com.pnc.apifest2019.rewardsplayinggameservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(final ProductRepository productRepository){ this.productRepository = productRepository; }

    @Override
    @Transactional
    //TODO: add checks for valid ED's and TER's
    public ProductResponseDto createProduct(ProductDto productDto) {

        ProductResponseDto productResponseDto = new ProductResponseDto();

        //create new product if the product name does not already exist
        if (isValidProduct(productDto.getName())) {
            //Create product and save basic information
            Product product = new Product();
            product.init(productDto);

            //add transaction earn rates to the product
            List<TransactionEarnRate> transactionEarnRates = productDto.getTransactionEarnRates()
                    .stream()
                    .map(ter -> {
                                //TODO: add check to make sure a TER isnt added for a tier that the Product does not have
                                TransactionEarnRate transactionEarnRate = new TransactionEarnRate();
                                transactionEarnRate.init(ter);
                                transactionEarnRate.setProduct(product);
                                return transactionEarnRate;
                            }
                    ).collect(Collectors.toList());
            product.setTransactionEarnRates(transactionEarnRates);

            //add event details to the product
            List<EventDetail> eventDetails = productDto.getEventDetails().
                    stream()
                    .map(ed -> {
                        EventDetail eventDetail = new EventDetail();
                        eventDetail.init(ed);
                        eventDetail.setProduct(product);
                        return eventDetail;
                    }).collect(Collectors.toList());
            product.setEventDetails(eventDetails);

            //save final product
            //here, we have a new object (transient) so we need to explicitly call the save method
            Product savedProduct = productRepository.saveAndFlush(product);

            productResponseDto.setId(savedProduct.getId());
            productResponseDto.setName(savedProduct.getName());
            productResponseDto.setProductCatagory(savedProduct.getProductCatagory());
        }else{
            //TODO: provide better error message, move error message to validate method
            //return error if product name is already used
            throw new RuntimeException();
        }
        //return info about saved product
        return productResponseDto;
    }

    //TODO: implement
    @Override
    public List<ProductDto> getProductById(long id) {
        return null;
    }

    //TODO: implement
    @Override
    public List<ProductDto> getProducts() {
        return null;
    }

    //TODO: change to validate method that throws exception
    private boolean isValidProduct(String name){
        return !productRepository.findByName(name).isPresent();
    }

}