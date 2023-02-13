import java.util.ArrayList;

public class Customer extends Person{
    //Attributes
    private String id;
    private String username;
    private String password;
    private ArrayList<Ticket> ticketsPurchased = new ArrayList<Ticket>();
    private double money;
    
    //Constructors
    public Customer(){

    }

    public Customer(String firstNameIn, String lastNameIn, String idIn, String usernameIn, String passwordIn, double moneyIn) {
        super(firstNameIn, lastNameIn);
        this.id = idIn;
        this.username = usernameIn;
        this.password = passwordIn;
        this.money = moneyIn;
    }

    //Getters & Setters
    public String getUsername(){
        return username;
    }

    public void setUsername(String usernameIn){
        this.username = usernameIn;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String passwordIn){
        this.password = passwordIn;
    }

    public ArrayList<Ticket> getTicketsPurchased(){
        return ticketsPurchased;
    }

    public void setTicketsPurchased(ArrayList<Ticket> ticketsPurchasedIn){
        this.ticketsPurchased = ticketsPurchasedIn;
    }

    public double getMoney(){
        return money;
    }

    public void setMoney(double moneyIn){
        this.money = moneyIn;
    }
    
}