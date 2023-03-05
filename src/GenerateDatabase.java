/* Enrique Munoz
 * 2/28/2023
 * Adv. Object Oriented Programming CS3331, Dr. Mejia
 * Programming Assignment 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class GenerateDatabase{
    //Attributes
    private HashMap<String,Domestic> domesticFlightMap;
    private HashMap<String,International> internationalFlightMap;
    private HashMap<String,Customer> customerMap;
    private HashMap<String,Employee> employeeMap;

    public GenerateDatabase(){

    }

    //Setters & Getters
    
    //Sets up domestic and internation flight maps
    public void setDomesticInternationMap(){
        HashMap<String,Domestic> domesticFlightMap = new HashMap<String,Domestic>();
        HashMap<String,International> internationalFlightMap = new HashMap<String,International>();
        
        //File Reading for Flight Schedule
        try{
            FlightFactory flightFactory = new FlightFactory();
            BufferedReader buffReader = new BufferedReader(new FileReader("FlightSchedule(2).csv"));
            String line = buffReader.readLine();
            ArrayList<String> lines = new ArrayList<>();
            while ((line = buffReader.readLine()) != null){
                lines.add(line);
            }
            //Populates a HashMap of Flights with ID as a key and Flight Obj as a value
            for(int i = 0; i < lines.size(); i++){ //Traverses through every line in csv ArrayList and creates a string array to split by commas and add new International and Domestic obj to Flights ArrayList
                String[] readFlights = lines.get(i).split(",");
                Flight currFlight = flightFactory.createFlight(readFlights[13], readFlights[0], readFlights[1], readFlights[2], readFlights[3], readFlights[4], readFlights[5], readFlights[6], readFlights[7], Integer.valueOf(readFlights[8]), Integer.valueOf(readFlights[9]), Integer.valueOf(readFlights[10]), readFlights[11], readFlights[12], Integer.valueOf(readFlights[14]), Integer.valueOf(readFlights[16]), Integer.valueOf(readFlights[18]), Integer.valueOf(readFlights[19]), Integer.valueOf(readFlights[20]), Integer.valueOf(readFlights[21]), Integer.valueOf(readFlights[22]), Integer.valueOf(readFlights[23]), Integer.valueOf(readFlights[24]));
                if(readFlights[13].equals("International")){ //Optimize later*****
                    internationalFlightMap.put(readFlights[0], (International) currFlight);
                }else{
                    domesticFlightMap.put(readFlights[0], (Domestic) currFlight);
                }
            }
            this.domesticFlightMap = domesticFlightMap;
            this.internationalFlightMap = internationalFlightMap;
            buffReader.close();
        }catch(IOException e){
            System.out.println("The file cannot be found.");
        }
    }

    //Sets up customer & employee map
    public void setPeopleMap(){
        HashMap<String,Customer> customerMap = new HashMap<String,Customer>();
        HashMap<String,Employee> employeeMap = new HashMap<String,Employee>();
        
        //File Reading for Customer Schedule
        try{
            PersonFactory personFactory = new PersonFactory();
            BufferedReader buffReader = new BufferedReader(new FileReader("CustomerListPA2.csv"));
            String line = buffReader.readLine();
            ArrayList<String> lines = new ArrayList<>();
            while ((line = buffReader.readLine()) != null){
                lines.add(line);
            }
            //Populates a HashMap of Customers & Employees 
            for(int i = 0; i < lines.size(); i++){ //Traverses through every line in csv ArrayList and creates a string array to split by commas and adds new Customer and Employee obj to People ArrayList
                String[] readPeople = lines.get(i).split(",");
                Person currPerson = personFactory.createPerson(readPeople[4], readPeople[0], readPeople[1], readPeople[2], readPeople[3], readPeople[4], Double.valueOf(readPeople[5]), Boolean.valueOf(readPeople[7]), readPeople[8], readPeople[9]);
                if(readPeople[4].equals("Customer")){
                    customerMap.put(readPeople[1] + " " + readPeople[2], (Customer) currPerson);
                }else{
                    employeeMap.put(readPeople[1] + " " + readPeople[2], (Employee) currPerson);
                }
            }
            this.customerMap = customerMap;
            this.employeeMap = employeeMap;
            buffReader.close();
        }catch(IOException e){
            System.out.println("The file cannot be found.");
        }
    }

    public HashMap<String, Domestic> getDomesticFlightMap(){
        return domesticFlightMap;
    }

    public HashMap<String, International> getInternationalFlightMap(){
        return internationalFlightMap;
    }

    public HashMap<String, Customer> getCustomerMap(){
        return customerMap;
    }

    public HashMap<String, Employee> getEmployeeMap(){
        return employeeMap;
    }
    
}