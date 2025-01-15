package vttp5_paf_day21w.model;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Order {

    private int id; 
    private int customerId; 
    private String shipName;
    public Order() {
    }
    public Order(int id, int customerId, String shipName) {
        this.id = id;
        this.customerId = customerId;
        this.shipName = shipName;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public String getShipName() {
        return shipName;
    }
    public void setShipName(String shipName) {
        this.shipName = shipName;
    } 

    public static Order toOrder(SqlRowSet rs) { 

        Order o = new Order();

        o.setId(rs.getInt("id"));
        o.setCustomerId(rs.getInt("customer_id"));
        o.setShipName(rs.getString("ship_name"));

        return o;

    }
 
}
