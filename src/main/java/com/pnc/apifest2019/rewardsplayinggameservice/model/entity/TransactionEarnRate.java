package com.pnc.apifest2019.rewardsplayinggameservice.model.entity;

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

    @NotNull //TODO: determine if this should be not null with default value
    @Column(name = "xp_earn_rate")
    private BigDecimal xpEarnRate;

    //------------------------------------------- Mappings -------------------------------------------------------------
    //Many transaction_earn_rates can have one product
    @NotNull
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;
    //------------------------------------------- End of Mappings -------------------------------------------------------

    public void init(TransactionEarnRateDto transactionEarnRateDto){
        this.transactionCatagory = transactionEarnRateDto.getTransactionCatagory();
        this.tier = transactionEarnRateDto.getTier();
        this.pointEarnRate = transactionEarnRateDto.getPointEarnRate();
        this.xpEarnRate = transactionEarnRateDto.getXpEarnRate();
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

    public BigDecimal getXpEarnRate() {
        return xpEarnRate;
    }

    public void setXpEarnRate(BigDecimal xpEarnRate) {
        this.xpEarnRate = xpEarnRate;
    }

    public long getTier() {
        return tier;
    }

    public void setTier(long tier) {
        this.tier = tier;
    }

    public TransactionCatagory getTransactionCatagory() {
        return transactionCatagory;
    }

    public void setTransactionCatagory(TransactionCatagory transactionCatagory) {
        this.transactionCatagory = transactionCatagory;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public enum TransactionCatagory{
        MISC,
        GAS,
        FOOD,
        TRAVEL,
        RESTAURANT,
        GROCERY,
        ALL
    }

}