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

    @Column(name = "vendor")
    private String vendor;



    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "posted_date")
    private Date postedDate;

    @Column(name = "point_amount")
    private long pointAmount;


    //------------------------------------------- Mappings -------------------------------------------------------------
    //Many transactions can have one user
    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
       this.user = user;
    }

    public TransactionEarnRate.TransactionCatagory getTransactionCatagory() {
        return transactionCatagory;
    }

    public void setTransactionCatagory(TransactionEarnRate.TransactionCatagory transactionCatagory) {
        this.transactionCatagory = transactionCatagory;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public long getPointAmount() {
        return pointAmount;
    }

    public void setPointAmount(long pointAmount) {
        this.pointAmount = pointAmount;
    }


}
