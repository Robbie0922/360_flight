/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg360_2;

import javax.swing.JOptionPane;
import java.util.*;

/**
 *
 * @author Abdul
 */
public class Plane {

    private String date;
    private int seats;      // number of seats
    private Passenger[] list;   // array to keep check of how many seats are booked
    private String flightName;        // flight number
    private String depart, arrive; // departure and arrival times
    private String locTo, locFrom;  // locations to and from
    private int[] tickets = {4, 10,20}; // number of remaining seats
    private HashMap<Integer, Passenger> ticketList;  //map containing all tickets
    private double fcost;       // flight cost

    public Plane(String date, String fname, String depart, String arrive, String locTo, String locFrom) {
        this.date = date;
        this.seats = 34;
        this.flightName = fname;
        this.depart = depart;
        this.arrive = arrive;
        this.locTo = locTo;
        this.locFrom = locFrom;
        list = new Passenger[seats];
        ticketList = new HashMap();
    }

    public boolean airplaneFull() throws AllTicketSoldException{
        //if there are more than 0 seats return true
        if(tickets[2] <= 0){
        throw new AllTicketSoldException(tickets[2]); 
        }else{
        return (tickets[2] > 0);
        }
        
    }

    public String getOpenSeats(int window, char type) {
        int max = 1, min = 0;
        String r = "Choose open seat: ";
        switch (type) {
            case 'E':
                max = list.length;
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
        }
        for (int i = min; i < max; i++) {
            if (list[i] == null && i % 2 == window) {
                r += i + ", ";
            }
        }

        if (r.equals("Choose open seat: ")) {
            return "no seat available";
        }

        return r;
    }

    public String getTakenSeats() {
        String total = "";
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                total += list[i].getSeat() + ", ";
            }
        }
        return total;
    }

    public void setseat(int seatNum, Passenger p) {
        ticketList.put(seatNum, p);
        list[seatNum] = p;
        switch (p.getType()) {
            case 'E':
                tickets[2]--;
                break;
            case 'B':
                tickets[1]--;
                break;
            case 'F':
                tickets[0]--;
                break;
        }
    }

    public void returnTicket(int seat) {
        if (ticketList.containsKey(seat)) {
            Passenger p = ticketList.remove(seat);
            list[seat] = null;
            switch (p.getType()) {
                case 'E':
                    tickets[2]++;
                    break;
                case 'B':
                    tickets[1]++;
                    break;
                case 'F':
                    tickets[0]++;
                    break;
            }
           printTicket(p);
        }

    }

    public void printTicket(Passenger newFlyer) {
        if (newFlyer.getFlyerType().equalsIgnoreCase("economy")) {
            EconomyTicket ticket = new EconomyTicket(this, newFlyer);
        } else if (newFlyer.getFlyerType().equalsIgnoreCase("Business")) {
            BusinessTicket ticket = new BusinessTicket(this, newFlyer);
        } else if (newFlyer.getFlyerType().equalsIgnoreCase("First Class")) {
            FirstClassTicket ticket = new FirstClassTicket(this, newFlyer);
        }
    }

    @Override
    public String toString(){
    String x = System.lineSeparator();
        String ticket = "Flight: " + this.getFlightName() + x + "------------------------------------------------------------"+x;
        ticket += "Date: " + this.getDate() + x;
        ticket += "Departing from: " + this.getLocFrom() + " at " + this.getDepart() + x;
        ticket += "Traveling to: " + this.getLocTo() + " at " + this.getArrive() + x;
        return ticket;
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

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    public int getTickets() {
        return tickets[2];
    }

}
