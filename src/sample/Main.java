
package sample;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception{

        //  Create movie objects
        Scanner keyboard = new Scanner(System.in);


        System.out.println("Enter your name how it is displayed on your Driver's License");
        String fname = keyboard.nextLine();
        System.out.println("Enter the class you desire. Type 'E' for caoch. 'B' for busines and 'F' for first class.");
        char fclass = keyboard.next().charAt(0);

        while(fclass != 'E' && fclass != 'B' && fclass != 'F'){  // keeps prompting if it is not 310 or 320

            System.out.println("Please enter either 'E', 'B' or 'F'");
            fclass = keyboard.next().charAt(0);

        }

        Passenger ps = new Passenger(fname, fclass);
        double cost = ps.Cost(fclass);
        int seat = ps.Seat(fclass);

        Flight flight_310 = new Flight(seat, 310, "8:00 AM", "9:30 AM", "Newark", "Greesnboro", fname, fclass, cost);
        Flight flight_320 = new Flight(seat, 320, "1:59 PM", "3:29 PM", "Greensboro", "Newark", fname, fclass, cost);
        String i = "1";
        System.out.println("Thank you for choosing United Airlines!\n\nWe currently have 1 flight to Greensboro from Newark (Flight 310)" +
                "\n\nWe currently have 1 flight from Newark to Greensboro (Flight 320)");
        while(i.equalsIgnoreCase("1")){
            // prompt user to select movie time

            System.out.println("\nIf you would like the 310 flight, enter '310'.\nIf you would like the 320 flight, enter '320'.\n");

            int time = keyboard.nextInt();

            while(time != 310 && time != 320){  // keeps prompting if it is not 310 or 320

                System.out.println("Please enter either '310' or '320'");
                time = keyboard.nextInt();

            }
            // Attempt to purchase a ticket if the customer's seat of choice is available or if the theater is not full

            // flight 310
            if(time == 310){
                System.out.println("Select a seat: \n");
                int ticket = keyboard.nextInt();
                if(seat == 5){
                    while(ticket < 0 || ticket > flight_310.getSeats()-1) {
                        System.out.println("Please enter a seat number between 0 and "+ (flight_310.getSeats()-1)+" \n");
                        ticket = keyboard.nextInt();
                    }

                }
                if(seat == 10){
                    while(ticket < 4 || ticket > 14) {
                        System.out.println("Please enter a seat number between 5 and "+ (seat - 1) +" \n");
                        ticket = keyboard.nextInt();
                    }

                }
                if(seat == 15){
                    while(ticket < 14 || ticket > flight_310.getSeats()-1) {
                        System.out.println("Please enter a seat number between 5 and "+ (flight_310.getSeats()-1)+" \n");
                        ticket = keyboard.nextInt();
                    }

                }


                try{
                    flight_310.reserveUnitedTicket(ticket);
                }catch(TicketsSoldOutError ex) {
                    System.out.println(ex.getMessage());
                }
                // flight 320
            } else {
                System.out.println("Select a seat: \n");
                int ticket = keyboard.nextInt();

                if(seat == 5){
                    while(ticket < 0 || ticket > flight_310.getSeats()-1) {
                        System.out.println("Please enter a seat number between 0 and "+ (flight_310.getSeats()-1)+" \n");
                        ticket = keyboard.nextInt();
                    }

                }
                if(seat == 10){
                    while(ticket < 4 || ticket > 14) {
                        System.out.println("Please enter a seat number between 5 and "+ (seat - 1) +" \n");
                        ticket = keyboard.nextInt();
                    }

                }
                if(seat == 15) {
                    while (ticket < 14 || ticket > flight_310.getSeats() - 1) {
                        System.out.println("Please enter a seat number between 5 and " + (flight_310.getSeats() - 1) + " \n");
                        ticket = keyboard.nextInt();
                    }
                }

                try{
                    flight_320.reserveUnitedTicket(ticket);
                }catch(TicketsSoldOutError ex) {
                    System.out.println(ex.getMessage());
                }

            }

            // Allow customer to purchase another ticket

            System.out.println("\nIf you would like to get another ticket, please enter  '1'. \n\n" +
                    "If not, enter any other character to exit\n");
            i = keyboard.next();
        }

        System.out.println("\n\n HAVE A GREAT DAY!!\n\n");

    }
}
