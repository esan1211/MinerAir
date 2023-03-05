/* Enrique Munoz
 * 2/28/2023
 * Adv. Object Oriented Programming CS3331, Dr. Mejia
 * Programming Assignment 2
*/

import java.util.ArrayList;

public abstract class Flight {
    //Attributes
    private String originAirport;
    private String originCode;
    private String destinationAirport;
    private String destinationCode;
    private String departureDate;
    private String departureTime;
    private String arrivalDate;
    private String arrivalTime;
    private String id;
    private String flightNumber;
    private int routeCost;
    private int ticketsPurchased = 0;
    private int firstClassPrice;
    private int businessClassPrice;
    private int mainCabinPrice;
    private int duration;
    private int distance;
    private int timeZoneDiff;
    private int totalSeats;
    private int firstClassSeats;
    private int businessClassSeats;
    private int mainCabinSeats;
    private ArrayList<Ticket> ticketList = new ArrayList<Ticket>();
    
    //Constructors
    public Flight(){

    }

    public Flight(String idIn, String flightNumberIn, String originAirportIn, String originCodeIn, String destinationAirportIn, String destinationCodeIn, String departingDateIn, String departingTimeIn, int durationIn, int distanceIn, int timeZoneDifferenceIn, String arrivalDateIn, String arrivalTimeIn, int routeCostIn, int totalSeatsIn, int firstClassSeatsIn, int businessClassSeatsIn, int mainCabinSeatsIn, int firstClassPriceIn, int businessClassPriceIn, int mainCabinPriceIn){
        this.id = idIn;
        this.flightNumber = flightNumberIn;
        this.originAirport = originAirportIn;
        this.originCode = originCodeIn;
        this.destinationAirport = destinationAirportIn;
        this.destinationCode = destinationCodeIn;
        this.departureDate = departingDateIn;
        this.departureTime = departingTimeIn;
        this.duration = durationIn;
        this.distance = distanceIn;
        this.timeZoneDiff = timeZoneDifferenceIn;
        this.totalSeats = totalSeatsIn;
        this.arrivalDate = arrivalDateIn;
        this.arrivalTime = arrivalTimeIn;
        this.routeCost = routeCostIn;
        this.firstClassSeats = firstClassSeatsIn;
        this.businessClassSeats = businessClassSeatsIn;
        this.mainCabinSeats = mainCabinSeatsIn;
        this.firstClassPrice = firstClassPriceIn;
        this.businessClassPrice = businessClassPriceIn;
        this.mainCabinPrice = mainCabinPriceIn;

    }

    public String[] timeChange(String depTime, int duration){ //Function to update arrival time if destination time is changed
        String[] result = new String[2]; //Return type in order to return a change of day and also the time change
        if(depTime == null){ //Need to declare a time first in order to change arrival time
            result[0] = "0";
            return result;
        }
        int idx = 0;
        String strHours = "";
        String strMin = "";
        String timeOfDay = "";
        while(depTime.charAt(idx) != ':'){ //Changes hour to int
            strHours +=  String.valueOf(depTime.charAt(idx));
            idx+=1;
        }
        idx+=1;
        while(depTime.charAt(idx) != ' '){ //Changes min to int
            strMin +=  String.valueOf(depTime.charAt(idx));
            idx+=1;
        }
        idx+=1;
        while(idx < depTime.length()){ //Changes min to int
            timeOfDay +=  String.valueOf(depTime.charAt(idx));
            idx+=1;
        }
        int intHours = Integer.valueOf(strHours);
        int intMin = Integer.valueOf(strMin); 
        while(duration > 0){
            if(duration < 60){
                intMin += duration;
                duration = 0;
                if(intMin > 59){
                    intMin -= 60;
                    intHours += 1;
                }
            }else{
                intHours += 1;
                duration -= 60;    
            } 
        }
        int daysPassed = 0;
        if(intHours >= 12){ //Converts AM to PM and vice versa depending on time
            if(timeOfDay.equals("AM") || strHours.equals("12")){
                timeOfDay = "PM";
            }else{
                timeOfDay = "AM";
                daysPassed += 1;
            }    
        }
        while(intHours > 12){
            intHours -= 12;
        }
        strHours = String.valueOf(intHours);
        strMin = String.valueOf(intMin);
        result[0] = String.valueOf(daysPassed);
        if (intMin < 10){
            result[1] = strHours + ":0" + strMin + " " + timeOfDay;    
        }else{
            result[1] = strHours + ":" + strMin + " " + timeOfDay;
        }
        return result;
        
    }

    public String dayChange(String date,int dayChange){ //Changes day if time exceeds 24 hours period
        String strDay = "";
        String strMonth = "";
        String strYear = "";
        int idx = 0;
        while(date.charAt(idx)!='/'){
            strMonth += String.valueOf(date.charAt(idx));
            idx+=1;
        }
        idx+=1;
        while(date.charAt(idx)!='/'){
            strDay += String.valueOf(date.charAt(idx));
            idx+=1;
        }
        idx+=1;
        while(idx < date.length()){
            strYear += String.valueOf(date.charAt(idx));
            idx+=1;
        }
        int intDay = Integer.valueOf(strDay);
        int intMonth = Integer.valueOf(strMonth);
        int intYear = Integer.valueOf(strYear);
        while(dayChange > 0){
            intDay += dayChange;
            if(intDay > 31){
                intMonth += 1;
                intDay = 1;
                if(intMonth > 12){
                    intMonth = 1;
                    intYear += 1;
                }   
            }
            dayChange -= 1;
        }
        strDay = String.valueOf(intDay);
        strMonth = String.valueOf(intMonth);
        strYear = String.valueOf(intYear);
        return strMonth + "/" + strDay + "/" + strYear;
        
    }

