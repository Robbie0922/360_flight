/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg360_2;

import javax.swing.JOptionPane;

/**
 *
 * @author Abdul
 */
public class Plane {

    private int seats;      // number of seats
    private Passenger[] list;   // array to keep check of how many seats are booked
    private String flightName;        // flight number
    private String depart, arrive; // departure and arrival times
    private String locTo, locFrom;  // locations to and from
    private int tickets;           // number of remaining seats
    private double fcost;       // flight cost

    public Plane(String fname, String depart, String arrive, String locTo, String locFrom) {
        this.seats = 30;
        this.flightName = fname;
        this.depart = depart;
        this.arrive = arrive;
        this.locTo = locTo;
        this.locFrom = locFrom;
        this.tickets = seats;
        list = new Passenger[seats];
    }

    public String getOpenSeats(int window, char type) {
        int max = 1, min= 0;
        String r = "Choose open seat: ";
        switch (type) {
            case 'E':
                max = 30;
                min = 14;
                break;
            case 'B':
                max = 14;
                min = 4;
                break;
            case 'F':
                max = 4;
                min = 0;
                break;
            case 'e':
                max = 30;
                min = 14;
                break;
            case 'b':
                max = 14;
                min = 4;
                break;
            case 'f':
                max = 4;
                min = 0;
                break;
        }
        for (int i = min; i < max; i++) {
            if (list[i] == null && i % 2 == window) {
                r += i + ", ";
            }
        }

        return r;
    }

    public void setseat(int num, Passenger p) {
        list[num] = p;
        tickets--;
    }

    /**
     * @return the seats
     */
    public int getSeats() {
        return seats;
    }

    /**
     * @param seats the seats to set
     */
    public void setSeats(int seats) {
        this.seats = seats;
    }

    /**
     * @return the list
     */
    public Passenger[] getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(Passenger[] list) {
        this.list = list;
    }

    /**
     * @return the flightName
     */
    public String getFlightName() {
        return flightName;
    }

    /**
     * @param flightName the flightName to set
     */
    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    /**
     * @return the depart
     */
    public String getDepart() {
        return depart;
    }

    /**
     * @param depart the depart to set
     */
    public void setDepart(String depart) {
        this.depart = depart;
    }

    /**
     * @return the arrive
     */
    public String getArrive() {
        return arrive;
    }

    /**
     * @param arrive the arrive to set
     */
    public void setArrive(String arrive) {
        this.arrive = arrive;
    }

    /**
     * @return the locTo
     */
    public String getLocTo() {
        return locTo;
    }

    /**
     * @param locTo the locTo to set
     */
    public void setLocTo(String locTo) {
        this.locTo = locTo;
    }

    /**
     * @return the locFrom
     */
    public String getLocFrom() {
        return locFrom;
    }

    /**
     * @param locFrom the locFrom to set
     */
    public void setLocFrom(String locFrom) {
        this.locFrom = locFrom;
    }

    /**
     * @return the tickets
     */
    public int getTickets() {
        return tickets;
    }

    /**
     * @param tickets the tickets to set
     */
    public void setTickets(int tickets) {
        this.tickets = tickets;
    }

    /**
     * @return the fcost
     */
    public double getFcost() {
        return fcost;
    }

    /**
     * @param fcost the fcost to set
     */
    public void setFcost(double fcost) {
        this.fcost = fcost;
    }

}
