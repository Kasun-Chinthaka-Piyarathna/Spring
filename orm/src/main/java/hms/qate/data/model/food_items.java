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
@Table(name = "food_items")
public class food_items implements Serializable {

    private static final long serialVersionUID = -7988799579036225137L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int food_item_id;

//    @Column
//    private int Restaurant_ID;

    @Column
    private String name;
    @Column
    private String quantity;
    @Column
    private String unit_Price;
    @Column
    private int  Restaurant_ID;



    public food_items() {
    }
    public int Food_item_id() {
        return food_item_id;
    }
    public void setFood_item_id(int food_item_id) {

        this.food_item_id = food_item_id;
    }
    public int getRes_id(){
        return Restaurant_ID;
    }
    public void setRes_id(int res_id){
        this.Restaurant_ID = Restaurant_ID;
    }

    public String getName() {

        return name;
    }
    public void setName(String name) {

        this.name = name;
    }
    public String getQuantity() {
        return quantity;
    }
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    public String getUnit_Price() {
        return unit_Price;
    }
    public void setUnit_Price(String unit_Price) {
        this.unit_Price = unit_Price;
    }



}