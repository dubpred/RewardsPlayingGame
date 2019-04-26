package com.pnc.apifest2019.rewardsplayinggameservice.model.entity;

import com.pnc.apifest2019.rewardsplayinggameservice.model.dto.request.TransactionEarnRateDto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity(name = "transaction_earn_rate")
public class TransactionEarnRate {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_catagory")
    private TransactionCatagory transactionCatagory;

    @NotNull
    @Column(name = "tier")
    private long tier;

    @NotNull
    @Column(name = "point_earn_rate") //TODO: determine if this should be not null with default value
    private BigDecimal pointEarnRate;

    @NotNull
    @Column(name = "point_earn_amount")
    private long pointEarnAmount;

    //------------------------------------------- Mappings -------------------------------------------------------------
    //Many transaction_earn_rates can have one product
    @NotNull
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;
    //------------------------------------------- End of Mappings -------------------------------------------------------

    public void init(TransactionEarnRateDto transactionEarnRateDto){
        this.tier = transactionEarnRateDto.getTier();
        this.transactionCatagory = transactionEarnRateDto.getTransactionCatagory();
        this.pointEarnRate = transactionEarnRateDto.getPointEarnRate();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getPointEarnRate() {
        return pointEarnRate;
    }

    public void setPointEarnRate(BigDecimal pointEarnRate) {
        this.pointEarnRate = pointEarnRate;
    }

    public TransactionCatagory getTransactionCatagory() {
        return transactionCatagory;
    }

    public void setTransactionCatagory(TransactionCatagory transactionCatagory) {
        this.transactionCatagory = transactionCatagory;
    }

    public long getTier() {
        return tier;
    }

    public void setTier(long tier) {
        this.tier = tier;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public long getPointEarnAmount() {
        return pointEarnAmount;
    }

    public void setPointEarnAmount(long pointEarnAmount) {
        this.pointEarnAmount = pointEarnAmount;
    }

    public enum TransactionCatagory{
        MISC,
        GAS,
        FOOD,
        TRAVEL,
        RESTAURANT,
        GROCERY,
        ALL,
        STUDENT_LOAN_PAYMENT,
        CAR_PAYMENT,
        MTG_PAYMENT,

    }

}