import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class GenerateFlights{
    public static void main(String[] args){
        FlightCreator flightGen = new FlightCreator();
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
            for(int i = 0; i < lines.size(); i++){ //Traverses through every line in csv ArrayList and creates a string array to split by commas and add new Flight obj to Flights ArrayList
                String[] readFlights = lines.get(i).split(",");
                System.out.println(flightGen.createFlight(readFlights[13]));
                if(readFlights[13].equals("International")){
                    //internationalFlightMap.put(readFlights[0],flightGen.createFlight(readFlights[13]));
                }
                //System.out.println(readFlights[13]);
                //flightMap.put(readFlights[0], new Flight(readFlights[0], readFlights[1], readFlights[2], readFlights[3], readFlights[4], readFlights[5], readFlights[6], readFlights[7], Integer.valueOf(readFlights[8]), Integer.valueOf(readFlights[9]), Integer.valueOf(readFlights[10]), readFlights[11], readFlights[12], Integer.valueOf(readFlights[13]), Integer.valueOf(readFlights[14]), Integer.valueOf(readFlights[15]), Integer.valueOf(readFlights[16]), Integer.valueOf(readFlights[17]), Integer.valueOf(readFlights[18]), Integer.valueOf(readFlights[19])));
            }
            buffReader.close();
        }catch(IOException e){
            System.out.println("The file cannot be found.");
        }

    }
}