package com.pnc.apifest2019.rewardsplayinggameservice.model.entity;
import com.pnc.apifest2019.rewardsplayinggameservice.model.dto.request.ProductDto;
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

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions;
    //------------------------------------------- End of Mappings -------------------------------------------------------

    public void init(ProductDto productDto){
        this.name = productDto.getName();
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    //------------------------------------------- Enums -------------------------------------------------------------
    public enum ProductCatagory{
        CREDIT_CARD
    }

}