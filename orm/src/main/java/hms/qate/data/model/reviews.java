package hms.qate.data.model;

import org.json.simple.JSONObject;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Ranga Reddy
 * @version 1.0
 *
 */
@Entity
@Table(name = "reviews")
public class reviews implements Serializable {

    private static final long serialVersionUID = -7988799579036225137L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int view_ID;

//    @Column
//    private int Restaurant_ID;

    @Column
    private int customer_ID;
    @Column
    private int restaurant_ID;
    @Column
    private int rating;
    @Column
    private String  comment;
    @Column
    private String  delivery_Status;
    @Column
    private String  time_Status;




    public reviews() {
    }
    public int getView_ID() {
        return view_ID;
    }
    public void setView_ID(int view_ID) {

        this.view_ID = view_ID;
    }
    public int getCustomer_ID(){
        return customer_ID;
    }
    public void setCustomer_ID(int customer_ID){
        this.customer_ID = customer_ID;
    }
    public int getRestaurant_ID(){
        return restaurant_ID;
    }
    public void setRestaurant_ID(int restaurant_ID){
        this.restaurant_ID = restaurant_ID;
    }
    public int getRating(){
        return rating;
    }
    public void setRating(int rating){
        this.rating = rating;
    }
    public String getComment(){
        return comment;
    }
    public void setComment(String comment){
        this.comment = comment;
    }
    public String getDelivery_Status(){
        return delivery_Status;
    }
    public void setDelivery_Status(String delivery_Status){
        this.delivery_Status = delivery_Status;
    }

    public String getTime_Status(){
        return time_Status;
    }
    public void setTime_Status(String time_Status){
        this.time_Status = time_Status;
    }



}