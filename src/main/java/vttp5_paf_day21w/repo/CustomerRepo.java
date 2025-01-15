package vttp5_paf_day21w.repo;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp5_paf_day21w.model.Customer;
import vttp5_paf_day21w.model.Order;

@Repository
public class CustomerRepo {

    @Autowired
    private JdbcTemplate template;

    public List<Customer> getAllCustomers() { 

        SqlRowSet rs = template.queryForRowSet(Queries.SQL_SELECT_ALL_CUSTOMERS);
        List<Customer> results = new LinkedList<>();

        while (rs.next()) {
            Customer c = Customer.toCustomer(rs);
            results.add(c);

        }

        return results;

    }

    public List<Customer> getCustomers(int limit, int offset) { 

        SqlRowSet rs = template.queryForRowSet(Queries.SQL_SELECT_CUSTOMERS, limit, offset);
        List<Customer> results = new LinkedList<>(); 

        while (rs.next()) { 
            Customer c = Customer.toCustomer(rs);
            results.add(c);
            
        }

        return results; 

    }

    public Customer getCustomerById(int id) { 

        SqlRowSet rs = template.queryForRowSet(Queries.SQL_SELECT_CUSTOMER_BY_ID, id);

        Customer c = new Customer();

        while (rs.next()) { 
            c = Customer.toCustomer(rs);
            
        }

        return c; 
        
    }

    public List<Order> getOrdersById(int id) { 

        SqlRowSet rs= template.queryForRowSet(Queries.SQL_SELECT_ORDERS_BY_CUSTOMER_ID, id);

        List<Order> results = new LinkedList<>(); 

        while (rs.next()) {

            Order o = Order.toOrder(rs); 
            results.add(o);

        }

        return results; 

    }
    
}
