/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Made with love, by Alex1
 */
public class hotelFactory {
    
    
    public ObservableList hotelFactory(){
        ObservableList rooms = FXCollections.observableArrayList();
        
          for(int i = 1 ; i <= 30; i++){
            if(i <= 3){
                Room room = new Room(i, "Six person", false, 100.00);
                rooms.add(room);
            }else if(i <= 10 ){
              Room room = new Room(i, "Five person", false, 85.00);
              rooms.add(room);
            }else if(i <= 15 ){
                Room room = new Room(i, "Four person", false, 70.00);
                rooms.add(room);
            }else if(i <= 20){
                Room room = new Room(i, "Three person", false, 50.00);
                rooms.add(room);
            }else if(i <= 23){
                Room room = new Room(i, "King Bed", false, 50.00);
                rooms.add(room);
            }else if(i <= 27){
                Room room = new Room(i, "Twin", false, 50.00);
                rooms.add(room);
            }else if(i <= 30){
                Room room = new Room(i, "Single", false, 50.00);
                rooms.add(room);
            }
            
          }
          
         return rooms; 
    }
}

/*roomtypes.add("Single");
roomtypes.add("Twin");
roomtypes.add("King Bed");
roomtypes.add("Three person");
roomtypes.add("Four person");
roomtypes.add("Five person");
roomtypes.add("Six person ");*/