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
    private int roomNumber;
    private int occupants;
    private String roomType;
    
    public Customer() {
        this.Name = "||none||";
        this.houseNumber = "||none||";
        this.roadName = "||none||";
        this.town = "||none||";
        this.county = "||none||";
        this.postCode = "||none||";
        this.phoneNumber = "||none||";
        this.email = "||none||";
        this.roomNumber = -1;
        this.occupants = -1;
        this.roomType = "";
        
    }
    
    public Customer(String in) {
        this.Name = "Alex";
        this.houseNumber = "25";
        this.roadName = "Ironbridge Drive";
        this.town = "Silverdale";
        this.county = "Staffordshire";
        this.postCode = "ST6 5ER";
        this.phoneNumber = "07722352827";
        this.email = "alex@keele.com";
        this.roomNumber = -1;
        this.occupants = 4;
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
    
    public void setRoomnumber(int name){
        this.roomNumber = name;
    }
    
    public void setType(String type){
        this.roomType = type;
        System.out.println(type + " " + this.getTypeCapacity());
        this.occupants = this.getTypeCapacity();
        
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
    
    public String getAddress(){
        return this.houseNumber + "\n" + this.roadName + "\n" + this.town + "\n" + this.county + "\n" + this.postCode 
                + "\n";
    }
    
    public String getPhonenumber(){
        return this.phoneNumber;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public int getRoomnumber(){
        return this.roomNumber;
    }
    
    public int getOccupants(){
        return this.occupants;
    }
    
    public String getType(){
        return this.roomType;
    }
    
    @Override
    public String toString(){
        String x;
        x = "==============================\nID: " +  String.valueOf(this.ID) + " \nName: " + this.Name + "\nAddress:\n" 
                + this.houseNumber + "\n" + this.roadName + "\n" + this.town + "\n" + this.county + "\n" + this.postCode 
                + "\n" +"Email: "+ this.email +"\nPhone Number: "+ this.phoneNumber + "\nOccupants: " + this.occupants +"\n";
        return x;
    }
    
    public int getTypeCapacity(){
        switch (this.roomType) {
            
            case "Single":
                return 1;
            case "Twin":
                return 2;
            case "King Bed":
                return 2;
            case "Three person":
                return 3;
            case "Four person":
                return 4;
            case "Five person":
                return 5;
            case "Six person":
                return 6;
            
        }
        return 20;
    }
}
