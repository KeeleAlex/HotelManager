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
import javafx.scene.control.ComboBox;
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
List<Object> inputfield = new ArrayList();
public ObservableList<Customer> customers = FXCollections.observableArrayList();
Label disp = new Label();
public ObservableList<Booking> bookings = FXCollections.observableArrayList();
TableView<Customer> custs = new TableView();
TableView<Booking> bookT = new TableView();
TableView<Room> hoTable = new TableView();
public ObservableList<Room> rooms;
List<String> roomtypes = new ArrayList();


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
        rooms = loadHotel();
        TabPane tabs = new TabPane();
        tabs.setPrefSize(window.getWidth(), window.getHeight());
        Pane.getChildren().add(tabs);
        Tab p1 = new Tab("New Customer");
        Tab p2 = new Tab("Customers");
        Tab p3 = new Tab("Bookings");
        Tab p4 = new Tab("Hotel Rooms");
        p1.setClosable(false);
        p2.setClosable(false);
        p3.setClosable(false);
        p4.setClosable(false);
        
        //creating the room types
        roomtypes.add("Single");
        roomtypes.add("Twin");
        roomtypes.add("King Bed");
        roomtypes.add("Three person");
        roomtypes.add("Four person");
        roomtypes.add("Five person");
        roomtypes.add("Six person");
        
        
        p1.setContent(window1());
        
        p2.setContent(customerTable());
        
        p3.setContent(bookingTable());
        
        p4.setContent(hotelTable(window));
        
        tabs.getTabs().addAll(p1, p2, p3, p4);
        

        
        
    }
    
    private BorderPane window1() {
        //Building Window
        BorderPane BPane = new BorderPane();
        HBox scrn = new HBox();
        VBox input = new VBox();
        VBox display = new VBox();        
        
        
        
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
                inBox("Room Type", roomtypes)
        );
        
        Button action = new Button("Action");
        action.setOnAction(e -> {
            newCustomer();
            hoTable.refresh();
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
        inputfield.add(Tfield);
        return line;
    }
    
    private HBox inBox(String in, List<String> options){
       ComboBox CB = new ComboBox();
       for(String x : options){ 
       CB.getItems().add(x);
       }
        //creates an Hbox with a textbox to input data and a label to represent what should be written in the box
        String input = in;
        HBox line = new HBox();
        //the label at the start of the line
        Label label = new Label(in + ": ");
        //the texfield to go after the label
        //setting the prompt text in the text field 
        CB.setPromptText("Input " + in);
        CB.setId(in);
        line.getChildren().addAll(label, CB);
        inputfield.add(CB);
        return line;
    }
    
    private String get(String what){
        //iterates through the list of input text boxes, and returns the data in the txt box that matches whats put in get(). e.g:
        //get("Name") will return what's in the input box defined as "Name" in the inLine() method
        
        for(Object data: inputfield){
            TextField x;
            ComboBox y;
            //casting the input object to a textfield
            try{
                x = (TextField)data;
                
                if(what.equals(x.getId())){
                System.out.println(x.getText());
                return x.getText();
                
            }
            //casting it to a comboBox if it's not a textfield 
            }catch(ClassCastException e){
                y = (ComboBox<String>)data;               
                if(what.equals(y.getId())){
                 System.out.println(y.getValue());
                return (String)y.getValue();
                
            }
            }
        }
        return "Not Found";
    }
    
    private TableView<Customer> customerTable(){  
        
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
        custs.setOnMouseClicked(e -> {
        Checkout(custs, bookT, hoTable);
        
        });
        return custs;
    }
    
    private TableView<Booking> bookingTable()  {
        
        TableColumn<Booking, Integer> CustID = new TableColumn<>("Customer ID");
        CustID.setPrefWidth(100);
        CustID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        
        TableColumn<Booking, Integer> RoomID = new TableColumn<>("Room ID");
        RoomID.setCellValueFactory(new PropertyValueFactory<>("RoomID"));
        
        TableColumn<Booking, Integer> occ = new TableColumn<>("Number of Occupants");
        occ.setPrefWidth(200);
        occ.setCellValueFactory(new PropertyValueFactory<>("occupants"));
        
        bookT.getColumns().addAll(CustID, RoomID, occ);
        bookT.setItems(bookings);
        return bookT;
    }
    
    private TableView<Room> hotelTable(Stage window) {
        
        
        //Columns
        TableColumn<Room, Integer> roomid = new TableColumn<>("Room ID");
        roomid.setPrefWidth(150);
        roomid.setCellValueFactory(new PropertyValueFactory<>("Roomid"));
        
        TableColumn<Room, Integer> custid = new TableColumn<>("Customer ID");
        custid.setPrefWidth(150);
        custid.setCellValueFactory(new PropertyValueFactory<>("Customerid"));
        
        TableColumn<Room, Integer> type = new TableColumn<>("Type");
        type.setPrefWidth(150);
        type.setCellValueFactory(new PropertyValueFactory<>("Type"));
        
        TableColumn<Room, Boolean> checked = new TableColumn<>("Checked in");
        checked.setPrefWidth(150);
        checked.setCellValueFactory(new PropertyValueFactory<>("CheckedIn"));
        
        TableColumn<Room, Double> price = new TableColumn<>("Price");
        price.setPrefWidth(150);
        price.setCellValueFactory(new PropertyValueFactory<>("Price"));
        
        hoTable.getColumns().addAll(roomid, custid, type, checked, price);
        
        hoTable.setItems(rooms);
        
        hoTable.setMaxSize(window.getWidth(), window.getHeight()-60);
        return hoTable;
    }
    
    private ObservableList<Room> loadHotel() {
        hotelFactory build = new hotelFactory();
        
        return build.hotelFactory();
    }
    
    private void newCustomer() {
        
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
            cust.setType(get("Room Type"));
            customers.add(cust);
            disp.setText(cust.toString());
            
            Booking book = new Booking(cust, cust.getOccupants(), rooms);
            
            
            bookings.add(book);
            
            //troubleshooting loops
            /*for(TextField i: inputs){
            System.out.println(i.getId());
            }
            
            
            for(int i = 0; i< customers.size(); i++){
            System.out.println(customers.get(i));
            }
            */
        
    }
    
    private void Checkout(TableView custs, TableView book, TableView rooms){
        Customer larry = (Customer) custs.getSelectionModel().getSelectedItem();
        larry.getRoomnumber();
        
    }
}
