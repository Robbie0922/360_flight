package sample;

import java.util.*;
import java.text.*;

public class Flight extends Passenger {

    private int seats;      // number of seats
    private int[] flight;   // array to keep check of how many seats are booked
    private int num;        // flight number
    private String depart, arrive; // departure and arrival times
    private String locTo, locFrom;  // locations to and from
    private int tickets;
    private double fcost;       // flight cost



    public Flight(int seats, int num, String depart, String arrive, String locTo, String locFrom, String name, char fclass, double fcost) {
        super(name, fclass);

        this.seats = seats;
        this.num = num;
        this.depart = depart;
        this.arrive = arrive;
        this.locTo = locTo;
        this.locFrom = locFrom;
        this.fcost = fcost;
        this.tickets = seats;
        flight = new int[seats];
        for (int i = 1; i < seats; i++) {
            flight[i] = 0;
        }

    }

    // check if plane is full
    public boolean planeFull() {

        for (int i = 1; i < seats; i++) {
            if (this.flight[i] != 1)
                return false;

        }

        return true;

    }

    // book seats and tell if seat is booked or flight is full
    public void reserveUnitedTicket(int seat) throws TicketsSoldOutError {

        if (!planeFull()) { //this is the condition for if their ticket is available
            if (getSeat(seat) == 0) {
                System.out.println("\nConfirmation for: " + getName() + " \nFor flight " + this.getNum() +
                        "\nLeaving at " + this.getDepart() + " from " + this.getFrom() +
                        "\nArriving at " + this.getArrive() + " to " + this.getTo() + "\nTicket price is " + this.getCost());
                this.bookSeat(seat);
            } else {
                throw new TicketsSoldOutError("\nSeat # " + seat + " for flight " + this.getNum() +
                        " Leaving at " + this.getDepart() + " from " + this.getFrom() +
                        "\nArriving at " + this.getArrive() + " to " + this.getTo() + "\nIS NOT AVAILABLE.\n");

            }
        }
            else
            {  //this is where the exception will be thrown because the seat is not available for their given time, uses all of the set variables

                throw new TicketsSoldOutError("\nThere are currently no seats available for flight " + this.getNum() +
                        " Leaving at " + this.getDepart() + " from " + this.getFrom() +
                        "\nArriving at " + this.getArrive() + " to " + this.getTo() + "\n");

            }

    }

        // if array location = 1 then seat is takes. Increment if location is set to 1
        public void bookSeat ( int seat){
            this.flight[seat] = 1;
            this.tickets--;
        }

        public int getNum () {
            return num;
        }

        public String getDepart () {
            return depart;
        }

        public String getArrive () {
            return arrive;
        }

        public String getTo () {
            return locTo;
        }

        public String getFrom () {
            return locFrom;
        }

        public String getEconomy () {
            return "Choose 0, 1, 2, 3";
        }

        public String getBusiness() {
            return "Choose 4, 5, 6, 7, 8, 9, 10, 11, 12, 13";
        }
        public String getFirst() {
            return "Choose 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29";
        }

        public int getSeats () {
            return this.seats;
        }

        public double getCost () {
        return this.fcost;
    }

        public int getSeat ( int seat){
            return flight[seat];
        }


    }
