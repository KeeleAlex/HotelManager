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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
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
        VBox disp = new VBox();
        HBox Nameline = new HBox();
        
        
        //Building shit to put on window
        Pane pane = new Pane();
        Label Nlabel = new Label("Name: ");
        TextField name = new TextField();
        name.setPromptText("Input Customer Name");
        
        
        
        
        //putting it on the window
        pane.getChildren().addAll(Nlabel);
        Nameline.getChildren().addAll(pane, name);
        disp.setMinSize(200, 100);
        disp.getChildren().addAll(Nameline);
        
        Pane.setCenter(disp);
        
        return scene;
        
    }
    
}
