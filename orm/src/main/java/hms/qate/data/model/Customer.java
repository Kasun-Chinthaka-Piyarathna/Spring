package hms.qate.data.model;

import org.json.simple.JSONObject;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by chinthaka on 9/29/17.
 */
@Entity
@Table(name = "Customer")
public class Customer implements Serializable {

    private static final long serialVersionUID = -7988799579036225137L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Customer_ID;


    @Column
    private String Customer_Full_Name;
    @Column
    private String Contact_Number;
    @Column
    private String Email;
    @Column
    private String NIC;
    @Column
    private String Username;
    @Column
    private String Password;


    public Customer() {
    }

    public int getCustomer_ID() {
        System.out.println("dddddddddddddd" + Customer_ID);
        return Customer_ID;
    }

    public void setCustomer_ID(int Customer_ID) {
        this.Customer_ID = Customer_ID;
    }

    public String getCustomer_Full_Name() {
        return Customer_Full_Name;
    }

    public void setCustomer_Full_Name(String Customer_Full_Name) {
        this.Customer_Full_Name = Customer_Full_Name;
    }

    public String getContact_Number() {
        return Contact_Number;
    }

    public void setContact_Number(String Contact_Number) {
        this.Contact_Number = Contact_Number;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }


    @Override
    public String toString() {


        JSONObject Customer = new JSONObject();
        Customer.put("Restaurant_ID", Customer_ID);
        Customer.put("Restaurant_Name", Customer_Full_Name);
        Customer.put("RUsername", Contact_Number);
        Customer.put("Password", Email);
        Customer.put("OFacility", NIC);
        Customer.put("Email", Username);
        Customer.put("NearestCity", Password);


        String Customer2 = String.valueOf(Customer);


        return Customer2;
    }
}