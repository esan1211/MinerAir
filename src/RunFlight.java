/* Enrique Munoz
 * 2/7/2023
 * Adv. Object Oriented Programming CS3331, Dr. Mejia
 * Programming Assignment 1
 * Uses Object-Oriented programming design in order to create a flight system with interacting customers
 * This work is to be done individually. It is not permitted to share, reproduce, or alter
    any part of this assignment for any purpose. Students are not permitted from
    sharing code, uploading this assignment online in any form, viewing, receiving, or
    modifying code written from anyone else. This assignment is part of an academic
    course at The University of Texas at El Paso and a grade will be assigned for the
    work produced individually by the student.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class RunFlight{
    public static void main(String[] args){
        ArrayList<Flight> Flights = new ArrayList<Flight>(); 
        
        //File Reading
        try{
            BufferedReader buffReader = new BufferedReader(new FileReader("FlightSchedule(1).csv"));
            String line = buffReader.readLine();
            ArrayList<String> lines = new ArrayList<>();
            while ((line = buffReader.readLine()) != null){
                lines.add(line);
                //System.out.print(line); //Test Print
            }
            //Populates ArrayList of Flights
            for(int i = 0; i < lines.size(); i++){ //Traverses through every line in csv ArrayList and creates a string array to split by commas and add new Flight obj to Flights ArrayList
                String[] readFlights = lines.get(i).split(",");
                Flights.add(new Flight(readFlights[0], readFlights[1], readFlights[2], readFlights[3], readFlights[4], readFlights[5], readFlights[6], readFlights[7], Integer.valueOf(readFlights[8]), Integer.valueOf(readFlights[9]), Integer.valueOf(readFlights[10]), readFlights[11], readFlights[12], Integer.valueOf(readFlights[13]), Integer.valueOf(readFlights[14]), Integer.valueOf(readFlights[15]), Integer.valueOf(readFlights[16]), Integer.valueOf(readFlights[17]), Integer.valueOf(readFlights[18]), Integer.valueOf(readFlights[19])));
        }
            buffReader.close();
        }catch(IOException e){
            System.out.println("The file cannot be found.");
        }

        for(int i = 0; i < Flights.size(); i++){ //Test to see if flights populated
            System.out.println(Flights.get(i).getOriginAirport());
        }

        //User Interaction
        Scanner scnr = new Scanner(System.in);
        System.out.println("Hello Welcome to MinerAir, are you an individual customer?");
        String userInput = scnr.nextLine();
        if(userInput.toLowerCase().equals("yes")){
            int incorrectTries = 0;
            while(incorrectTries < 3){
            System.out.println("Please enter your username.");
            }
            if(incorrectTries > 3){
                System.out.println("You have reached the max amount of tries, please try again another time.");
            }
        }else{
            System.out.println("Sorry, this system is for individual customers only.");    
        }
    
    }
}
