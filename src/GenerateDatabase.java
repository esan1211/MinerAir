import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class GenerateDatabase{
    //Attributes
    private HashMap<String,Domestic> domesticFlightMap;
    private HashMap<String,International> internationalFlightMap;
    private HashMap<String,Customer> customerMap;
    private HashMap<String,Employee> employeMap;

    public GenerateDatabase(){

    }

    //Setters & Getters
    
    //Sets up domestic and internation flight maps
    public void setDomesticInternationMap(){
        HashMap<String,Domestic> domesticFlightMap = new HashMap<String,Domestic>();
        HashMap<String,International> internationalFlightMap = new HashMap<String,International>();
        
        //File Reading for Flight Schedule
        try{
            BufferedReader buffReader = new BufferedReader(new FileReader("FlightSchedule(2).csv"));
            String line = buffReader.readLine();
            ArrayList<String> lines = new ArrayList<>();
            while ((line = buffReader.readLine()) != null){
                lines.add(line);
            }
            //Populates a HashMap of Flights with ID as a key and Flight Obj as a value
            for(int i = 0; i < lines.size(); i++){ //Traverses through every line in csv ArrayList and creates a string array to split by commas and add new International and Domestic obj to Flights ArrayList
                String[] readFlights = lines.get(i).split(",");
                if(readFlights[13].equals("International")){
                    internationalFlightMap.put(readFlights[0], new International(readFlights[0], readFlights[1], readFlights[2], readFlights[3], readFlights[4], readFlights[5], readFlights[6], readFlights[7], Integer.valueOf(readFlights[8]), Integer.valueOf(readFlights[9]), Integer.valueOf(readFlights[10]), readFlights[11], readFlights[12], Integer.valueOf(readFlights[14]), Integer.valueOf(readFlights[18]), Integer.valueOf(readFlights[19]), Integer.valueOf(readFlights[20]), Integer.valueOf(readFlights[21]), Integer.valueOf(readFlights[22]), Integer.valueOf(readFlights[23]), Integer.valueOf(readFlights[24])));
                }else{
                    domesticFlightMap.put(readFlights[0], new Domestic(readFlights[0], readFlights[1], readFlights[2], readFlights[3], readFlights[4], readFlights[5], readFlights[6], readFlights[7], Integer.valueOf(readFlights[8]), Integer.valueOf(readFlights[9]), Integer.valueOf(readFlights[10]), readFlights[11], readFlights[12], Integer.valueOf(readFlights[14]), Integer.valueOf(readFlights[18]), Integer.valueOf(readFlights[19]), Integer.valueOf(readFlights[20]), Integer.valueOf(readFlights[21]), Integer.valueOf(readFlights[22]), Integer.valueOf(readFlights[23]), Integer.valueOf(readFlights[24])));
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
            HashMap<String,Employee> employeMap = new HashMap<String,Employee>();
            //File Reading for Customer Schedule
            try{
                BufferedReader buffReader = new BufferedReader(new FileReader("CustomerListPA2.csv"));
                String line = buffReader.readLine();
                ArrayList<String> lines = new ArrayList<>();
                while ((line = buffReader.readLine()) != null){
                    lines.add(line);
                }
                //Populates a HashMap of Customers & Employees 
                for(int i = 0; i < lines.size(); i++){ //Traverses through every line in csv ArrayList and creates a string array to split by commas and adds new Customer and Employee obj to People ArrayList
                    String[] readPeople = lines.get(i).split(",");
                    System.out.println(readPeople);
                    if(readPeople[4].equals("Customer")){
                        customerMap.put(readPeople[1] + " " + readPeople[2], new Customer(readPeople[0], readPeople[1], readPeople[2], readPeople[3], readPeople[4], Double.valueOf(readPeople[5]), Integer.valueOf(readPeople[6]), Boolean.valueOf(readPeople[7]), readPeople[8], readPeople[9]));
                    }else{
                        employeMap.put(readPeople[1] + " " + readPeople[2], new Employee(readPeople[0], readPeople[1], readPeople[2], readPeople[3], readPeople[4], Double.valueOf(readPeople[5]), Boolean.valueOf(readPeople[7]), readPeople[8], readPeople[9]));
                    }
                }
                this.customerMap = customerMap;
                this.employeMap = employeMap;
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

        public HashMap<String, Employee> getEmployeMap(){
            return employeMap;
        }
    
}