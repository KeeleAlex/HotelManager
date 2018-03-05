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
    private int ID;
    private String Name;
    private String houseNumber;
    private String roadName;
    private String town;
    private String county;
    private String postCode;
    private String phoneNumber;
    private String email;
    private String roomNumber;
    private String occupants;
    
    public Customer() {
        this.Name = "//none\\";
        this.houseNumber = "//none\\";
        this.roadName = "//none\\";
        this.town = "//none\\";
        this.county = "//none\\";
        this.postCode = "//none\\";
        this.phoneNumber = "//none\\";
        this.email = "//none\\";
        this.roomNumber = "//none\\";
        this.occupants = "//none\\";
        
        
    }
    
    public int getID(){
        return this.ID;
    }
    
    public void setID(int num){
        this.ID = num;
    }
    
    public void setName(String name){
        this.Name = name;
    }
    
    public void setHousenumber(String name){
        this.houseNumber = name;
    }
    
    public void setRoadname(String name){
        this.roadName = name;
    }
    
    public void setTown(String name){
        this.town = name;
    }
    
    public void setCounty(String name){
        this.county = name;
    }
    
    public void setPostcode(String name){
        this.postCode = name;
    }
    
    public void setPhonenumber(String name){
        this.phoneNumber = name;
    }
    
    public void setEmail(String name){
        this.email = name;
    }
    
    public void setRoomnumber(String name){
        this.roomNumber = name;
    }
    
    public void setOccupants(String name){
        this.occupants = name;
    }
    
    public String getName(){
        return this.Name;
    }
    
    public String getHousenumber(){
        return this.houseNumber;
    }
    
    public String getRoadname(){
        return this.roadName;
    }
    
    public String getTown(){
        return this.town;
    }
    
    public String getCounty(){
        return this.county;
    }
    
    public String getPostcode(){
        return this.postCode;
    }
    
    public String getPhonenumber(){
        return this.phoneNumber;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public String getRoomnumber(){
        return this.roomNumber;
    }
    
    public String getOccupants(){
        return this.occupants;
    }
    
    @Override
    public String toString(){
        String x;
        x = "=========================\nID: " +  String.valueOf(this.ID) + " \nName: " + this.Name + "\nAddress:\n" + this.houseNumber + "\n" + this.roadName + "\n" + this.town + "\n" + this.county + "\n" + this.postCode + "\n" +"Email: "+ this.email +"\nPhone Number: "+ this.phoneNumber + "\nOccupants: " + this.occupants +"\n =========================";
        return x;
    }
}
