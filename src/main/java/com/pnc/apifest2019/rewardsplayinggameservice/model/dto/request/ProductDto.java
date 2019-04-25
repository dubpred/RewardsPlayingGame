package com.pnc.apifest2019.rewardsplayinggameservice.model.dto.request;

import com.pnc.apifest2019.rewardsplayinggameservice.model.entity.Product;

import javax.validation.constraints.Min;
import java.util.List;

//TODO: Review all Validation Constraints
public class ProductDto {

    public ProductDto(){}

    //  @NotBlank(message = "Must specify a product name")
    private String name;

    //  @NotBlank(message = "Must specify a product catagory")
    //TODO: see if validation is needed
    private Product.ProductCatagory productCatagory;

    //  @NotBlank(message = "Must specify a tier formula")
    //TODO: see if validation is needed
    private Product.XpTierFormula xpTierFormula;

    //  @NotNull(message = "Must specify the number of tiers")
    @Min(value = 1, message = "A product must have at least 1 tier")
    private long numberOfTiers;

    private List<TransactionEarnRateDto> transactionEarnRates;

    private List<EventDetailDto> eventDetails;

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

    public Product.XpTierFormula getXpTierFormula() {
        return xpTierFormula;
    }

    public void setXpTierFormula(Product.XpTierFormula xpTierFormula) {
        this.xpTierFormula = xpTierFormula;
    }

    public long getNumberOfTiers() {
        return numberOfTiers;
    }

    public void setNumberOfTiers(long numberOfTiers) {
        this.numberOfTiers = numberOfTiers;
    }

    public List<TransactionEarnRateDto> getTransactionEarnRates() {
        return transactionEarnRates;
    }

    public void setTransactionEarnRates(List<TransactionEarnRateDto> transactionEarnRates) {
        this.transactionEarnRates = transactionEarnRates;
    }

    public List<EventDetailDto> getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(List<EventDetailDto> eventDetails) {
        this.eventDetails = eventDetails;
    }
}
