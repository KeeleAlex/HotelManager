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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HotelManagment extends Application{
List<TextField> inputs = new ArrayList();
static ObservableList<Customer> customers = FXCollections.observableArrayList();
TableView<Customer> custTable = new TableView();
static ObservableList<Booking> bookings = FXCollections.observableArrayList();
Hotel hotel = new Hotel();
static ObservableList<Room> rooms = FXCollections.observableArrayList();

    public static void main(String[] args) {
        launch(args);        
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage window = primaryStage;
        window.setMaximized(true);
        Scene scene;
        Pane Pane = new Pane();
        Pane.setId("Pane");
        scene = new Scene(Pane);        
        window.setScene(scene);
        window.show();
        
        TabPane tabs = new TabPane();
        tabs.setPrefSize(window.getWidth(), window.getHeight());
        System.out.println(Pane.getWidth()+ " / " + Pane.getHeight());

        Pane.getChildren().add(tabs);
        Tab p1 = new Tab("New Customer");
        Tab p2 = new Tab("Customers");
        Tab p3 = new Tab("Bookings");
        Tab p4 = new Tab("Hotel Rooms");
        p1.setClosable(false);
        p2.setClosable(false);
        p3.setClosable(false);
        p4.setClosable(false);

        p1.setContent(window1());
        
        p2.setContent(customerTable());
        custTable.setPrefSize(Pane.getWidth(), Pane.getHeight());
        
        //p3
        System.out.println(hotel.print(hotel.Rooms));
        
        p4.setContent(hotelTable());
        
        tabs.getTabs().addAll(p1, p2, p3, p4);
        
        
        
    }
    
    private BorderPane window1() {
        //Building Window
        BorderPane BPane = new BorderPane();
        HBox scrn = new HBox();
        VBox input = new VBox();
        VBox display = new VBox();
        Label disp = new Label();
        
        display.getChildren().add(disp);
        scrn.getChildren().addAll(input, display);
        //putting it on the window
        BPane.setCenter(scrn);
        /*input.setMinSize(200, 100);
        display.setMinSize(300, 200);*/
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
            cust.setHousenumber(get("House Number"));
            cust.setRoadname(get("Road Name"));
            cust.setTown(get("Town"));
            cust.setCounty(get("County"));
            cust.setPostcode(get("Post Code"));
            cust.setOccupants(get("Group size"));
            customers.add(cust);
            disp.setText(cust.toString());
            
            Booking book = new Booking(cust.getID(), cust.getOccupants(), hotel);
            
            //troubleshooting loops
            /*for(TextField i: inputs){
            System.out.println(i.getId());
            }
            
            
            for(int i = 0; i< customers.size(); i++){
            System.out.println(customers.get(i));
            }
            */
        });//end of button actions
        
        
        input.getChildren().add(action);
        
        return BPane;
        
    }
    
    private HBox inLine(String in){
        //creates an Hbox with a textbox to input data and a label to represent what should be written in the box
        String input = in;
        HBox line = new HBox();
        //the label at the start of the line
        Label label = new Label(in + ": ");
        //the texfield to go after the label
        TextField Tfield = new TextField();
        //setting the prompt text in the text field 
        Tfield.setPromptText("Input " + in);
        Tfield.setId(in);
        line.getChildren().addAll(label, Tfield);
        inputs.add(Tfield);
        return line;
    }
    
    private String get(String what){
        //iterates through the list of input text boxes, and returns the data in the txt box that matches whats put in get(). e.g:
        //get("Name") will return what's in the input box defined as "Name" in the inLine() method
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
    
    private TableView<Customer> customerTable(){
        TableView<Customer> custs = new TableView();
        
        //columns
        TableColumn<Customer, Integer> ID = new TableColumn<>("ID");
        ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        
        TableColumn<Customer, String> name = new TableColumn<>("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        
        TableColumn<Customer, String> address = new TableColumn<>("Address");
        address.setPrefWidth(150);
        address.setCellValueFactory(new PropertyValueFactory<>("Address"));
        
        TableColumn<Customer, String> number = new TableColumn<>("Phone Number");
        number.setPrefWidth(150);
        number.setCellValueFactory(new PropertyValueFactory<>("Phonenumber"));
        
        TableColumn<Customer, String> email = new TableColumn<>("Email");
        email.setPrefWidth(150);
        email.setCellValueFactory(new PropertyValueFactory<>("Email"));
        
        TableColumn<Customer, String> Rn = new TableColumn<>("Room Number");
        Rn.setPrefWidth(100);
        Rn.setCellValueFactory(new PropertyValueFactory<>("Roomnumber"));
        
        TableColumn<Customer, String> occ = new TableColumn<>("Occupants");
        occ.setCellValueFactory(new PropertyValueFactory<>("Occupants"));
        
        
        custs.getColumns().addAll(ID, name, address, number, email, Rn, occ);
        custs.setItems(customers);
        return custs;
    }
    
    private TableView<Room> hotelTable() {
        TableView<Room> hotelTable = new TableView();
        rooms = hotel.Rooms;
        //Columns
        TableColumn<Room, Integer> roomid = new TableColumn<>("Room ID");
        roomid.setPrefWidth(150);
        roomid.setCellValueFactory(new PropertyValueFactory<>("Roomid"));
        
        TableColumn<Room, Integer> custid = new TableColumn<>("Customer ID");
        custid.setPrefWidth(150);
        custid.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        
        TableColumn<Room, Integer> cap = new TableColumn<>("Capacity");
        cap.setPrefWidth(150);
        cap.setCellValueFactory(new PropertyValueFactory<>("Capacity"));
        
        TableColumn<Room, Boolean> dis = new TableColumn<>("Disabled Access");
        dis.setPrefWidth(150);
        dis.setCellValueFactory(new PropertyValueFactory<>("Disabled"));
        
        TableColumn<Room, Boolean> checked = new TableColumn<>("Checked in");
        checked.setPrefWidth(150);
        checked.setCellValueFactory(new PropertyValueFactory<>("CheckedIn"));
        
        TableColumn<Room, Double> price = new TableColumn<>("Price");
        price.setPrefWidth(150);
        price.setCellValueFactory(new PropertyValueFactory<>("Price"));
        
        hotelTable.getColumns().addAll(roomid, custid, cap, dis, checked, price);
        
        hotelTable.setItems(rooms);
        return hotelTable;
    }
}
