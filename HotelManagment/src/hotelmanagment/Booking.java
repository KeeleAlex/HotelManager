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
    Hotel hotel;
    
    public Booking(int custid, int occ) {
        roomID = -1;
        customerID = custid;
        occupants = occ;
        hotel.load();
        for(Object room : hotel.load()) {
            Room r = (Room)room;
            if(r.checkedIn() == true && occ == r.getCapacity()) {
                roomID = r.getRoomid();
            }
        }
        
        if(roomID == -1) {
            //no rooms available, do we allow for bookings when occupants < max occupants?
        }
        
        if(roomID != -1) {
            Hotel.getRoomByID(roomID).checkIn(customerID);
        } else {
            //room still not found after occupants < max occupants check
        }
    }
    
    public int getID() {
        return customerID;
    }
    
    public int getRoomID() {
        return roomID;
    }
    
    public int getOccupants() {
        return occupants;
    }
}
