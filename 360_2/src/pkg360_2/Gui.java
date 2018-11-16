/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg360_2;

import java.util.*;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Abdul
 */
public class Gui extends Application implements EventHandler {

    private HashMap<String, Plane> list = new HashMap();
    private ArrayList<String> flightList = new ArrayList();
    private String flight, flights = "Current flights: ";
    private Passenger newFlyer;
    private String n, f;
    private Button exit;
    private Button viewAll;
    private Button addFlight;
    private Button addPassenger;
    private Button returnTicket;
    private TextField Tname;
    private TextField Tdate;
    private TextField TSnacks;
    private TextField TTaxi;
    private TextField TWindow;
    private TextField Tnumber;
    private TextField TSTime;
    private TextField TLTime;
    private TextField TSLoc;
    private TextField TELoc;
    private BorderPane pane;
    private Scene scene;
    Stage stage1;

    @Override
    public void start(Stage primaryStage) throws Exception {
        preSet();
        stage1 = primaryStage;
        pane = new BorderPane();
        exit = new Button("Exit");
        addFlight = new Button("Add Flight");
        addPassenger = new Button("Add Passenger");
        viewAll = new Button("View");
        returnTicket = new Button("Return Ticket");

        HBox HBox = new HBox(viewAll, addFlight, addPassenger, returnTicket, exit);
        HBox.setAlignment(Pos.CENTER);

        pane.setCenter(HBox);

        viewAll.setOnAction(this);
        exit.setOnAction(this);
        addFlight.setOnAction(this);
        addPassenger.setOnAction(this);
        returnTicket.setOnAction(this);

        scene = new Scene(pane);
        stage1.setScene(scene);
        stage1.setTitle("American Airlines");
        stage1.show();

    }

    void start() {

        launch();
    }

    public String selectFlight() {
        flight = JOptionPane.showInputDialog(null, flights);
        while (!flightList.contains(flight)) {
            JOptionPane.showMessageDialog(null, "invalid input", "Error", JOptionPane.ERROR_MESSAGE);
            flight = JOptionPane.showInputDialog(null, "choose from the list of " + flights);
        }
        return flight;
    }

