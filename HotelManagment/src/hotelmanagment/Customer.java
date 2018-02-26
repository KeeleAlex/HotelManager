/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagment;

/**
 *
 * @author Alex
 */
public class Customer {
    String Name;
    //Address address;
    String Phonenumber;
    String Email;
    String Roomnumber;
    String occupants;
    String Roomtype;
    
    private Customer(){
        this.Name = "//no name\\";
        this.Phonenumber = "//no name\\";
        this.Email = "//no name\\";
        this.Roomnumber = "//no name\\";
        this.occupants = "//no name\\";
        this.Roomtype = "//no name\\";
        
        
    }
    
    public void setName(String name){
        this.Name = name;
    }
    
    public void setPhonenumber(String name){
        this.Phonenumber = name;
    }
    
    public void setEmail(String name){
        this.Email = name;
    }
    
    public void setRoomnuber(String name){
        this.Roomnumber = name;
    }
    
    public void setOccupants(String name){
        this.occupants = name;
    }
    
    public void setRoomtype(String name){
        this.Roomtype = name;
    }
    
}
