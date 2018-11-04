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
public class FirstClassTicket extends Ticketing{
     public FirstClassTicket(Plane plane, Passenger p) {
        super(plane, p);
        String x = System.lineSeparator();
        String ticket = super.printTicket();
        ticket+="Snack Choice: "+p.getSnack()+x;
        ticket+="Reserved Taxi: "+p.getTaxi()+x;
        JOptionPane.showMessageDialog(null, ticket);
    }
}
