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
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Random;



public class RunFlight{
    public static void main(String[] args){
        //ArrayList<Flight> Flights = new ArrayList<Flight>();
        HashMap<String,Flight> flightMap = new HashMap<String,Flight>();
        HashMap<String,Customer> customerMap = new HashMap<String,Customer>();
        
        //File Reading for Flight Schedule
        try{
            BufferedReader buffReader = new BufferedReader(new FileReader("FlightSchedule(1).csv"));
            String line = buffReader.readLine();
            ArrayList<String> lines = new ArrayList<>();
            while ((line = buffReader.readLine()) != null){
                lines.add(line);
            }
            //Populates a HashMap of Flights with ID as a key and Flight Obj as a value
            for(int i = 0; i < lines.size(); i++){ //Traverses through every line in csv ArrayList and creates a string array to split by commas and add new Flight obj to Flights ArrayList
                String[] readFlights = lines.get(i).split(",");
                flightMap.put(readFlights[0], new Flight(readFlights[0], readFlights[1], readFlights[2], readFlights[3], readFlights[4], readFlights[5], readFlights[6], readFlights[7], Integer.valueOf(readFlights[8]), Integer.valueOf(readFlights[9]), Integer.valueOf(readFlights[10]), readFlights[11], readFlights[12], Integer.valueOf(readFlights[13]), Integer.valueOf(readFlights[14]), Integer.valueOf(readFlights[15]), Integer.valueOf(readFlights[16]), Integer.valueOf(readFlights[17]), Integer.valueOf(readFlights[18]), Integer.valueOf(readFlights[19])));
            }
            buffReader.close();
        }catch(IOException e){
            System.out.println("The file cannot be found.");
        }

        //File Reading for Customer Schedule
        try{
            BufferedReader buffReader = new BufferedReader(new FileReader("CustomerListPA1.csv"));
            String line = buffReader.readLine();
            ArrayList<String> lines = new ArrayList<>();
            while ((line = buffReader.readLine()) != null){
                lines.add(line);
            }
            //Populates a HashMap of Customers 
            for(int i = 0; i < lines.size(); i++){ //Traverses through every line in csv ArrayList and creates a string array to split by commas and add new Flight obj to Flights ArrayList
                String[] readCustomers = lines.get(i).split(",");
                customerMap.put(readCustomers[1] + " " + readCustomers[2], new Customer(readCustomers[1], readCustomers[2], readCustomers[0], readCustomers[6], readCustomers[7], Double.valueOf(readCustomers[3])));
            }
            buffReader.close();
        }catch(IOException e){
            System.out.println("The file cannot be found.");
        }
        
        Scanner scnr = new Scanner(System.in);
        String userInput = "";
        
        //User Interaction
        while(!userInput.toLowerCase().equals("exit")){
            String customerName = loginMenu(customerMap);
            if(customerMap.containsKey(customerName)){
                flightMenu(flightMap, customerMap, customerName);
            }
            System.out.println("\nYou have been logged out of your account.\nType 'Exit' if you wish to end the program, or type 'Enter' to login again.\n");
            userInput = scnr.nextLine();
        }
        scnr.close();
    }

