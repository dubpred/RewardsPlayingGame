package com.pnc.apifest2019.rewardsplayinggameservice.model.entity;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity(name = "event_detail")
public class EventDetail {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "xp_earn_amount")
    private long xpEarnAmount;

    @Column(name = "occurance_trigger")
    private long occuranceTrigger;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdDate;

    @UpdateTimestamp
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "last_updated_date")
    private Date lastUpdatedDate;

    //------------------------------------------- Mappings -------------------------------------------------------------

    //many event_details can have one product
    @NotNull
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    //One event_detail can have many xp_events
    @OneToMany(mappedBy = "eventDetail")
    private List<XpEvent> xpEvents;
    //------------------------------------------- End of Mappings -------------------------------------------------------

    public void init(EventDetailDto eventDetailDto){
        this.name = eventDetailDto.getName();
        this.xpEarnAmount = eventDetailDto.getXpEarnAmount();
        this.occuranceTrigger = eventDetailDto.getOccuranceTrigger();
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

    public long getXpEarnAmount() {
        return xpEarnAmount;
    }

    public void setXpEarnAmount(long xpEarnAmount) {
        this.xpEarnAmount = xpEarnAmount;
    }

    public long getOccuranceTrigger() {
        return occuranceTrigger;
    }

    public void setOccuranceTrigger(long occuranceTrigger) {
        this.occuranceTrigger = occuranceTrigger;
    }

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

    public Product getProduct() { return product; }

    public void setProduct(Product product) { this.product = product; }

    public List<XpEvent> getXpEvents() { return xpEvents; }

    public void setXpEvents(List<XpEvent> xpEvents) { this.xpEvents = xpEvents; }
}