package sample;

public class Passenger {
    private String name;
    private char fclass;
    private double cost;

    public Passenger(String name, char fclass){
        this.name = name;
        this.fclass = fclass;

    }

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