    //User Login Interaction Method
    public static String loginMenu(HashMap<String,Customer> customerMap){
        Scanner scnr = new Scanner(System.in);
        System.out.println("\nHello Welcome to MinerAir, are you an individual customer?");
        String userInput = scnr.nextLine();
        String customerName = "";
        if(userInput.toLowerCase().equals("yes")){
            while(!customerMap.containsKey(customerName)){
                System.out.println("\nPlease enter your first and last name. Example: John Doe");
                customerName = scnr.nextLine();
                if(customerMap.containsKey(customerName)){
                    System.out.println("\nPlease enter your account's username");
                    while(!customerMap.get(customerName).getUsername().equals(userInput)){
                        userInput = scnr.nextLine();
                        if(customerMap.get(customerName).getUsername().equals(userInput)){
                            int numOfTries = 0; //Number of tries before user gets logged out because of incorrect password attempts
                            while(numOfTries < 3){
                                System.out.println("Please enter your password.");
                                userInput = scnr.nextLine();
                                if(customerMap.get(customerName).getPassword().equals(userInput)){
                                    System.out.println("\nWelcome " + customerName + "! \n");
                                    return customerName;
                                }
                                numOfTries++;    
                            }
                            System.out.println("Max number of password attempts has been reached please try again later.");
                            return "";
                        }
                        else{
                            System.out.println("Incorrect username, please try again.");
                        }   
                    }
                }else{
                    System.out.println("Unfortunately, this name is not in our database. Please try again.");
                }
            }
        }else{
            System.out.println("Sorry, this system is for individual customers only.");    
        }
        return "";     
    }

