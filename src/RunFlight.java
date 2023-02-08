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
            }
            
        }catch(IOException e){
            System.out.println("The file cannot be found.");
        }
    }
}
