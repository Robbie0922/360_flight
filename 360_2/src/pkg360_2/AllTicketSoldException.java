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
public class AllTicketSoldException extends Exception{
    
    private int seats;
    public AllTicketSoldException(int num) {
        seats = num;
    }
    public String close(Plane e){
        String r ="Is Sold Out"+System.lineSeparator();
    return e.toString()+r;
    }
 
    
}
