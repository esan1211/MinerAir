import java.util.ArrayList;

public class Customer extends Person{
    //Attributes
    private ArrayList<Ticket> ticketsPurchased = new ArrayList<Ticket>();
    private int flightsPurchased;
    
    //Constructors
    public Customer(){

    }

    public Customer(String idIn, String firstNameIn, String lastNameIn, String dateOfBirthIn, String roleIn, double moneyIn, int flightsPurchasedIn, boolean minerAirMembershipIn, String usernameIn, String passwordIn){
        super(idIn, firstNameIn, lastNameIn, dateOfBirthIn, roleIn, moneyIn, minerAirMembershipIn, usernameIn, passwordIn);
        this.flightsPurchased = flightsPurchasedIn;
    }

    //Getters & Setters
    public ArrayList<Ticket> getTicketsPurchased(){
        return ticketsPurchased;
    }

    public void setTicketsPurchased(ArrayList<Ticket> ticketsPurchasedIn){
        this.ticketsPurchased = ticketsPurchasedIn;
    }

    public int getFlightsPurchased(){
        return flightsPurchased;
    }

    public void setFlightsPurchased(int flightsPurchased){
        this.flightsPurchased = flightsPurchased;
    }

    
}