/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagment;

/**
 *
 * @author csheen
 */
public class Booking {
    private int customerID;
    private int roomID;
    private int occupants;
    
    public Booking(int custid, int occ) {
        roomID = -1;
        customerID = custid;
        occupants = occ;
        
        for(Room room : r) { //iterate through the the rooms
            if(r.getAvailable() == true && occ == r.getMaxOccupants()) {
                roomID = r.getID();
            }
        }
        
        if(roomID == -1) {
            //no rooms available, do we allow for bookings when occupants < max occupants?
        }
        
        if(roomID != -1) {
            Room.getRoomByID(roomID).setAvailable(false);
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
