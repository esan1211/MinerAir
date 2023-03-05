/* Enrique Munoz
 * 2/28/2023
 * Adv. Object Oriented Programming CS3331, Dr. Mejia
 * Programming Assignment 2
*/

public class FlightFactory {

    public FlightFactory(){

    }

    public Flight createFlight(String type, String idIn, String flightNumberIn, String originAirportIn, String originCodeIn, String destinationAirportIn, String destinationCodeIn, String departingDateIn, String departingTimeIn, int durationIn, int distanceIn, int timeZoneDifferenceIn, String arrivalDateIn, String arrivalTimeIn, int surchargeIn, int routeCostIn, int totalSeatsIn, int firstClassSeatsIn, int businessClassSeatsIn, int mainCabinSeatsIn, int firstClassPriceIn, int businessClassPriceIn, int mainCabinPriceIn){
        if(type.equals("International")){
            return new International(idIn, flightNumberIn, originAirportIn, originCodeIn, destinationAirportIn, destinationCodeIn, departingDateIn, departingTimeIn, durationIn, distanceIn, timeZoneDifferenceIn, arrivalDateIn, arrivalTimeIn, surchargeIn, routeCostIn, totalSeatsIn, firstClassSeatsIn, businessClassSeatsIn, mainCabinSeatsIn, firstClassPriceIn, businessClassPriceIn, mainCabinPriceIn);
        }else{
            return new Domestic(idIn, flightNumberIn, originAirportIn, originCodeIn, destinationAirportIn, destinationCodeIn, departingDateIn, departingTimeIn, durationIn, distanceIn, timeZoneDifferenceIn, arrivalDateIn, arrivalTimeIn, surchargeIn, routeCostIn, totalSeatsIn, firstClassSeatsIn, businessClassSeatsIn, mainCabinSeatsIn, firstClassPriceIn, businessClassPriceIn, mainCabinPriceIn);
        }
    }
    
}
