/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagment;

import java.io.File;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.w3c.dom.*;

/**
 *
 * @author Alex
 */
public class Hotel {   
    public ObservableList<Room> Rooms = FXCollections.observableArrayList();  
    hotelFactory builder = new hotelFactory();
    
    public Hotel(){
        File f = new File("Hoteldata.xml");
        Rooms = newHotel();
        
    }
    //print's all the rooms and their information to the console
    public String print(ObservableList hotel){
        String x = "";
        for(Object room: hotel){
            Room y = (Room)room;
            x = x + y.toString();
        }
        return x;
    }
    
    public void save(){
        
    }
    
    public ObservableList newHotel(){
        ObservableList HList;
        HList = builder.hotelFactory();
        return HList;
    }
    
    public Room getRoomByID(int id) {
        for(Object room : Rooms) {
            Room r = (Room)room;
            if(r.getRoomid() == id) return r;
        }
        return null;
    }
}
