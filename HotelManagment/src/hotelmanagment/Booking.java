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
    private Room room;
    private int occupants;
    
    public Booking(int custid, int occ, ObservableList<Room> hotel) {
        room = null;
        customerID = custid;
        occupants = occ;
        try {
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        for(Object rom : hotel) {
            Room r = (Room)rom;
            if(r.getCheckedIn() == false) {
                //System.out.println("Checked in: " + r.getCheckedIn());
                if(r.getCapacity() >= occ) {
                    //System.out.println("occ: " + occ);
                    room = r;
                    r.setCheckedIn(true);
                    r.setCustomerID(customerID);
                    break;
                    //System.out.println("room id: " + roomID);
                    
                    
                }else{
                    
                   r.setCheckedIn(false);
                   r.setCustomerID(-1);
                    
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
        return customerID;
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
        return occupants;
    }
}
