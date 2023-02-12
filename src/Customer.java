public class Customer extends Person{
    //Attributes
    private String id;
    private String username;
    private String password;
    private int numTickets = 0;
    private double money;
    
    //Constructors
    public Customer(){

    }

    public Customer(String firstName, String lastName, String id, String username, String password, int numTickets, double money) {
        super(firstName, lastName);
        this.id = id;
        this.username = username;
        this.password = password;
        this.numTickets = numTickets;
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

    public int getNumTickets(){
        return numTickets;
    }

    public void setNumTickets(int numTickets){
        this.numTickets = numTickets;
    }

    public double getMoney(){
        return money;
    }

    public void setMoney(double money){
        this.money = money;
    }
    
}