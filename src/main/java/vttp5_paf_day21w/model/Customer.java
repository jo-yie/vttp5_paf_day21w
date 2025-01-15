package vttp5_paf_day21w.model;

import java.util.List;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Customer {

    private int id; 
    private String company; 
    private String lastName; 
    private String firstName; 
    private String emailAddress; 
    private List<Order> orders; 
    public Customer() {
    }
    public Customer(int id, String company, String lastName, String firstName, String emailAddress,
            List<Order> orders) {
        this.id = id;
        this.company = company;
        this.lastName = lastName;
        this.firstName = firstName;
        this.emailAddress = emailAddress;
        this.orders = orders;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public List<Order> getOrders() {
        return orders;
    }
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    //

    public static Customer toCustomer(SqlRowSet rs) {

        Customer c = new Customer(); 

        c.setId(rs.getInt("id"));
        c.setCompany(rs.getString("company"));
        c.setLastName(rs.getString("last_name"));
        c.setFirstName(rs.getString("first_name"));
        c.setEmailAddress(rs.getString("email_address"));

        // TODO get orders 

        return c;

    }
    
}
