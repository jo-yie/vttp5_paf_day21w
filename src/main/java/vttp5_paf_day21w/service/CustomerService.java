package vttp5_paf_day21w.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp5_paf_day21w.model.Customer;
import vttp5_paf_day21w.model.Order;
import vttp5_paf_day21w.repo.CustomerRepo;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public List<Customer> getAllCustomers() {

        return customerRepo.getAllCustomers();

    }

    public List<Customer> getCustomers(int limit, int offset) {

        return customerRepo.getCustomers(limit, offset);

    }

    public Customer getCustomerById(int id) { 

        return customerRepo.getCustomerById(id);

    }

    public List<Order> getOrdersById(int id) {

        return customerRepo.getOrdersById(id);

    }
    
}
