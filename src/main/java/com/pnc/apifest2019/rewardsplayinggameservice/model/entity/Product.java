package com.pnc.apifest2019.rewardsplayinggameservice.model.entity;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity(name = "product")
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "product_catagory")
    private ProductCatagory productCatagory;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "xp_tier_formula")
    private XpTierFormula xpTierFormula;

    @NotNull
    @Column(name = "number_of_tiers")
    private long numberOfTiers;

    @CreationTimestamp
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdDate;

    //------------------------------------------- Mappings -------------------------------------------------------------
    //One product can have many items
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> items;

    //One product can have many transaction_earn_rates
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TransactionEarnRate> transactionEarnRates;

    //One product can have many event_details
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EventDetail> eventDetails;
    //------------------------------------------- End of Mappings -------------------------------------------------------

    public void init(ProductDto productDto){
        this.name = productDto.getName();
        this.productCatagory = productDto.getProductCatagory();
        this.xpTierFormula = productDto.getXpTierFormula();
        this.numberOfTiers = productDto.getNumberOfTiers();
    }

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

    public long getNumberOfTiers() {
        return numberOfTiers;
    }

    public void setNumberOfTiers(long numberOfTiers) {
        this.numberOfTiers = numberOfTiers;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public ProductCatagory getProductCatagory() {
        return productCatagory;
    }

    public void setProductCatagory(ProductCatagory productCatagory) {
        this.productCatagory = productCatagory;
    }

    public XpTierFormula getXpTierFormula() {
        return xpTierFormula;
    }

    public void setXpTierFormula(XpTierFormula xpTierFormula) {
        this.xpTierFormula = xpTierFormula;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<TransactionEarnRate> getTransactionEarnRates() {
        return transactionEarnRates;
    }

    public void setTransactionEarnRates(List<TransactionEarnRate> transactionEarnRates) {
        this.transactionEarnRates = transactionEarnRates;
    }

    public List<EventDetail> getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(List<EventDetail> eventDetails) {
        this.eventDetails = eventDetails;
    }

    //------------------------------------------- Enums -------------------------------------------------------------
    public enum ProductCatagory{
        CREDIT_CARD
    }

    public enum XpTierFormula{
        STANDARD
    }
}