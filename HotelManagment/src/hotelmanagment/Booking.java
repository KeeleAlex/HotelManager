/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagment;

import javafx.collections.ObservableList;

/**
 *
 * @author csheen
 */
public class Booking {
    
    private Customer customer;
    private Room room;
    private String roomType;
    private int occupants;
    
    public Booking(Customer cust, String type, ObservableList<Room> hotel) {
        room = null;
        customer = cust;
        roomType = type;
        
        for(int i = 0; i < hotel.size(); i++) {
            Room r = hotel.get(i);
            //checking whether a room is already booked 
            if(r.getCheckedIn() == false) {
                if(roomType.equals(r.getType())) {
                    room = r;
                    r.CheckIn(customer.getID());
                    cust.setRoomnumber(r.getRoomid());
                    occupants = cust.getOccupants();
                    break; 
                }
            }
        }
        
        
        
        /*if(room != null) {
        hotel.getRoomByID(room).checkIn(customerID);
        } else {
        //room still not found after occupants < max occupants check
        }*/
        
    }
    
    public int getCustomerID() {
        return customer.getID();
    }
    
    public int getRoomID() {
        try {
        return room.getRoomid();
        }catch(NullPointerException e){
            System.out.println(e.getMessage());
            return -1;
        }
    }
    
    public Room getRoom() {
        return room;
    }
    
    public int getOccupants() {
        return this.occupants;
    }
}
