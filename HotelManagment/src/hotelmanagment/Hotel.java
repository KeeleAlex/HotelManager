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
    ObservableList rooms = FXCollections.observableArrayList();
    hotelFactory builder = new hotelFactory();
    public Hotel(){
        File f = new File("/Users/Alex/Documents/HotelSladproj/HotelManagment/src/hotelmanagment/Hoteldata.xml");
         
        
        
        rooms = builder.hotelFactory();
        
    }
    //print's all the rooms and their information to the console
    public String print(){
        String x = "";
        for(Object room: this.rooms){
            Room y = (Room)room;
            x = x + y.toString();
        }
        return x;
    }
}