    //Setters
    public void setOriginAirport(String originAirportIn){
        this.originAirport = originAirportIn;
    }

    public void setOriginCode(String originCodeIn){
        this.originCode = originCodeIn;
    }

    public void setDestinationAirport(String destinationAirportIn){
        this.destinationAirport = destinationAirportIn;
    }

    public void setDestinationCode(String destinationCodeIn){
        this.destinationCode = destinationCodeIn;
    }

    public void setDepartureDate(String departureDateIn){
        this.departureDate = departureDateIn;
        String[] time = timeChange(this.getDepartureTime(), this.getDuration()); //Changes arrival if departureTime is changed
        int daysPassed = Integer.valueOf(time[0]);
        this.arrivalDate = this.dayChange(departureDateIn, daysPassed);
    }

    public void setDepartureTime(String departureTimeIn){
        this.departureTime = departureTimeIn;
        String[] time = timeChange(departureTimeIn, this.getDuration() + this.getTimeZoneDiff()); //Changes arrival if departureTime is changed
        int daysPassed = Integer.valueOf(time[0]);
        this.arrivalDate = this.dayChange(this.getDepartureDate(), daysPassed);
        this.arrivalTime = time[1];
    }

    public void setTicketsPurchased(){ //Updates tickets purchased by one when customer buys a ticket
        this.ticketsPurchased += 1;
    }

    public void setFirstClassPrice(int firstClassPriceIn){
        this.firstClassPrice = firstClassPriceIn;
    }

    public void setBusinessClassPrice(int businessClassPriceIn){
        this.businessClassPrice = businessClassPriceIn;
    }

    public void setMainCabinPrice(int mainCabinPriceIn){
        this.mainCabinPrice = mainCabinPriceIn;
    }

    public void setTotalSeats(int totalSeatsIn){
        this.totalSeats = totalSeatsIn;
    }

    public void setFirstClassSeats(int firstClassSeatsIn){
        this.firstClassSeats = firstClassSeatsIn;
    }

    public void setBusinessClassSeats(int businessClassSeatsIn){
        this.businessClassSeats = businessClassSeatsIn;
    }

    public void setMainCabinSeats(int mainCabinSeatsIn){
        this.mainCabinSeats = mainCabinSeatsIn;
    }

    public void setTicketList(ArrayList<Ticket> ticketListIn){
        this.ticketList = ticketListIn;
    }

    public void setRouteCost(int routeCostIn){
        this.routeCost = routeCostIn;
    }

    public void setFlightNumber(String flightNumberIn){
        this.flightNumber = flightNumberIn;
    }

    //Getters
    public String getOriginAirport(){
        return this.originAirport;
    }

    public String getOriginCode(){
        return this.originCode;
    }

    public String getDestinationAirport(){
        return this.destinationAirport;
    }

    public String getDestinationCode(){
        return this.destinationCode;
    }

    public String getDepartureDate(){
        return this.departureDate;
    }

    public String getDepartureTime(){
      
        return this.departureTime;
    }
    public String getArrivalTime(){
        return this.arrivalTime;
    }

    public String getArrivalDate(){
        return this.arrivalDate;
    }

    public int getTicketsPurchased() {
        return ticketsPurchased;
    }

    public int getFirstClassPrice(){
        return this.firstClassPrice;
    }
    
    public int getBusinessClassPrice(){
        return this.businessClassPrice;
    }

    public int getMainCabinPrice(){
        return this.mainCabinPrice;
    }

    public int getDuration(){
        return this.duration;
    }

    public int getDistance(){
        return this.distance;
    }

    public int getTimeZoneDiff(){
        return this.timeZoneDiff;
    }

    public int getTotalSeats(){
        return this.totalSeats;
    }

    public int getFirstClassSeats(){
        return this.firstClassSeats;
    }

    public int getBusinessSeats(){
        return this.businessClassSeats;
    }

    public int getMainCabinSeats(){
        return this.mainCabinSeats;
    }

    public String getID(){
        return this.id;
    }

    public ArrayList<Ticket> getTicketList(){
        return this.ticketList;
    }

    public int getRouteCost(){
        return this.routeCost;
    }

    public String getFlightNumber(){
        return this.flightNumber;
    }

    public void printFlight(){ //Prints attributes of obj
        System.out.println("Origin Airport: " + getOriginAirport());
        System.out.println("Origin Code: " + getOriginCode());
        System.out.println("Destination Airport: " + getDestinationAirport());
        System.out.println("Destination Code: " + getDestinationCode());
        System.out.println("Departure Date: " + getDepartureDate());
        System.out.println("Departure Time: " + getDepartureTime());
        System.out.println("Arrival Date: " + getArrivalDate());
        System.out.println("Arival Time: " + getArrivalTime());
        System.out.println("Route Cost: " + getRouteCost());
        System.out.println("Duration: " + getDuration());
        System.out.println("Distance: " + getDistance());
        System.out.println("Time Zone Difference: " + getTimeZoneDiff());
        System.out.println("First Class Price: " + getFirstClassPrice());
        System.out.println("Business Class Price: " + getBusinessClassPrice());
        System.out.println("Main Cabin Price: " + getMainCabinPrice());
        System.out.println("First Class Seats: " + getFirstClassSeats());
        System.out.println("Business Class Seats: " + getBusinessSeats());
        System.out.println("Main Cabin Seats: " + getMainCabinSeats());
        System.out.println("Total Seats: " + getTotalSeats());
    }      
}
