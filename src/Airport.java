/* Enrique Munoz
 * 2/28/2023
 * Adv. Object Oriented Programming CS3331, Dr. Mejia
 * Programming Assignment 2
*/

public class Airport {
    //Attributes
    private String airportName;

    //Constructors
    public Airport(){

    }

    public Airport(String airportNameIn){
        this.airportName = airportNameIn;
    }

    //Getters & Setters
    public String getAirportName(){
        return airportName;
    }

    public void setAirportName(String airportNameIn){
        this.airportName = airportNameIn;
    }
    
    
}
