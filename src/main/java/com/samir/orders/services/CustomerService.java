package com.samir.orders.services;

import com.samir.orders.models.Customer;

import java.util.List;

public interface CustomerService
{
    List<Customer> findall();

    Customer findById(long id);

    Customer save(Customer customer);

    Customer update(Customer customer,
                      long id);

    void delete(long id);
}
