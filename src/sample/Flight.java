package sample;

import java.util.*;
import java.text.*;

public class Flight {

    private int seats;
    private int[] flight;
    private int num;
    private String depart, arrive;
    private String locTo, locFrom;
    private int tickets;



    public Flight(int seats, int num, String depart, String arrive, String locTo, String locFrom) {

        this.seats = seats;
        this.num = num;
        this.depart = depart;
        this.arrive = arrive;
        this.locTo = locTo;
        this.locFrom = locFrom;
        this.tickets = seats;
        flight = new int[seats];
        for (int i = 1; i < seats; i++) {
            flight[i] = 0;
        }

    }

    public boolean planeFull() {

        for (int i = 1; i < seats; i++) {
            if (this.flight[i] != 1)
                return false;

        }

        return true;

    }


    public void reserveUnitedTicket(int seat) throws TicketsSoldOutError {

        if (!planeFull()) { //this is the condition for if their ticket is available
            if (getSeat(seat) == 0) {
                System.out.println("\nYou have booked Seat #" + seat + " for flight " + this.getNum() +
                        " Leaving at " + this.getDepart() + " from " + this.getFrom() +
                        "\nArriving at " + this.getArrive() + " to " + this.getTo() + "\n");
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


        public int getSeats () {
            return this.seats;
        }

        public int getSeat ( int seat){
            return flight[seat];
        }

    }