    //User Flight Menu Interaction Method
    public static void flightMenu(HashMap<String,Flight> flightMap, HashMap<String,Customer> customerMap, String customerName){
        Scanner scnr = new Scanner(System.in);
        String userInput = "";
        while(!userInput.toLowerCase().equals("exit")){
            System.out.println("Enter the Flight ID of a specific flight.\n\nType 'Exit' if you'd like to exit the Main Menu.\n");
            userInput = scnr.nextLine();
            if(flightMap.containsKey(userInput)){
                String flightAccessed = userInput;
                while(!userInput.toLowerCase().equals("back")){
                    System.out.println("\nHere's information about this flight.");
                    flightMap.get(flightAccessed).printFlight();
                    System.out.println("\nEnter the number for the type of ticket you would like to purchase.\n1. First Class $" + flightMap.get(flightAccessed).getFirstClassPrice() +"\n2. Business Class $" + flightMap.get(flightAccessed).getBusinessClassPrice() + "\n3. Main Cabin $" + flightMap.get(flightAccessed).getMainCabinPrice() + "\n\nOr type 'Back' in order to go back to the Main Menu.\n");
                    userInput = scnr.nextLine();
                    int numTickets = 0;
                    int totalPrice = 0;
                    Random random = new Random();
                    int confirmationNum = random.nextInt(1000000); //Generates random confirmation number
                    switch(userInput){
                        case "1": //First Class Interaction
                            System.out.println("How many First Class Tickets do you want to buy?");
                            numTickets = scnr.nextInt();
                            scnr.nextLine(); //Skips line since previous line was int
                            if(numTickets < 1 || numTickets > 6){
                                System.out.println("Only 1-6 number of tickets are purchasable per transaction.");
                                break;
                            }
                            if(numTickets > flightMap.get(flightAccessed).getFirstClassSeats()){
                                System.out.println("There is not enough seats in this section, try looking for another section.");
                            }
                            totalPrice = numTickets * flightMap.get(flightAccessed).getFirstClassPrice();
                            if(customerMap.get(customerName).getMoney() - totalPrice < 0){
                                System.out.println("Sorry, but you do not have enough money for this purchase");
                                break;
                            }
                            flightMap.get(flightAccessed).setTotalSeats(flightMap.get(flightAccessed).getTotalSeats() - numTickets); //Changes the total number of seats available after purchase
                            flightMap.get(flightAccessed).setFirstClassSeats((flightMap.get(flightAccessed).getFirstClassSeats() - numTickets)); //Changes the total number of first class seats available after purchase
                            customerMap.get(customerName).setMoney(customerMap.get(customerName).getMoney() - totalPrice); //Subtracts total purchase price from users money amount
                            customerMap.get(customerName).getTicketsPurchased().add(new Ticket(totalPrice, numTickets, confirmationNum, numTickets)); //Adds ticket object to the arraylist of tickets in the custmer obj
                            flightMap.get(flightAccessed).getTicketList().add(new Ticket(totalPrice, numTickets, confirmationNum, numTickets)); //Adds ticket object to the ArrayList of tickets in flight obj
                            System.out.println("Your account balance after this transaction is $" +customerMap.get(customerName).getMoney());
                            break;
                        case "2": //Business Class Interaction
                            System.out.println("How many Business Class Tickets do you want to buy?");
                            numTickets = scnr.nextInt();
                            scnr.nextLine(); //Skips line since previous line was int
                            if(numTickets < 1 || numTickets > 6){
                                System.out.println("Only 1-6 number of tickets are purchasable per transaction.");
                                break;
                            }
                            if(numTickets > flightMap.get(flightAccessed).getBusinessSeats()){
                                System.out.println("There is not enough seats in this section, try looking for another section.");
                            }
                            totalPrice = numTickets * flightMap.get(flightAccessed).getBusinessClassPrice();
                            if(customerMap.get(customerName).getMoney() - totalPrice < 0){
                                System.out.println("Sorry, but you do not have enough money for this purchase");
                                break;
                            }
                            flightMap.get(flightAccessed).setTotalSeats(flightMap.get(flightAccessed).getTotalSeats() - numTickets); //Changes the total number of seats available after purchase
                            flightMap.get(flightAccessed).setBusinessClassSeats((flightMap.get(flightAccessed).getBusinessSeats() - numTickets)); //Changes the total number of second class seats available after purchase
                            customerMap.get(customerName).setMoney(customerMap.get(customerName).getMoney() - totalPrice); //Subtracts total purchase price from users money amount
                            customerMap.get(customerName).getTicketsPurchased().add(new Ticket(totalPrice, numTickets, confirmationNum, numTickets)); //Adds ticket object to the ArrayList of tickets in the custmer obj
                            flightMap.get(flightAccessed).getTicketList().add(new Ticket(totalPrice, numTickets, confirmationNum, numTickets)); //Adds ticket object to the ArrayList of tickets in flight obj
                            System.out.println("Your account balance after this transaction is $" +customerMap.get(customerName).getMoney());
                            break;
                        case "3": //Main Cabin Interaction
                            System.out.println("How many Main Cabin Tickets do you want to buy?");
                            numTickets = scnr.nextInt();
                            scnr.nextLine(); //Skips line since previous line was int
                            if(numTickets < 1 || numTickets > 6){
                                System.out.println("Only 1-6 number of tickets are purchasable per transaction.");
                                break;
                            }
                            if(numTickets > flightMap.get(flightAccessed).getMainCabinSeats()){
                                System.out.println("There is not enough seats in this section, try looking for another section.");
                            }
                            totalPrice = numTickets * flightMap.get(flightAccessed).getMainCabinPrice();
                            if(customerMap.get(customerName).getMoney() - totalPrice < 0){
                                System.out.println("Sorry, but you do not have enough money for this purchase");
                                break;
                            }
                            flightMap.get(flightAccessed).setTotalSeats(flightMap.get(flightAccessed).getTotalSeats() - numTickets); //Changes the total number of seats available after purchase
                            flightMap.get(flightAccessed).setMainCabinSeats((flightMap.get(flightAccessed).getMainCabinSeats() - numTickets)); //Changes the total number of second class seats available after purchase
                            customerMap.get(customerName).setMoney(customerMap.get(customerName).getMoney() - totalPrice); //Subtracts total purchase price from users money amount
                            customerMap.get(customerName).getTicketsPurchased().add(new Ticket(totalPrice, numTickets, confirmationNum, numTickets)); //Adds ticket object to the ArrayList of tickets in the custmer obj
                            flightMap.get(flightAccessed).getTicketList().add(new Ticket(totalPrice, numTickets, confirmationNum, numTickets)); //Adds ticket object to the ArrayList of tickets in flight obj
                            System.out.println("Your account balance after this transaction is $" +customerMap.get(customerName).getMoney());
                            break;
                    }
                }
            }else if(!userInput.toLowerCase().equals("exit")){
                System.out.println("This flight does not exist, try again.");
            }       
        }

    }

}
