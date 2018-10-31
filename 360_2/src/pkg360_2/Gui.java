/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg360_2;

import java.util.ArrayList;
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

    private ArrayList<Plane> list = new ArrayList<>();
    private String flight, flights = "Current flights: ";
    private Passenger jack;
    private String n, f;
    private Button exit;
    private Button viewAll;
    private Button addFlight;
    private Button addPassenger;
    private Button viewFlight;
    private TextField Tname;
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

        HBox HBox = new HBox(viewAll, addFlight, addPassenger, exit);
        HBox.setAlignment(Pos.CENTER);

        pane.setCenter(HBox);

        viewAll.setOnAction(this);
        exit.setOnAction(this);
        addFlight.setOnAction(this);
        addPassenger.setOnAction(this);

        scene = new Scene(pane);
        stage1.setScene(scene);
        stage1.setTitle("American Airlines");
        stage1.show();

    }

    void start() {

        launch();
    }

    @Override
    public void handle(Event e) {
        Button b = (Button) e.getSource();
        if (b.getText().equals("Exit")) {
            System.exit(-1);
        } else if (b.getText().equals("View")) {
            veiwAll();
        } else if (b.getText().equals("Add Flight")) {
            addNewFlight();
        } else if (b.getText().equals("Add Passenger")) {
            flight = JOptionPane.showInputDialog(null, flights);
            while (!flights.contains(flight)) {
                JOptionPane.showMessageDialog(null, "invalid input", "Error", JOptionPane.ERROR_MESSAGE);
                flight = JOptionPane.showInputDialog(null, "choose from the list of " + flights);
            }
            n = JOptionPane.showInputDialog(null, "What type of seating do you want to fly? Economy, Business, or First Class");
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
        Label number = new Label("Flight Number");
        Label STime = new Label("Take-off Time");
        Label LTime = new Label("Landing Time");
        Label SLoc = new Label("Starting Location");
        Label ELoc = new Label("Ending Location");

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
        gridPane.add(STime, 0, 3);
        gridPane.add(TSTime, 1, 3);
        gridPane.add(LTime, 0, 4);
        gridPane.add(TLTime, 1, 4);
        gridPane.add(SLoc, 0, 5);
        gridPane.add(TSLoc, 1, 5);
        gridPane.add(ELoc, 0, 6);
        gridPane.add(TELoc, 1, 6);

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
        Plane g = new Plane(Tnumber.getText(), TSTime.getText(), TLTime.getText(), TSLoc.getText(), TELoc.getText());
        list.add(g);
        flights += Tnumber.getText() + "; ";
    }

    public void addNewPassenger() {

        Label name = new Label("Name");
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
         Plane r = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getFlightName().equalsIgnoreCase(flight)) {
                r = list.get(i);
            }
        }
//      create passenger object
        jack = new Passenger(Tname.getText(), n.charAt(0), TWindow.getText().charAt(0));
        String p = "E";
        if (n.charAt(0) == 'f' || n.charAt(0) == 'F') {
            jack.setSnack(TSnacks.getText().charAt(0));
            jack.setTaxi(TTaxi.getText().charAt(0));
            p = "F";
        } else if (n.charAt(0) == 'b' || n.charAt(0) == 'B') {
            jack.setSnack(TSnacks.getText().charAt(0));
            p = "B";
        }
         
        f = JOptionPane.showInputDialog(null, "Choose your seat from the following List: " + r.getOpenSeats(jack.getWindow(), jack.getType()));
        while (!r.getOpenSeats(jack.getWindow(), jack.getType()).contains(f)) {
             JOptionPane.showMessageDialog(null, "Seat is unavailable", "Error", JOptionPane.ERROR_MESSAGE);
            f = JOptionPane.showInputDialog(null, "Choose your seat from the following List: " + r.getOpenSeats(jack.getWindow(), jack.getType()));
        }
        r.setseat(Integer.parseInt(f), jack);
        jack.setFlight(flight);

//        print ticket
    }

    public void preSet() {
        Plane k = new Plane("310", "8:00 AM", "9:30 AM", "GreensBoro", "Newark");
        Plane g = new Plane("320", "1:59 PM", "3:29 PM", "Newark", "GreensBoro");
        list.add(g);
        list.add(k);
        flights += "310, 320, ";
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
