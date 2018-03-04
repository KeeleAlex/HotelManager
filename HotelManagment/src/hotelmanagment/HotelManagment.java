/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagment;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HotelManagment extends Application{
List<TextField> inputs = new ArrayList();
List<Customer> customers = new ArrayList();

    public static void main(String[] args) {
        launch(args);        
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage window = primaryStage;
        Scene scene;
        Pane Pane = new Pane();
        scene = new Scene(Pane);
        TabPane tabs = new TabPane();
        Pane.getChildren().add(tabs);
        Tab p1 = new Tab("New Customer");
        p1.setClosable(false);

        p1.setContent(window1());
        
        tabs.getTabs().add(p1);
        
        window.setScene(scene);
        
        window.show();     
    }
    
    private BorderPane window1(){
        //Building Window
        BorderPane BPane = new BorderPane();
        VBox input = new VBox();
        
        
        //putting it on the window
        BPane.setCenter(input);
        input.setMinSize(200, 100);
        input.getChildren().addAll(
                inLine("Name"), 
                inLine("Phone Number"),
                inLine("Email"),
                inLine("House Number"),
                inLine("Road Name"),
                inLine("Town"),
                inLine("County"),
                inLine("Post Code"),
                inLine("Group size")
        );
        
        Button action = new Button("Action");
        action.setOnAction(e -> {
            Customer cust = new Customer();
            cust.setID(customers.size() + 1);
            cust.setName(get("Name"));
            cust.setEmail(get("Email"));
            cust.setPhonenumber(get("Phone Number"));
            cust.setOccupants(get("Group size"));
            cust.setHousenumber(get("House Number"));
            cust.setRoadname(get("Road Name"));
            cust.setTown(get("Town"));
            cust.setCounty(get("County"));
            cust.setPostcode(get("Post Code"));
            customers.add(cust);
            System.out.println(cust.toString());
            
            //troubleshooting loops
            /*for(TextField i: inputs){
            System.out.println(i.getId());
            }
            
            
            for(int i = 0; i< customers.size(); i++){
            System.out.println(customers.get(i));
            }
            */
        });
        
        
        input.getChildren().add(action);
        
        return BPane;
        
    }
    
    private HBox inLine(String in){
        String input = in;
        HBox line = new HBox();
        Label label = new Label(in + ": ");
        TextField Tfield = new TextField();
        Tfield.setPromptText("Input " + in);
        Tfield.setId(in);
        line.getChildren().addAll(label, Tfield);
        inputs.add(Tfield);
        return line;
    }
    
    private String get(String what){
        
        for(TextField data: inputs){
            if(what.equals(data.getId())){
                //System.out.println(what +" == "+ data.getId());
                return data.getText();
                
            }
            /*else{
            System.out.println(what +" != "+ data.getId());
            }*/
        }
        return "Not Found";
    }
    
}
