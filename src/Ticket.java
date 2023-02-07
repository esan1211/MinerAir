public class Ticket {
    //Attributes
    private int price;
    private int numSeats;
    private int confirmationNum;
    private int amount;
    
    //Constructors
    public Ticket(){

    }

    public Ticket(int price, int numSeats, int confirmationNum, int amount){
        this.price = price;
        this.numSeats = numSeats;
        this.confirmationNum = confirmationNum;
        this.amount = amount;
    }

    //Getters & Setters
    public int getPrice(){
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public int getNumSeats(){
        return numSeats;
    }

    public void setNumSeats(int numSeats){
        this.numSeats = numSeats;
    }

    public int getConfirmationNum(){
        return confirmationNum;
    }

    public void setConfirmationNum(int confirmationNum){
        this.confirmationNum = confirmationNum;
    }

    public int getAmount(){
        return amount;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }
  
}
