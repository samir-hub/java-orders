package com.samir.orders.controllers;

import com.samir.orders.models.Customer;
import com.samir.orders.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        List<Customer> myList = customerService.findAll();
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }

    // POST http://localhost:2019/customer/new

    @PostMapping(value = "/new",
                 consumes = {"application/json"})
    public ResponseEntity<?> addNewCustomer(@Valid
                                              @RequestBody
                                              Customer newCustomer)
    {
        customerService.save(newCustomer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // PUT http://localhost:2019/customer/update/2
    @PutMapping(value = "/update/{custcode}",
                consumes = {"application/json"})
    public ResponseEntity<?> updateACustomer(@RequestBody Customer customer,
                                               @PathVariable long custcode)
    {
        customerService.update(customer, custcode);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // DELETE http://localhost:2019/customer/delete/2
    @DeleteMapping(value = "/delete/{custcode}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable long custcode)
    {
        customerService.delete(custcode);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
