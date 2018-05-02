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
public class Room {
    private int roomID;
    private int customerID;
    private int capacity;
    private String type;
    private double price;
    private boolean checkedIn;
    private String calender;
    
    public Room(){
        
        this.roomID = -1;
        this.customerID = -1;
        this.capacity = -1;
        this.type = null;
        this.price = -1;
        this.checkedIn = false;
        this.calender = null;
        
    }
    
    public Room(int id, String type, boolean disabled, double price){
        this.roomID = id;
        this.customerID = -1;
        this.type = type;
        this.capacity = this.getCapacity();
        this.price = price;
        this.checkedIn = false;
        this.calender = null;
    }
    
    
    public int getRoomid(){
        return this.roomID;
    }
    
    public int getCustomerid(){
        return this.customerID;
    }
    
    public int getCapacity(){
        switch (this.type) {
            
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
    
    public boolean getCheckedIn(){
        return this.checkedIn;
    }
    
    public double getPrice() {
        return this.price;
    }
    
    public String getType(){
        return this.type;
    }
    
    public void setRoomID(int in){
        this.roomID = in;
    }
    
    public void setCustomerID(int in){
        this.customerID = in;
    }
    
    public void setCapacity(int in){
        this.capacity = in;
    }
    
    public void setType(String in){
        this.type = in;
    }
    
    public void setCheckedIn(boolean in) {
        this.checkedIn = in;
    }
    
    public void setPrice(double in){
        this.price = in;
    }
    
    //checking in module 
    public void CheckIn(int cust) {
        this.customerID = cust;
        this.checkedIn = true;
    }
    
    public void CheckOut(){
        this.customerID = -1;
        this.checkedIn = false;
    }
    
    
    
    @Override
    public String toString(){
        return "==============================\nRoom ID: " + String.valueOf(this.roomID) + "\nCustomer ID: " + String.valueOf(this.customerID)
                + "\nCapacity: " + this.capacity + "\nType of room: " + this.type + "\nPrice: £" + this.price 
                + "\nCheckedIn: " + this.checkedIn + "\n";
    }
}