    @Override
    public void handle(Event e) {
        Button b = (Button) e.getSource();
        if (b.getText().equals("Exit")) {
            System.exit(-1);
        } else if (b.getText().equals("Return Ticket")) {
            Plane f = list.get(selectFlight());
            if(f.getTickets()>=20){
            JOptionPane.showMessageDialog(null, "This flight has no taken seats", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
            String s = JOptionPane.showInputDialog(null, "Select passenger to remove " + f.getTakenSeats());
            f.returnTicket(Integer.parseInt(s));
            JOptionPane.showMessageDialog(null, "Ticket has been Removed");
            }
            
        } else if (b.getText().equals("View")) {
            veiwAll();
        } else if (b.getText().equals("Add Flight")) {
            addNewFlight();
        } else if (b.getText().equals("Add Passenger")) {
            selectFlight();
            while(!list.get(flight).airplaneFull()){
            JOptionPane.showMessageDialog(null, "This Flight is full", "Error", JOptionPane.ERROR_MESSAGE);
            selectFlight();
            }
            n = "E";
            //n = JOptionPane.showInputDialog(null, "What type of seating do you want to fly? Economy, Business, or First Class");
            while (checkChar(n.charAt(0)) == false) {
                JOptionPane.showMessageDialog(null, "unavailable input", "Error", JOptionPane.ERROR_MESSAGE);
                n = JOptionPane.showInputDialog(null, "Error: choose Economy, Business, or First Class");
            }
            addNewPassenger();
        } else if (b.getText().equals("Done")) {
            setFlightData();
            stage1.setScene(scene);
        } else if (b.getText().equals("Go Back")) {
            stage1.setScene(scene);
            stage1.setTitle("American Airlines");
        } else if (b.getText().equals("choose seat")) {
            ChooseSeat();
            stage1.setScene(scene);
            stage1.setTitle("American Airlines");
        }

    }

    public void veiwAll() {

        Label all = new Label(flights);
        TextField t = new TextField();
        Button btn = new Button("more Info");
        Button btn2 = new Button("Go Back");

        BorderPane p = new BorderPane();
        HBox hBox = new HBox(t, btn, btn2);
        hBox.setSpacing(15);

        btn.setOnAction(this);
        btn2.setOnAction(this);
        p.setMinSize(230, 200);
        p.setBottom(hBox);
        p.setTop(all);

        Scene scene5 = new Scene(p);
        stage1.setScene(scene5);
        stage1.setTitle("Flight Log");
        stage1.show();

    }

    public void addNewFlight() {
        //seats, number, flight time, to, from 
        Label date = new Label("Date");
        Label number = new Label("Flight Number");
        Label STime = new Label("Take-off Time");
        Label LTime = new Label("Landing Time");
        Label SLoc = new Label("Starting Location");
        Label ELoc = new Label("Ending Location");

        Tdate = new TextField();
        Tnumber = new TextField();
        TSTime = new TextField();
        TLTime = new TextField();
        TSLoc = new TextField();
        TELoc = new TextField();

        Button btn = new Button("Done");
        Button btn2 = new Button("Go Back");

        GridPane gridPane = new GridPane();
        Insets inset = new Insets(12, 12, 12, 12);
        gridPane.setPadding(inset);

        gridPane.add(number, 0, 2);
        gridPane.add(Tnumber, 1, 2);
        gridPane.add(date, 0, 3);
        gridPane.add(Tdate, 1, 3);
        gridPane.add(STime, 0, 4);
        gridPane.add(TSTime, 1, 4);
        gridPane.add(LTime, 0, 5);
        gridPane.add(TLTime, 1, 5);
        gridPane.add(SLoc, 0, 6);
        gridPane.add(TSLoc, 1, 6);
        gridPane.add(ELoc, 0, 7);
        gridPane.add(TELoc, 1, 7);

        HBox hBox = new HBox(btn, btn2);
        hBox.setSpacing(15);
        gridPane.add(hBox, 1, 13);

        btn.setOnAction(this);
        btn2.setOnAction(this);
        gridPane.setMinSize(230, 200);

        Scene scene2 = new Scene(gridPane);
        stage1.setScene(scene2);
        stage1.setTitle("New Flight");
        stage1.show();

    }

    public void setFlightData() {
        Plane g = new Plane(Tdate.getText(), Tnumber.getText(), TSTime.getText(), TLTime.getText(), TELoc.getText(), TSLoc.getText());
        list.put(Tnumber.getText(), g);
        flights += Tnumber.getText() + ", ";
        flightList.add(Tnumber.getText());
    }

    public void addNewPassenger() {

        Label name = new Label("Full Name");
        Label Snacks = new Label("Snack choice");
        Label Taxi = new Label("Taxi");
        Label Window = new Label("Window Seat");
        Tname = new TextField();
        TSnacks = new TextField("Cookies or Peanuts");
        TTaxi = new TextField("Yes or No");
        TWindow = new TextField("Yes or No");

        GridPane grid = new GridPane();
        grid.add(name, 0, 0);
        grid.add(Tname, 1, 0);
        grid.add(Window, 0, 1);
        grid.add(TWindow, 1, 1);
        grid.add(Snacks, 0, 2);
        grid.add(TSnacks, 1, 2);
        grid.add(Taxi, 0, 3);
        grid.add(TTaxi, 1, 3);

        Button btn = new Button("choose seat");
        Button btn2 = new Button("Go Back");
        HBox hBox = new HBox(btn, btn2);
        hBox.setSpacing(15);
        grid.add(hBox, 1, 13);

        btn.setOnAction(this);
        btn2.setOnAction(this);
        grid.setMinSize(230, 200);

        Scene scene2 = new Scene(grid);
        stage1.setScene(scene2);
        stage1.setTitle("New Passenger");
        stage1.show();

        if (n.charAt(0) == 'e' || n.charAt(0) == 'E') {
            TSnacks.setDisable(true);
            TTaxi.setDisable(true);
        } else if (n.charAt(0) == 'b' || n.charAt(0) == 'B') {
            TTaxi.setDisable(true);
        }

    }

    public void ChooseSeat() {
        Plane currentPlane = list.get(flight);
//      create passenger object
        newFlyer = new Passenger(Tname.getText(), n.charAt(0), TWindow.getText().charAt(0));
        String p = "E";
        if (n.charAt(0) == 'f' || n.charAt(0) == 'F') {
            newFlyer.setSnack(TSnacks.getText().charAt(0));
            newFlyer.setTaxi(TTaxi.getText().charAt(0));
            p = "F";
        } else if (n.charAt(0) == 'b' || n.charAt(0) == 'B') {
            newFlyer.setSnack(TSnacks.getText().charAt(0));
            p = "B";
        }
        if (currentPlane.getOpenSeats(newFlyer.getWindow(), newFlyer.getType()).equals("no seat available")) {
            JOptionPane.showMessageDialog(null, "no seat is available, please change your parameters", "Error", JOptionPane.ERROR_MESSAGE);
            addNewPassenger();
        } else {
            f = JOptionPane.showInputDialog(null, "Choose your seat from the following List: " + currentPlane.getOpenSeats(newFlyer.getWindow(), newFlyer.getType()));
            while (!currentPlane.getOpenSeats(newFlyer.getWindow(), newFlyer.getType()).contains(f)) {
                JOptionPane.showMessageDialog(null, "Seat is unavailable", "Error", JOptionPane.ERROR_MESSAGE);
                f = JOptionPane.showInputDialog(null, "Choose your seat from the following List: " + currentPlane.getOpenSeats(newFlyer.getWindow(), newFlyer.getType()));
            }
            newFlyer.setSeat(Integer.parseInt(f));
            currentPlane.setseat(Integer.parseInt(f), newFlyer);
            newFlyer.setFlight(flight);

//        print ticket
            currentPlane.printTicket(newFlyer);
        }

    }

    public void preSet() {
        Plane k = new Plane("Dec. 6", "310", "7:00 AM", "9:30 AM", "GreensBoro", "Newark");
        Plane g = new Plane("Dec. 6", "320", "2:00 PM", "3:29 PM", "Newark", "GreensBoro");
        list.put(g.getFlightName(), g);
        list.put(k.getFlightName(), k);
        flights += "310, 320, ";
        flightList.add("310");
        flightList.add("320");
    }

    public boolean checkChar(char x) {
        switch (x) {
            case 'E':
                return true;
            case 'B':
                return true;
            case 'F':
                return true;
            case 'e':
                return true;
            case 'f':
                return true;
            case 'b':
                return true;
        }

        return false;
    }

}
