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
    private int customerID;
    private int roomID;
    private int occupants;
    
    public Booking(int custid, int occ, Hotel hotel) {
        roomID = -1;
        customerID = custid;
        occupants = occ;
        try {
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        for(Object room : hotel.Rooms) {
            Room r = (Room)room;
            if(r.getCheckedIn() == true && occ == r.getCapacity()) {
                roomID = r.getRoomid();
            }
        }
        
        if(roomID == -1) {
            //no rooms available, do we allow for bookings when occupants < max occupants?
        }
        
        if(roomID != -1) {
            hotel.getRoomByID(roomID).checkIn(customerID);
        } else {
            //room still not found after occupants < max occupants check
        }
    }
    
    public int getCustomerID() {
        return customerID;
    }
    
    public int getRoomID() {
        return roomID;
    }
    
    public int getOccupants() {
        return occupants;
    }
}
