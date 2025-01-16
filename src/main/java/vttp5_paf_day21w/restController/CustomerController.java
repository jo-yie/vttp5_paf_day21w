package vttp5_paf_day21w.restController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    // using Optional
    @GetMapping("/customer/{customer_id}")
    public ResponseEntity<Object> getCustomerById(@PathVariable int customer_id) { 

        Optional<Customer> c = customerService.getCustomerById(customer_id);

        if (c.isPresent()) {

            Customer customer = c.get(); 

            // get list of order objects 
            List<Order> orders = customerService.getOrdersById(customer_id); 
            customer.setOrders(orders);

            return ResponseEntity.ok(customer); 

        } else {

            // return 404 is customer doesn't exist 
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body(Map.of("Error", "Customer doesn't exist"));
        }

    }

    // task 3C
    // GET /api/customer/<customer_id>/orders
    @GetMapping("/customer/{customer_id}/orders")
    public ResponseEntity<Object> getCustomerOrders(@PathVariable int customer_id) { 
        
        Optional<Customer> c = customerService.getCustomerById(customer_id);

        if (c.isPresent()) {

            List<Order> orders = customerService.getOrdersById(customer_id);

            // return empty array if no orders found
            return ResponseEntity.ok().body(orders);

        } else { 

            // return 404 if customer doesn't exist
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                .body(Map.of("Error", "Customer doesn't exist"));

        }

    }

}
