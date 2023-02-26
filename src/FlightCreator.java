public class FlightCreator {
    public FlightCreator(){

    }

    public Flight createFlight(String type){
        if(type.toLowerCase().equals("international")){
            return new International(idIn, flightNumberIn,  originAirportIn,  originCodeIn,  destinationAirportIn,  destinationCodeIn,  departingDateIn,  departingTimeIn,  durationIn,  distanceIn,  timeZoneDifferenceIn,  arrivalDateIn,  arrivalTimeIn,  surchargeIn,  totalSeatsIn,  firstClassSeatsIn,  businessClassSeatsIn,  mainCabinSeatsIn,  firstClassPriceIn,  businessClassPriceIn,  mainCabinPriceIn);
        }
        else{
            return new Domestic();
        }
    }
}
