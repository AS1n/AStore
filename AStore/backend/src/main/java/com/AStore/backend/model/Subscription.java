package com.AStore.backend.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "subscription")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "prod_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Product product;
    @ManyToOne
    @JoinColumn(name = "user_wallet_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Wallet userWallet;
    @Column(name = "start")
    private Date start;
    @Column(name = "end")
    private Date end;
    @Column(name = "is_active")
    private Boolean isActive;


    public Subscription(Product product, Wallet userWallet, Date end, Date start, Boolean isActive) {
        this.product = product;
        this.userWallet = userWallet;
        this.end = end;
        this.start = start;
        this.isActive = isActive;
    }

    public Subscription() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Wallet getUserWallet() {
        return userWallet;
    }

    public void setUserWallet(Wallet userWallet) {
        this.userWallet = userWallet;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Wallet getWallet() {
        return this.getProduct().getWallet();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(id, ((Subscription) o).id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, userWallet, end, start, isActive);
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + id +
                ", start=" + start +
                ", end=" + end +
                ", isActive=" + isActive +
                '}';
    }
}
