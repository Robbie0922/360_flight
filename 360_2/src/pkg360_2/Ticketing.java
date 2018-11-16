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
public class Ticketing {
    Plane r;
    Passenger p;

    public Ticketing(Plane plane, Passenger p) {
        this.r = plane;
        this.p = p;
    }

    public String printTicket() {
        String x = System.lineSeparator();
        String ticket = "Flight Ticket" + x + "------------------------------------------------------------"+x;

        ticket += "name: " + p.getName() + x;
        ticket += "Date: " + r.getDate() + x;
        ticket += "Flyer Type: " + p.getFlyerType() + x;
        ticket += "Flight: " + r.getFlightName() + x;
        ticket += "Depart from: " + r.getLocFrom() + " at " + r.getDepart() + x;
        ticket += "Arrive to: " + r.getLocTo() + " at " + r.getArrive() + x;
        ticket += "Cost of ticket: " + p.getCost() + x;
        ticket += "Seat number: " + p.getSeat() + x;
        return ticket;
    }

}
