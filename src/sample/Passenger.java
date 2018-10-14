package sample;

public class Passenger {
    private String name;
    private char fclass;
    private double cost;
    private int seat;

    public Passenger(String name, char fclass){
        this.name = name;
        this.fclass = fclass;

    }
    // Get cost of tickets based on class chosen
    public double Cost(char fclass){
        switch(fclass){
            case 'E':
                cost = 300;
                break;
            case 'B':
                cost = 300 + (300 * .50);
                break;
            case 'F':
                cost = (300 + (300 * .50)) * 2;
                break;
        }
        return cost;
    }
    // pick seats based on class chosen
    public int Seat(char fclass){
        switch(fclass){
            case 'E':
                seat = 15;
                break;
            case 'B':
                seat = 10;
                break;
            case 'F':
                seat = 5;
                break;
        }
        return seat;
    }
    public void setName(String name){
        this.name = name;

    }
    public String getName () {
        return this.name;
    }
    public void setClass(char fclass){
        this.fclass = fclass;

    }
    public char setClass () {
        return this.fclass;
    }
}
