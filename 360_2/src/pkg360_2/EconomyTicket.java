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
public class EconomyTicket extends Ticketing {
    
    public EconomyTicket(Plane plane, Passenger p) {
        super(plane, p);
        String ticket= super.printTicket();
        JOptionPane.showMessageDialog(null, ticket);
    }
    

    
    
}
