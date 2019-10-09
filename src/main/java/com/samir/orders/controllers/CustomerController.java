package com.samir.orders.controllers;

import com.samir.orders.models.Customer;
import com.samir.orders.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController

{
    @Autowired
    private CustomerService customerService;

    // GET http://localhost:2019/customer/order
    @GetMapping(value = "/order",
                produces = {"application/json"})
    public ResponseEntity<?> listAllCustomers()
    {
        List<Customer> myList = customerService.findall();
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }

    // POST http://localhost:2019/customer/new

    // PUT http://localhost:2019/customer/update/2

    // DELETE http://localhost:2019/customer/delete/2
}
