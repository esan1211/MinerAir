/* Enrique Munoz
 * 2/28/2023
 * Adv. Object Oriented Programming CS3331, Dr. Mejia
 * Programming Assignment 2
*/

public class Ticket {
    //Attributes
    private int price;
    private int numSeats;
    private int confirmationNum;
    private int firstClassSeatsPurchased = 0;
    private int businessClassSeatsPurchased = 0;
    private int mainCabinSeatsPurchased = 0;
    private int amount;
    private Customer user;
    private String flightID;
    
    //Constructors
    public Ticket(){

    }

    public Ticket(int priceIn, int numSeatsIn, int confirmationNumIn, int firstClassSeatsPurchasedIn, int businessClassSeatsPurchasedIn, int mainCabinSeatsPurchasedIn, int amountIn, Customer userIn, String flightIDIn){
        this.price = priceIn;
        this.numSeats = numSeatsIn;
        this.confirmationNum = confirmationNumIn;
        this.firstClassSeatsPurchased = firstClassSeatsPurchasedIn;
        this.businessClassSeatsPurchased = businessClassSeatsPurchasedIn;
        this.mainCabinSeatsPurchased = mainCabinSeatsPurchasedIn;
        this.amount = amountIn;
        this.user = userIn;
        this.flightID = flightIDIn;
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

    public Customer getUser(){
        return user;
    }

    public void setUser(Customer user){
        this.user = user;
    }

    public String getFlightID(){
        return flightID;
    }

    public void setFlightID(String flightID){
        this.flightID = flightID;
    }

    public int getFirstClassSeatsPurchased(){
        return firstClassSeatsPurchased;
    }

    public void setFirstClassSeatsPurchased(int firstClassSeatsPurchased){
        this.firstClassSeatsPurchased = firstClassSeatsPurchased;
    }

    public int getBusinessClassSeatsPurchased(){
        return businessClassSeatsPurchased;
    }

    public void setBusinessClassSeatsPurchased(int businessClassSeatsPurchased){
        this.businessClassSeatsPurchased = businessClassSeatsPurchased;
    }

    public int getMainCabinSeatsPurchased(){
        return mainCabinSeatsPurchased;
    }

    public void setMainCabinSeatsPurchased(int mainCabinSeatsPurchased){
        this.mainCabinSeatsPurchased = mainCabinSeatsPurchased;
    }
 
}
