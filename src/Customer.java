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

    public Customer(String firstName, String lastName, String id, String username, String password, double money) {
        super(firstName, lastName);
        this.id = id;
        this.username = username;
        this.password = password;
        this.money = money;
    }

    //Getters & Setters
    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public ArrayList<Ticket> getTicketsPurchased(){
        return ticketsPurchased;
    }

    public void setTicketsPurchased(ArrayList<Ticket> ticketsPurchased){
        this.ticketsPurchased = ticketsPurchased;
    }

    public double getMoney(){
        return money;
    }

    public void setMoney(double money){
        this.money = money;
    }
    
}