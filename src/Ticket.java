public class Ticket {
    //Attributes
    private int price;
    private int numSeats;
    private int confirmationNum;
    private int amount;
    
    //Constructors
    public Ticket(){

    }

    public Ticket(int priceIn, int numSeatsIn, int confirmationNumIn, int amountIn){
        this.price = priceIn;
        this.numSeats = numSeatsIn;
        this.confirmationNum = confirmationNumIn;
        this.amount = amountIn;
    }

    //Getters & Setters
    public int getPrice(){
        return price;
    }

    public void setPrice(int priceIn){
        this.price = priceIn;
    }

    public int getNumSeats(){
        return numSeats;
    }

    public void setNumSeats(int numSeatsIn){
        this.numSeats = numSeatsIn;
    }

    public int getConfirmationNum(){
        return confirmationNum;
    }

    public void setConfirmationNum(int confirmationNumIn){
        this.confirmationNum = confirmationNumIn;
    }

    public int getAmount(){
        return amount;
    }

    public void setAmount(int amountIn){
        this.amount = amountIn;
    }
  
}
