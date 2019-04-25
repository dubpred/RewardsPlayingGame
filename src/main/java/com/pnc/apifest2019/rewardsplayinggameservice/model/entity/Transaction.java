package com.pnc.apifest2019.rewardsplayinggameservice.model.entity;

import com.pnc.apifest2019.rewardsplayinggameservice.model.dto.request.TransactionDto;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "transaction")
public class Transaction {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //TODO: look up additional annotations needed for enums, validation of enum in dto class
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_catagory")
    private TransactionEarnRate.TransactionCatagory transactionCatagory;

    @NotNull
    @Column(name = "amount") //TODO: determine if this should be not null with default value
    private BigDecimal amount;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "posted_date")
    private Date postedDate;

    //------------------------------------------- Mappings -------------------------------------------------------------
    //Many transactions can have one item
    @NotNull
    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private Item item;
    //------------------------------------------- End of Mappings -------------------------------------------------------

    public void init(TransactionDto transactionDto){
        this.transactionCatagory = transactionDto.getTransactionCatagory();
        this.amount = transactionDto.getAmount();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getCreatedDate() {
        return postedDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.postedDate = createdDate;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public TransactionEarnRate.TransactionCatagory getTransactionCatagory() {
        return transactionCatagory;
    }

    public void setTransactionCatagory(TransactionEarnRate.TransactionCatagory transactionCatagory) {
        this.transactionCatagory = transactionCatagory;
    }
}
