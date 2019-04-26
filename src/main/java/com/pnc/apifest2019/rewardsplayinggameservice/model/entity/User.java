package com.pnc.apifest2019.rewardsplayinggameservice.model.entity;

import com.pnc.apifest2019.rewardsplayinggameservice.model.dto.request.CreateUserDto;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity(name = "user")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "tier")
    private long tier;

    @NotNull //TODO: figure out why I cant make this not null in DB
    @Column(name = "points_balance")
    private long pointsBalance;

    @CreationTimestamp
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdDate;

    @UpdateTimestamp
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "last_updated_date")
    private Date lastUpdatedDate;

    //------------------------------------------- Mappings -------------------------------------------------------------
    //One user can have many items
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> items;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<XpEvent> xpEvents;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions;
    //------------------------------------------- End of Mappings -------------------------------------------------------

    public void init(CreateUserDto createUserDto){
        this.name = createUserDto.getName();
        this.tier = 0;
        this.pointsBalance = 0;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPointsBalance() { return pointsBalance; }

    public void setPointsBalance(long pointsBalance) { this.pointsBalance = pointsBalance; }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTier() {
        return tier;
    }

    public void setTier(long tier) {
        this.tier = tier;
    }

    public List<XpEvent> getXpEvents() {
        return xpEvents;
   }

    public void setXpEvents(List<XpEvent> xpEvents) {
        this.xpEvents = xpEvents;
    }

    public List<Transaction> getTransactions() {
       return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
       this.transactions = transactions;
    }
}
