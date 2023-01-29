//PA0 Enrique Munoz
//Dr. Mejia CS3331
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Flight> Flights = new ArrayList<Flight>(); //ArrayList of flights
        BufferedWriter buffWriter = new BufferedWriter(new FileWriter("Log.txt")); //Log file to track changes
        BufferedReader Buffreader = new BufferedReader(new FileReader("FlightSchedulePA0.csv"));
        String line = Buffreader.readLine();
        ArrayList<String> lines = new ArrayList<>(); //Contains list of every line in csv
        while ((line = Buffreader.readLine()) != null){
            lines.add(line);
        }
        for(int i = 0; i < lines.size(); i++){ //Traverses through every line in csv ArrayList and creates a string array to split by commas and add new Flight obj to Flights ArrayList
            String[] readFlights = lines.get(i).split(",");
            Flights.add(new Flight(readFlights[0], readFlights[1], readFlights[2], readFlights[3], readFlights[4], readFlights[5], readFlights[6], readFlights[7], Integer.valueOf(readFlights[8]), Integer.valueOf(readFlights[9]), Integer.valueOf(readFlights[10]), readFlights[11], readFlights[12], Integer.valueOf(readFlights[13]), Integer.valueOf(readFlights[14]), Integer.valueOf(readFlights[15]), Integer.valueOf(readFlights[16]), Integer.valueOf(readFlights[17]), Integer.valueOf(readFlights[18]), Integer.valueOf(readFlights[19])));
        }
        Buffreader.close();
        //Clears Log File
        PrintWriter pWriter = new PrintWriter("Log.txt");
        pWriter.print("");
        pWriter.close();

        Scanner scnr = new Scanner(System.in);
        String input = "";
        System.out.println("Hello, Welcome to MinerAir! \nPlease input a Flight ID to see more information about this flight.");
        
        //User interaction
        while(!input.toLowerCase().equals("end")){
            input = scnr.nextLine();
            int currIdx = -1; //Idx of flight that was accessed
            for(int i = 0; i < Flights.size(); i++){
                if(Flights.get(i).getID().equals(input)){
                    currIdx = i;     
                }
            }
            if(currIdx == -1){
                System.out.println("This is not a valid Flight ID, please try again."); //If ID doesn't exist
                continue;
            }
            while(!input.toLowerCase().equals("end")){
                System.out.println("\nInput the corresponding number if you'd like to access any of of these attributes.\nType 'End' to terminate the program");
                System.out.println("\n1.Show Flight Information \n2.Return Any Specific Attribute About the Flight\n3.Update Flight Attributes");
                input = scnr.nextLine();
                while(!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.toLowerCase().equals("end")){
                    System.out.println("Please input a correct number.");
                    input = scnr.nextLine();    
                }
                if(input.equals("1")){
                    System.out.println("");
                    Flights.get(currIdx).printFlight();
                }
                if(input.equals("2")){
                    System.out.println("\nWhich attribute would you like to see?");
                    System.out.println("1.Origin Airport\n2.Origin Code\n3.Destination Airport\n4.Destination Code\n5.Departure Date\n6.Departure Time\n7.Arrival Time\n8.Arrival Date\n9.Duration\n10.Distance\n11.Time Zone Difference\n12.First Class Price\n13.Business Class Price\n14.Main Cabin Price\n15.First Class Seats\n16.Business Class Seats\n17.Main Cabin Seats\n18.Total Seats");
                    input = scnr.nextLine();
                    switch(input){
                        case "1": 
                            System.out.println(Flights.get(currIdx).getOriginAirport());
                            break;
                        case "2": 
                            System.out.println(Flights.get(currIdx).getOriginCode());
                            break;
                        case "3":
                            System.out.println(Flights.get(currIdx).getDestinationAirport());
                            break;
                        case "4":
                            System.out.println(Flights.get(currIdx).getDestinationCode());
                            break;
                        case "5":
                            System.out.println(Flights.get(currIdx).getDepartureDate());
                            break; 
                        case "6":
                            System.out.println(Flights.get(currIdx).getDepartureTime());
                            break;
                        case "7":
                            System.out.println(Flights.get(currIdx).getArrivalTime());
                            break;
                        case "8":
                            System.out.println(Flights.get(currIdx).getArrivalDate());
                            break;          
                        case "9":
                            System.out.println(Flights.get(currIdx).getDuration());
                            break;
                        case "10":
                            System.out.println(Flights.get(currIdx).getDistance());
                            break;
                        case "11":
                            System.out.println(Flights.get(currIdx).getTimeZoneDiff());
                            break;
                        case "12":
                            System.out.println(Flights.get(currIdx).getFirstClassPrice());
                            break;
                        case "13":
                            System.out.println(Flights.get(currIdx).getBusinessClassPrice());
                            break;
                        case "14":
                            System.out.println(Flights.get(currIdx).getMainCabinPrice());
                            break;
                        case "15":
                            System.out.println(Flights.get(currIdx).getFirstClassSeats());
                            break;
                        case "16":
                            System.out.println(Flights.get(currIdx).getBusinessSeats());
                            break;
                        case "17":
                            System.out.println(Flights.get(currIdx).getMainCabinSeats());
                            break;
                        case "18":
                            System.out.println(Flights.get(currIdx).getTotalSeats());
                            break;
                        default: 
                            System.out.println("Please input a correct number.");
                    }
                }
                if(input.equals("3")){
                    System.out.println("\nWhich attribute would you like to change?");
                    System.out.println("1.Origin Airport\n2.Origin Code\n3.Destination Airport\n4.Destination Code\n5.Departure Date\n6.Departure Time\n7.First Class Price\n8.Business Class Price\n9.Main Cabin Price");
                    input = scnr.nextLine();
                    switch(input){
                        case "1":
                            System.out.println("What would you like to change the Origin Airport to?");
                            input = scnr.nextLine();
                            Flights.get(currIdx).setOriginAirport(input);
                            buffWriter.write("Flight ID " + Flights.get(currIdx).getID() + " update Origin Airport to " + Flights.get(currIdx).getOriginAirport() +"\n");
                            break;
                        case "2": 
                            System.out.println("What would you like to change the Origin Code to?");
                            input = scnr.nextLine();
                            Flights.get(currIdx).setOriginCode(input);
                            buffWriter.write("Flight ID " + Flights.get(currIdx).getID() + " update Origin Code to " + Flights.get(currIdx).getOriginCode()+"\n");
                            break;
                        case "3":
                            System.out.println("What would you like to change the Destination Airport to?");
                            input = scnr.nextLine();
                            Flights.get(currIdx).setDestinationAirport(input);
                            buffWriter.write("Flight ID " + Flights.get(currIdx).getID() + " update Destination Airport to " + Flights.get(currIdx).getDestinationAirport()+"\n");
                            break;
                        case "4":
                            System.out.println("What would you like to change the Destination Code to?");
                            input = scnr.nextLine();
                            Flights.get(currIdx).setDestinationCode(input);
                            buffWriter.write("Flight ID " + Flights.get(currIdx).getID() + " update Destination Code to " + Flights.get(currIdx).getDestinationCode()+"\n");
                            break;
                        case "5":
                            System.out.println("What would you like to change the Departure Date to?");
                            input = scnr.nextLine();
                            Flights.get(currIdx).setDepartureDate(input);
                            buffWriter.write("Flight ID " + Flights.get(currIdx).getID() + " update Departure Date to " + Flights.get(currIdx).getDepartureDate()+"\n");
                            break;
                        case "6":
                            System.out.println("What would you like to change the Departure Time to?");
                            input = scnr.nextLine();
                            Flights.get(currIdx).setDepartureTime(input);
                            buffWriter.write("Flight ID " + Flights.get(currIdx).getID() + " update Departure Time to " + Flights.get(currIdx).getDepartureTime()+"\n");
                            break;
                        case "7":
                            System.out.println("What would you like to change the First Class Price to?");
                            input = scnr.nextLine();
                            Flights.get(currIdx).setFirstClassPrice(Integer.valueOf(input));
                            buffWriter.write("Flight ID " + Flights.get(currIdx).getID() + " update First Class Price to " + Flights.get(currIdx).getFirstClassPrice()+"\n");
                            break;
                        case "8":
                            System.out.println("What would you like to change the Business Class Price to?");
                            input = scnr.nextLine();
                            Flights.get(currIdx).setBusinessClassPrice(Integer.valueOf(input));
                            buffWriter.write("Flight ID " + Flights.get(currIdx).getID() + " update Business Class Price to " + Flights.get(currIdx).getBusinessClassPrice()+"\n");
                            break;         
                        case "9":
                            System.out.println("What would you like to change the Main Cabin Price to?");
                            input = scnr.nextLine();
                            Flights.get(currIdx).setMainCabinPrice(Integer.valueOf(input));
                            buffWriter.write("Flight ID " + Flights.get(currIdx).getID() + " update Main Cabin Price to " + Flights.get(currIdx).getMainCabinPrice()+"\n");
                            break;
                        default:
                            System.out.println("Please input a correct number.");
                    }   
                }
            }
            
        }
        scnr.close();
        buffWriter.close();



        
    }
}
