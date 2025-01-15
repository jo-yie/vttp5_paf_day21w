package vttp5_paf_day21w.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vttp5_paf_day21w.model.Customer;
import vttp5_paf_day21w.model.Order;
import vttp5_paf_day21w.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // testing
    // GET /api/customers/all 
    @GetMapping("/customers/all")
    public ResponseEntity<List<Customer>> getAllCustomers() { 

        List<Customer> result = customerService.getAllCustomers();
        return ResponseEntity.ok().body(result);

    }

    // task 3A
    // GET /api/customers 
    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(
        @RequestParam(defaultValue = "5") int limit,
        @RequestParam(defaultValue = "0") int offset) { 

        List<Customer> result = customerService.getCustomers(limit, offset);
        return ResponseEntity.ok().body(result);

    }

    // task 3B 
    // GET /api/customer/<customer_id> 
    @GetMapping("/customer/{customer_id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int customer_id) { 

        // return 404 and appropriaye error object 
        // if customer doesn't exist 

        try {

            Customer c = customerService.getCustomerById(customer_id);
            return ResponseEntity.ok().body(c);

        } catch (Exception e) { 

            // TODO customer objects are still being returned for entries that don't exists
            return ResponseEntity.notFound().build();

        }

    }

    // task 3C
    // GET /api/customer/<customer_id>/orders
    @GetMapping("/customer/{customer_id}/orders")
    public ResponseEntity<List<Order>> getCustomerOrders(@PathVariable int customer_id) { 
        
        // return 404 if customer doesn't exist 

        try {

            List<Order> orders = customerService.getOrdersById(customer_id);
            return ResponseEntity.ok().body(orders);

        } catch (Exception e) {

            // return empty array if no orders
            return ResponseEntity.ok().body(null);

        }


    }

}
