package com.samir.orders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ordernum;

    private double ordamount;
    private double advanceamt;
    private String orddescription;

    @ManyToOne
    @JoinColumn(name = "custcode",
                nullable = false)
    @JsonIgnoreProperties("orders")
    private Customer customer;

    public Order()
    {
    }

    public Order(double ordamount, double advanceamt, String orddescription, Customer customer)
    {
        this.ordamount = ordamount;
        this.advanceamt = advanceamt;
        this.orddescription = orddescription;
        this.customer = customer;
    }

    public long getOrdernum()
    {
        return ordernum;
    }

    public void setOrdernum(long ordernum)
    {
        this.ordernum = ordernum;
    }

    public double getOrdamount()
    {
        return ordamount;
    }

    public void setOrdamount(double ordamount)
    {
        this.ordamount = ordamount;
    }

    public double getAdvanceamt()
    {
        return advanceamt;
    }

    public void setAdvanceamt(double advanceamt)
    {
        this.advanceamt = advanceamt;
    }

    public String getOrddescription()
    {
        return orddescription;
    }

    public void setOrddescription(String orddescription)
    {
        this.orddescription = orddescription;
    }

    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }
}
