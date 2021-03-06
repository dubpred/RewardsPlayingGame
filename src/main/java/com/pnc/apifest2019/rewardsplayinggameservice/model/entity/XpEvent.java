package com.pnc.apifest2019.rewardsplayinggameservice.model.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity(name = "xp_event")
public class XpEvent {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CreationTimestamp
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "posted_date")
    private Date postedDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    //------------------------------------------- Mappings -------------------------------------------------------------
    //Many xp_events can have one event_detail
    @NotNull
    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private Item item;

    //Many xp_events can have one item
    @NotNull
    @ManyToOne
    @JoinColumn(name = "event_detail_id", referencedColumnName = "id")
    private EventDetail eventDetail;
    //------------------------------------------- End of Mappings -------------------------------------------------------

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public EventDetail getEventDetail() {
        return eventDetail;
    }

    public void setEventDetail(EventDetail eventDetail) {
        this.eventDetail = eventDetail;
    }
}
