/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagment;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HotelManagment extends Application{


    
    public static void main(String[] args) {
        launch(args);
        System.out.println("Hello World");
        
        
        
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage window = primaryStage;
        
        window.setScene(window1());
        
        window.show();     
    }
    
    private Scene window1(){
        //Building Window
        Scene scene;        
        BorderPane Pane = new BorderPane();
        scene = new Scene(Pane);
        FlowPane disp = new FlowPane();
        
        //Building shit to put on window
        Button click = new Button("Click me, asshat.");
        
        
        
        //putting it on the window
        disp.setMinSize(200, 100);
        disp.getChildren().addAll(click);
        
        Pane.setCenter(disp);
        
        return scene;
        
    }
    
}
