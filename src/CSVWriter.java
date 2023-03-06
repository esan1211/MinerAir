/* Enrique Munoz
 * 2/28/2023
 * Adv. Object Oriented Programming CS3331, Dr. Mejia
 * Programming Assignment 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CSVWriter {
    BufferedReader buffReaderFlight;
    BufferedWriter buffWriterFlight;
    BufferedReader buffReaderPerson;
    BufferedWriter buffWriterPerson;
    ArrayList<String> linesFlight;
    ArrayList<String> linesPerson;
    
    //Constructors
    public CSVWriter(){
    }
    
    //Methods
    public void openFlightFile(){
        try {
            buffReaderFlight = new BufferedReader(new FileReader("FlightSchedule2Updated.csv"));
            buffWriterFlight = new BufferedWriter(new FileWriter("FlightSchedule2Updated.csv"));
            String line = buffReaderFlight.readLine();
            linesFlight = new ArrayList<>();
            while ((line = buffReaderFlight.readLine()) != null){
                linesFlight.add(line);
            }
        } catch (IOException e) {
            System.out.println("File not found.");
        }
    }

    public void openPersonFile(){
        try {
            buffReaderPerson = new BufferedReader(new FileReader("CustomerListPA2Updated.csv"));
            buffWriterPerson = new BufferedWriter(new FileWriter("CustomerListPA2Updated.csv"));
            String line = buffReaderPerson.readLine();
            linesPerson = new ArrayList<>();
            while ((line = buffReaderPerson.readLine()) != null){
                linesPerson.add(line);
            }
        } catch (IOException e) {
            System.out.println("File not found.");
        }
    }

    public void writeFlightFile(HashMap<String,International> internationalMap, HashMap<String,Domestic> domesticMap){
        try{
            buffWriterFlight.write("ID,Flight Number,Origin Airport,Origin Code,Destination Airport,Destination Code,Departing Date,Departing Time,Duration,Distance,Time Zone Difference,Arrival Date,Arrival Time,Flight Type, Surcharge,Food Served,Route Cost,Miner Points,Total Seats,First Class Seats,Business Class Seats,Main Cabin Seats,First Class Price,Business Class Price,Main Cabin Price,First Class Seats Sold,Business Class Seats Sold,Main Cabin Seats Sold,Total First Class Revenue,Total Business Class Revenue,Total Main Cabin Revenue");
            for (Map.Entry<String,Domestic> mapElement : domesticMap.entrySet()) {
                Domestic currDomestic = mapElement.getValue();
                buffWriterFlight.write(currDomestic.getID()+","+currDomestic.getFlightNumber()+","+currDomestic.getOriginAirport()+","+currDomestic.getOriginCode()+","+currDomestic.getDestinationAirport()+","+currDomestic.getDestinationCode()+","+currDomestic.getDepartureDate()+","+currDomestic.getDepartureTime()+","+currDomestic.getDuration()+","+currDomestic.getDistance()+","+currDomestic.getTimeZoneDiff()+","+currDomestic.getArrivalDate()+","+currDomestic.getArrivalTime()+","+"Domestic"+","+currDomestic.getSurcharge()+","+"FALSE"+","+currDomestic.getRouteCost()+","+"1102"+currDomestic.getTotalSeats()+","+currDomestic.getFirstClassSeats()+","+currDomestic.getBusinessSeats()+","+currDomestic.getMainCabinSeats()+","+currDomestic.getFirstClassPrice()+","+currDomestic.getBusinessClassPrice()+","+currDomestic.getMainCabinPrice()+","+currDomestic.getFirstClassSeatsSold()+","+currDomestic.getBusinessClassSeatsSold()+","+currDomestic.getMainCabinSeatsSold()+","+currDomestic.getTotalFirstClassRev()+","+currDomestic.getTotalBusinessClassRev()+","+currDomestic.getMainCabinRev());
                buffWriterFlight.newLine();
            }
            for (Map.Entry<String,International> mapElement : internationalMap.entrySet()) {
                International currInternational = mapElement.getValue();
                buffWriterFlight.write(currInternational.getID()+","+currInternational.getFlightNumber()+","+currInternational.getOriginAirport()+","+currInternational.getOriginCode()+","+currInternational.getDestinationAirport()+","+currInternational.getDestinationCode()+","+currInternational.getDepartureDate()+","+currInternational.getDepartureTime()+","+currInternational.getDuration()+","+currInternational.getDistance()+","+currInternational.getTimeZoneDiff()+","+currInternational.getArrivalDate()+","+currInternational.getArrivalTime()+","+"Domestic"+","+currInternational.getSurcharge()+","+"FALSE"+","+currInternational.getRouteCost()+","+"1102"+currInternational.getTotalSeats()+","+currInternational.getFirstClassSeats()+","+currInternational.getBusinessSeats()+","+currInternational.getMainCabinSeats()+","+currInternational.getFirstClassPrice()+","+currInternational.getBusinessClassPrice()+","+currInternational.getMainCabinPrice()+","+currInternational.getFirstClassSeatsSold()+","+currInternational.getBusinessClassSeatsSold()+","+currInternational.getMainCabinSeatsSold()+","+currInternational.getTotalFirstClassRev()+","+currInternational.getTotalBusinessClassRev()+","+currInternational.getMainCabinRev());
                buffWriterFlight.newLine();
            }
        }catch(IOException e){
            System.out.println("File not found.");
        }
    }

    public void writePersonFile(HashMap<String,Customer> customerMap, HashMap<String,Employee> employeeMap){
        try{
            buffWriterPerson.write("ID,First Name,Last Name,DOB,Role,Money Available,Flights Purchased,MinerAir Membership,Username,Password");
            buffWriterPerson.newLine();
            for (Map.Entry<String,Customer> mapElement : customerMap.entrySet()) {
                Customer currCustomer = mapElement.getValue();
                buffWriterPerson.write(currCustomer.getID()+","+currCustomer.getFirstName()+","+currCustomer.getLastName()+","+currCustomer.getDateOfBirthIn()+","+currCustomer.getRole()+","+currCustomer.getMoney()+","+currCustomer.getFlightsPurchased()+","+currCustomer.isMinerAirMembership()+","+currCustomer.getUsername()+","+currCustomer.getPassword());
                buffWriterPerson.newLine();
            }
            for (Map.Entry<String,Employee> mapElement : employeeMap.entrySet()) {
                Employee currEmployee = mapElement.getValue();
                buffWriterPerson.write(currEmployee.getID()+","+currEmployee.getFirstName()+","+currEmployee.getLastName()+","+currEmployee.getDateOfBirthIn()+","+currEmployee.getRole()+","+currEmployee.getMoney()+",0,"+currEmployee.isMinerAirMembership()+","+currEmployee.getUsername()+","+currEmployee.getPassword());
                buffWriterPerson.newLine();
            }
        }catch(IOException e){
            System.out.println("File not found.");
        }
    }

    public void closeFlightFile(){
        try{
            if(buffWriterFlight!=null){
                buffWriterFlight.close();
                buffReaderFlight.close();
            }
        }catch(IOException e){
            System.out.println("File not found.");
        }
    }

    public void closePersonFile(){
        try{
            if(buffWriterPerson!=null){
                buffWriterPerson.close();
                buffReaderPerson.close();
            }
        }catch(IOException e){
            System.out.println("File not found.");
        }
    }
}
