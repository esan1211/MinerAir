/* Enrique Munoz
 * 2/28/2023
 * Adv. Object Oriented Programming CS3331, Dr. Mejia
 * Programming Assignment 2
*/

public class International extends Flight{
    //Attributes
    private int surcharge;
    private int firstClassSeatsSold = 0;
    private int businessClassSeatsSold = 0;
    private int mainCabinSeatsSold = 0;
    private int totalFirstClassRev = 0;
    private int totalBusinessClassRev = 0;
    private int mainCabinRev = 0;

    //Constructors
    public International(){

    }

    public International(String idIn, String flightNumberIn, String originAirportIn, String originCodeIn, String destinationAirportIn, String destinationCodeIn, String departingDateIn, String departingTimeIn, int durationIn, int distanceIn, int timeZoneDifferenceIn, String arrivalDateIn, String arrivalTimeIn, int surchargeIn, int totalSeatsIn, int firstClassSeatsIn, int businessClassSeatsIn, int mainCabinSeatsIn, int firstClassPriceIn, int businessClassPriceIn, int mainCabinPriceIn){
        super(idIn, flightNumberIn, originAirportIn, originCodeIn, destinationAirportIn, destinationCodeIn, departingDateIn, departingTimeIn, durationIn, distanceIn, timeZoneDifferenceIn, arrivalDateIn, arrivalTimeIn, totalSeatsIn, firstClassSeatsIn, businessClassSeatsIn, mainCabinSeatsIn, firstClassPriceIn, businessClassPriceIn, mainCabinPriceIn);
        this.surcharge = surchargeIn;
    }

    //Setters & Getters
    public int getSurcharge(){
        return surcharge;
    }

    public void setSurcharge(int surcharge){
        this.surcharge = surcharge;
    }

    public int getFirstClassSeatsSold(){
        return firstClassSeatsSold;
    }

    public void setFirstClassSeatsSold(int firstClassSeatsSold){
        this.firstClassSeatsSold = firstClassSeatsSold;
    }

    public int getBusinessClassSeatsSold(){
        return businessClassSeatsSold;
    }

    public void setBusinessClassSeatsSold(int businessClassSeatsSold){
        this.businessClassSeatsSold = businessClassSeatsSold;
    }

    public int getMainCabinSeatsSold(){
        return mainCabinSeatsSold;
    }

    public void setMainCabinSeatsSold(int mainCabinSeatsSold){
        this.mainCabinSeatsSold = mainCabinSeatsSold;
    }

    public int getTotalFirstClassRev(){
        return totalFirstClassRev;
    }

    public void setTotalFirstClassRev(int totalFirstClassRev){
        this.totalFirstClassRev = totalFirstClassRev;
    }

    public int getTotalBusinessClassRev(){
        return totalBusinessClassRev;
    }

    public void setTotalBusinessClassRev(int totalBusinessClassRev){
        this.totalBusinessClassRev = totalBusinessClassRev;
    }

    public int getMainCabinRev(){
        return mainCabinRev;
    }

    public void setMainCabinRev(int mainCabinRev){
        this.mainCabinRev = mainCabinRev;
    }
    
}
