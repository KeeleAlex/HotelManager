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
        
          for(int i = 1 ; i <= 20; i++){
            if(i <= 3){
                Room room = new Room(i, 6, false, 100.00);
                rooms.add(room);
            }else if(i <= 10 ){
              Room room = new Room(i, 4, false, 85.00);
              rooms.add(room);
            }else if(i <= 15 ){
                Room room = new Room(i, 2, false, 70.00);
                rooms.add(room);
            }else if(i <= 20){
                Room room = new Room(i, 1, false, 50.00);
                rooms.add(room);
            }
            
          }
          
         return rooms; 
    }
}
