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
@Table(name = "Restaurant")
public class Restaurant implements Serializable {

    private static final long serialVersionUID = -7988799579036225137L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Restaurant_ID;

//    @Column
//    private int Restaurant_ID;

    @Column
    private String Restaurant_Name;
    @Column
    private String RUsername;
    @Column
    private String Password;
    @Column
    private String OFacility;
    @Column
    private String Email;
    @Column
    private String NearestCity;
    @Column
    private String Location;
    @Column
    private String RImage;


    public Restaurant() {
    }
    public int getRestaurant_ID() {
        System.out.println("dddddddddddddd"+Restaurant_ID);
        return Restaurant_ID;
    }
    public void setRestaurant_ID(int Restaurant_ID) {
        this.Restaurant_ID = Restaurant_ID;
    }
    public String getRestaurant_Name() {
        return Restaurant_Name;
    }
    public void setRestaurant_Name(String Restaurant_Name) {
        this.Restaurant_Name = Restaurant_Name;
    }
    public String getRUsername() {
        return RUsername;
    }
    public void setRUsername(String RUsername) {
        this.RUsername = RUsername;
    }
    public String getPassword() {
        return Password;
    }
    public void setPassword(String Password) {
        this.Password = Password;
    }
    public String getOFacility() {
        return OFacility;
    }
    public void setOFacility(String OFacility) {
        this.OFacility = OFacility;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String Email) {
        this.Email = Email;
    }
    public String getNearestCity() {
        return NearestCity;
    }
    public void setNearestCity(String NearestCity) {
        this.NearestCity = NearestCity;
    }
    public String getLocation() {
        return Location;
    }
    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getRImage() {
        return RImage;
    }
    public void setRImage(String RImage) {
        this.RImage = RImage;
    }






    @Override
    public String toString() {


        JSONObject restaurant = new JSONObject();
        restaurant.put("Restaurant_ID",Restaurant_ID);
        restaurant.put("Restaurant_Name",Restaurant_Name);
        restaurant.put("RUsername",RUsername);
        restaurant.put("Password",Password);
        restaurant.put("OFacility",OFacility);
        restaurant.put("Email",Email);
        restaurant.put("NearestCity",NearestCity);
        restaurant.put("Location",Location);
        restaurant.put("RImage",RImage);


        String restaurant2 = String.valueOf(restaurant);





        return restaurant2;
    }
}