/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg360_2;

/**
 *
 * @author Abdul
 */
public class Passenger {

    private String name;       // full name 
    private char type;        //type of seating FirstClass, Business, or coach
    private double cost;      //cost of ticket
    private int seat;         //seat number
    private Boolean taxi;
    private String snack;
    private int window = 0;
    private String flight;

    public Passenger(String name, char type, char w) {
        this.name = name;
        setType(type);
        if (w == 'n' || w == 'N') {
            window = 1;
        }
        Cost(type);
    }

    public String getFlyerType() {
        String flyerType = "";

        switch (type) {
            case 'E':
                flyerType = "economy";
                break;
            case 'B':
                flyerType = "Business";
                break;
            case 'F':
                flyerType = "First Class";
                break;
        }
        return flyerType;
    }

    // Get cost of tickets based on class chosen
    public void Cost(char type) {
        setType(type);
        type = getType();
        switch (type) {
            case 'E':
                setCost(300);
                break;
            case 'B':
                setCost(300 + (300 * .50));
                break;
            case 'F':
                setCost((300 + (300 * .50)) * 2);
                break;

        }

    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the type
     */
    public char getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(char type) {
        char t = type;
        switch (type) {
            case 'e':
                t = 'E';
                break;
            case 'b':
                t = 'B';
                break;
            case 'f':
                t = 'F';
                break;
            default:
                t = t;
                break;
        }
        this.type = t;
    }

    /**
     * @return the cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * @return the seat
     */
    public int getSeat() {
        return seat;
    }

    /**
     * @param seat the seat to set
     */
    public void setSeat(int seat) {
        this.seat = seat;
    }

    /**
     * @return the taxi
     */
    public Boolean getTaxi() {
        return taxi;
    }

    /**
     * @param taxi the taxi to set
     */
    public void setTaxi(char t) {
        if (t == 'y' || t == 'Y') {
            this.taxi = true;
        } else {
            this.taxi = false;
        }

    }

    /**
     * @return the snack
     */
    public String getSnack() {
        return snack;
    }

    /**
     * @param snack the snack to set
     */
    public void setSnack(char s) {
        if (s == 'p') {
            this.snack = "peanuts";
        } else {
            this.snack = "cookies";
        }

    }

    /**
     * @return the window
     */
    public int getWindow() {
        return window;
    }

    /**
     * @param window the window to set
     */
    public void setWindow(int window) {
        this.window = window;
    }

    /**
     * @return the flight
     */
    public String getFlight() {
        return flight;
    }

    /**
     * @param flight the flight to set
     */
    public void setFlight(String flight) {
        this.flight = flight;
    }

}
