package kaif.shoppingmall;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class OrderDetails {
    private int id;
    private int dateOfPurchase;
    private float total;
    private int customer_id;
    private String paymentMode;
    private int shop_id;
    
    @Id
    // Getter and Setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for dateOfPurchase
    public int getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(int dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    // Getter and Setter for total
    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    // Getter and Setter for customer_id
    public int getCustomerId() {
        return customer_id;
    }

    public void setCustomerId(int customer_id) {
        this.customer_id = customer_id;
    }

    // Getter and Setter for paymentMode
    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    // Getter and Setter for shop_id
    public int getShopId() {
        return shop_id;
    }

    public void setShopId(int shop_id) {
        this.shop_id = shop_id;
    }


    public OrderDetails(){
        super();
    }
    
    @Override
public String toString() {
    return "OrderDetails{" +
            "id=" + id +
            ", dateOfPurchase=" + dateOfPurchase +
            ", total=" + total +
            ", customer_id=" + customer_id +
            ", paymentMode='" + paymentMode + '\'' +
            ", shop_id=" + shop_id +
            '}';
}



    public OrderDetails(int id, int dateOfPurchase, float total, int customer_id, String paymentMode, int shop_id){
        super();
        this.id = id;
        this.dateOfPurchase = dateOfPurchase;
        this.total = total;
        this.customer_id = customer_id;
        this.paymentMode = paymentMode;
        this.shop_id = shop_id;
    }
}