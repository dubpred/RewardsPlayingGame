package com.pnc.apifest2019.rewardsplayinggameservice.model.dto.request;

import com.pnc.apifest2019.rewardsplayinggameservice.model.entity.Product;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

//TODO: Review all Validation Constraints
public class ProductDto {

    public ProductDto(){}

    @NotBlank(message = "Must specify a product name")
    private String name;

    @NotNull
    private List<TransactionEarnRateDto> transactionEarnRates;

    private List<EventDetailDto> eventDetails;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
