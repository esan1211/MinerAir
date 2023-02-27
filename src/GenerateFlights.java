import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GenerateFlights{
    public static void main(String[] args){
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
                if(readFlights[13].equals("International")){
                    internationalFlightMap.put(readFlights[0], new International(readFlights[0], readFlights[1], readFlights[2], readFlights[3], readFlights[4], readFlights[5], readFlights[6], readFlights[7], Integer.valueOf(readFlights[8]), Integer.valueOf(readFlights[9]), Integer.valueOf(readFlights[10]), readFlights[11], readFlights[12], Integer.valueOf(readFlights[14]), Integer.valueOf(readFlights[18]), Integer.valueOf(readFlights[19]), Integer.valueOf(readFlights[20]), Integer.valueOf(readFlights[21]), Integer.valueOf(readFlights[22]), Integer.valueOf(readFlights[23]), Integer.valueOf(readFlights[24])));
                }else{
                    domesticFlightMap.put(readFlights[0], new Domestic(readFlights[0], readFlights[1], readFlights[2], readFlights[3], readFlights[4], readFlights[5], readFlights[6], readFlights[7], Integer.valueOf(readFlights[8]), Integer.valueOf(readFlights[9]), Integer.valueOf(readFlights[10]), readFlights[11], readFlights[12], Integer.valueOf(readFlights[14]), Integer.valueOf(readFlights[18]), Integer.valueOf(readFlights[19]), Integer.valueOf(readFlights[20]), Integer.valueOf(readFlights[21]), Integer.valueOf(readFlights[22]), Integer.valueOf(readFlights[23]), Integer.valueOf(readFlights[24])));
                }
            }
            buffReader.close();
        }catch(IOException e){
            System.out.println("The file cannot be found.");
        }

        for (Map.Entry<String,International> mapElement : internationalFlightMap.entrySet()) {
            String key = mapElement.getKey();
 
            // Adding some bonus marks to all the students
            International value = (mapElement.getValue());
            value.printFlight();
            // Printing above marks corresponding to
            // students names
            System.out.println(key + " : " + value);
        }


        

    }
}