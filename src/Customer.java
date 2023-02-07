public class Customer extends Person{
    //Attributes
    private String username;
    private String password;
    private int numTickets = 0;
    private int money;
    
    //Constructors
    public Customer(){

    }

    public Customer(String firstName, String lastName, String username, String password, int numTickets, int money) {
        super(firstName, lastName);
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

    public int getMoney(){
        return money;
    }

    public void setMoney(int money){
        this.money = money;
    }
    
}