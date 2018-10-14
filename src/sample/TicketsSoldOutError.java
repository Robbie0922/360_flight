package sample;

public class TicketsSoldOutError extends Exception {

    private String message  = "";

    public TicketsSoldOutError(){
        super();

    }

    /**
     *
     * @param message error message
     */
    public TicketsSoldOutError(String message){

        super(message);

    }

    /**
     *
     * @return message the error message to be displayed
     */
    @Override
    public String getMessage() {
        return message;
    }


}
