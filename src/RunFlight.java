/* Enrique Munoz
 * 2/28/2023
 * Adv. Object Oriented Programming CS3331, Dr. Mejia
 * Programming Assignment 2
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
import java.util.Random;



public class RunFlight{
    public static void main(String[] args){
        //Initializes database for domestic and international flights, including customers and employees
        GenerateDatabase database = new GenerateDatabase();
        database.setDomesticInternationMap();
        database.setPeopleMap();
        
        Scanner scnr = new Scanner(System.in);
        String userInput = "";
        
        //User Interaction
        while(!userInput.toLowerCase().equals("exit")){
            //String currentUser = loginMenu(database.getCustomerMap(),database.getEmployeeMap()); //Erase later
            String currentUser = scnr.nextLine();
            String currFlightID;
            String typeOfFlight;
            System.out.println("Welcome " + currentUser + "!\n");
            if(database.getCustomerMap().containsKey(currentUser)){
                while(!userInput.toLowerCase().equals("back")){
                    System.out.println("\nWhich menu would you like to access.\n1. Purchase Menu \n2. Ticket Cancel Menu \nType 'Back' to logout of your account.\n");
                    userInput = scnr.nextLine();
                    if(userInput.equals("1")){
                        String[] idAndFlightType = searchFlights(database.getInternationalFlightMap(), database.getDomesticFlightMap());
                        currFlightID = idAndFlightType[0];
                        typeOfFlight = idAndFlightType[1];
                        purchaseMenu(database.getInternationalFlightMap(), database.getDomesticFlightMap(), database.getCustomerMap(), currentUser, currFlightID, typeOfFlight);
                    }else if(userInput.equals("2")){
                        cancelTicket(database.getInternationalFlightMap(), database.getDomesticFlightMap(), database.getCustomerMap(), currentUser);
                    }
                }
            }else if(database.getEmployeeMap().containsKey(currentUser)){
                while(!userInput.toLowerCase().equals("back")){
                    String[] idAndFlightType = searchFlights(database.getInternationalFlightMap(), database.getDomesticFlightMap());
                    currFlightID = idAndFlightType[0];
                    typeOfFlight = idAndFlightType[1];
                    while(!userInput.toLowerCase().equals("back")){
                        System.out.println("\nWhich menu would you like to access.\n1.View Flight Information \n2.Flight Cancel Menu \n3.Flight Revenue MenuType\nType 'Back' to search for another Flight ID.\n");
                        userInput = scnr.nextLine();
                        if(userInput.equals("1")){
                            viewFlight(database.getInternationalFlightMap(), database.getDomesticFlightMap(), currFlightID, typeOfFlight);
                        }else if(userInput.equals("2")){
                            cancelTicket(database.getInternationalFlightMap(), database.getDomesticFlightMap(), database.getCustomerMap(), currentUser);
                        }
                    }
                }
            }
            System.out.println("\nYou have been logged out of your account.\nType 'Exit' if you wish to end the program, or type 'Enter' to login again.\n");
            userInput = scnr.nextLine();
        }
        scnr.close();
    }

    //User Login Interaction Method
    public static String loginMenu(HashMap<String,Customer> customerMap, HashMap<String,Employee> employeeMap){
        Scanner scnr = new Scanner(System.in);
        System.out.println("\nHello Welcome to MinerAir, are you an individual customer?");
        String userInput = scnr.nextLine();
        String currUser = "";
        if(userInput.toLowerCase().equals("yes")){
            while(!customerMap.containsKey(currUser)){
                System.out.println("\nPlease enter your first and last name. Example: John Doe");
                currUser = scnr.nextLine();
                if(customerMap.containsKey(currUser)){
                    System.out.println("\nPlease enter your account's username");
                    while(!customerMap.get(currUser).getUsername().equals(userInput)){
                        userInput = scnr.nextLine();
                        if(customerMap.get(currUser).getUsername().equals(userInput)){
                            int numOfTries = 0; //Number of tries before user gets logged out because of incorrect password attempts
                            while(numOfTries < 3){
                                System.out.println("Please enter your password.");
                                userInput = scnr.nextLine();
                                if(customerMap.get(currUser).getPassword().equals(userInput)){
                                    System.out.println("\nWelcome " + currUser + "! \n");
                                    return currUser;
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
            while(!employeeMap.containsKey(currUser)){
                System.out.println("\nPlease enter your first and last name. Example: John Doe");
                currUser = scnr.nextLine();
                if(employeeMap.containsKey(currUser)){
                    System.out.println("\nPlease enter your account's username");
                    while(!employeeMap.get(currUser).getUsername().equals(userInput)){
                        userInput = scnr.nextLine();
                        if(employeeMap.get(currUser).getUsername().equals(userInput)){
                            int numOfTries = 0; //Number of tries before user gets logged out because of incorrect password attempts
                            while(numOfTries < 3){
                                System.out.println("Please enter your password.");
                                userInput = scnr.nextLine();
                                if(employeeMap.get(currUser).getPassword().equals(userInput)){
                                    System.out.println("\nWelcome " + currUser + "! \n");
                                    return currUser;
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
        }
        return "";
    }

    public static String[] searchFlights(HashMap<String,International> internationalMap, HashMap<String,Domestic> domesticMap){
        System.out.println("Enter the Flight ID of a specific flight.");
        Scanner scnr = new Scanner(System.in);
        String userInput = "";
        boolean flightExist = false;
        String[] result = new String[2];
        while(!flightExist){
            userInput = scnr.nextLine();
            if(internationalMap.containsKey(userInput)){
                result[0] = String.valueOf(userInput);
                result[1] = "International";
                return result;
            }else if(domesticMap.containsKey(userInput)){
                result[0] = String.valueOf(userInput);
                result[1] = "Domestic";
                return result;
            }
            System.out.println("Incorrect Flight ID, please try again.");
        }
        return result;
    }

    //User Flight Menu Interaction Method
    public static void purchaseMenu(HashMap<String,International> internationalMap, HashMap<String,Domestic> domesticMap, HashMap<String,Customer> customerMap, String customerName, String flightID, String flightType){
        Scanner scnr = new Scanner(System.in);
        String userInput = "";
        Customer currUser = customerMap.get(customerName);
        while(!userInput.toLowerCase().equals("exit")){
            //Domestic Flight Purchase Menu
            if(flightType.equals("Domestic")){
                Domestic currDomesticFlight = domesticMap.get(flightID);
                System.out.println("\nFlight ID: " + flightID + ", " + currDomesticFlight.getOriginAirport() + " to " + currDomesticFlight.getDestinationAirport());
                while(!userInput.toLowerCase().equals("back")){
                    System.out.println("\nEnter the number for the type of ticket you would like to purchase.\n1. First Class $" + currDomesticFlight.getFirstClassPrice() + "\n2. Business Class $" + currDomesticFlight.getBusinessClassPrice() + "\n3. Main Cabin $" + currDomesticFlight.getMainCabinPrice() + "\n\nOr type 'Back' in order to go back to the Purchase Menu.\n");
                    int numTickets = 0;
                    int totalPrice = 0;
                    Random random = new Random();
                    int confirmationNum = random.nextInt(1000000); //Generates random confirmation number
                    userInput = scnr.nextLine();
                    switch(userInput){
                        case "1": //First Class Interaction
                            System.out.println("How many First Class Tickets do you want to buy?");
                            numTickets = scnr.nextInt();
                            scnr.nextLine(); //Skips line since previous line was int
                            if(numTickets < 1 || numTickets > 8){
                                System.out.println("Only 1-8 number of tickets are purchasable per transaction.");
                                break;
                            }
                            if(numTickets > currDomesticFlight.getFirstClassSeats()){
                                System.out.println("There is not enough seats in this section, try looking for another section.");
                            }
                            totalPrice = numTickets * currDomesticFlight.getFirstClassPrice();
                            if(currUser.getMoney() - totalPrice < 0){
                                System.out.println("Sorry, but you do not have enough money for this purchase");
                                break;
                            }
                            System.out.println("The total price of this transaction is $" + totalPrice + ", type 'Confirm' if you would like to proceed.");
                            userInput = scnr.nextLine();
                            if(userInput.toLowerCase().equals("confirm")){
                                currDomesticFlight.setTotalSeats(currDomesticFlight.getTotalSeats() - numTickets); //Changes the total number of seats available after purchase
                                currDomesticFlight.setFirstClassSeats((currDomesticFlight.getFirstClassSeats() - numTickets)); //Changes the total number of first class seats available after purchase
                                currUser.setMoney(currUser.getMoney() - totalPrice); //Subtracts total purchase price from users money amount
                                boolean flightAlreadyAdded = false; //Variable to see if flight was already purchased
                                for(int i = 0; i < currUser.getTicketsPurchased().size();i++){ //Updates the flight purchased attribute of Customer
                                    if(currUser.getTicketsPurchased().get(i).getFlightID().equals(flightID)){
                                        flightAlreadyAdded = true;
                                    }  
                                }
                                currUser.getTicketsPurchased().add(new Ticket(totalPrice, numTickets, confirmationNum, numTickets, 0, 0, numTickets, currUser, currDomesticFlight.getID())); //Adds ticket object to the arraylist of tickets in the custmer obj
                                currDomesticFlight.getTicketList().add(new Ticket(totalPrice, numTickets, confirmationNum, numTickets, 0, 0, numTickets, currUser, currDomesticFlight.getID())); //Adds ticket object to the ArrayList of tickets in flight obj
                                if(!flightAlreadyAdded){
                                    currUser.setFlightsPurchased(currUser.getFlightsPurchased()+1);
                                }
                                System.out.println("Your account balance after this transaction is $" +currUser.getMoney());
                            }else{
                                System.out.println("The payment process has been stopped.");
                            }
                            break;
                        case "2": //Business Class Interaction
                            System.out.println("How many Business Class Tickets do you want to buy?");
                            numTickets = scnr.nextInt();
                            scnr.nextLine(); //Skips line since previous line was int
                            if(numTickets < 1 || numTickets > 8){
                                System.out.println("Only 1-8 number of tickets are purchasable per transaction.");
                                break;
                            }
                            if(numTickets > currDomesticFlight.getBusinessSeats()){
                                System.out.println("There is not enough seats in this section, try looking for another section.");
                            }
                            totalPrice = numTickets * currDomesticFlight.getBusinessClassPrice();
                            if(currUser.getMoney() - totalPrice < 0){
                                System.out.println("Sorry, but you do not have enough money for this purchase");
                                break;
                            }
                            System.out.println("The total price of this transaction is $" + totalPrice + ", type 'Confirm' if you would like to proceed.");
                            userInput = scnr.nextLine();
                            if(userInput.toLowerCase().equals("confirm")){
                                currDomesticFlight.setTotalSeats(currDomesticFlight.getTotalSeats() - numTickets); //Changes the total number of seats available after purchase
                                currDomesticFlight.setBusinessClassSeats((currDomesticFlight.getBusinessSeats() - numTickets)); //Changes the total number of second class seats available after purchase
                                currUser.setMoney(currUser.getMoney() - totalPrice); //Subtracts total purchase price from users money amount
                                boolean flightAlreadyAdded = false; //Variable to see if flight was already purchased
                                for(int i = 0; i < currUser.getTicketsPurchased().size();i++){ //Updates the flight purchased attribute of Customer
                                    if(currUser.getTicketsPurchased().get(i).getFlightID().equals(flightID)){
                                        flightAlreadyAdded = true;
                                    }  
                                }
                                currUser.getTicketsPurchased().add(new Ticket(totalPrice, numTickets, confirmationNum, 0, numTickets, 0, numTickets, currUser, currDomesticFlight.getID())); //Adds ticket object to the ArrayList of tickets in the custmer obj
                                currDomesticFlight.getTicketList().add(new Ticket(totalPrice, numTickets, confirmationNum, 0, numTickets, 0, numTickets, currUser, currDomesticFlight.getID())); //Adds ticket object to the ArrayList of tickets in flight obj
                                if(!flightAlreadyAdded){
                                    currUser.setFlightsPurchased(currUser.getFlightsPurchased()+1);
                                }
                                System.out.println("Your account balance after this transaction is $" +currUser.getMoney());
                            }else{
                                System.out.println("The payment process has been stopped.");
                            }
                        case "3": //Main Cabin Interaction
                            System.out.println("How many Main Cabin Tickets do you want to buy?");
                            numTickets = scnr.nextInt();
                            scnr.nextLine(); //Skips line since previous line was int
                            if(numTickets < 1 || numTickets > 8){
                                System.out.println("Only 1-8 number of tickets are purchasable per transaction.");
                                break;
                            }
                            if(numTickets > currDomesticFlight.getMainCabinSeats()){
                                System.out.println("There is not enough seats in this section, try looking for another section.");
                            }
                            totalPrice = numTickets * currDomesticFlight.getMainCabinPrice();
                            if(currUser.getMoney() - totalPrice < 0){
                                System.out.println("Sorry, but you do not have enough money for this purchase");
                                break;
                            }
                            System.out.println("The total price of this transaction is $" + totalPrice + ", type 'Confirm' if you would like to proceed.");
                            userInput = scnr.nextLine();
                            if(userInput.toLowerCase().equals("confirm")){
                                currDomesticFlight.setTotalSeats(currDomesticFlight.getTotalSeats() - numTickets); //Changes the total number of seats available after purchase
                                currDomesticFlight.setMainCabinSeats((currDomesticFlight.getMainCabinSeats() - numTickets)); //Changes the total number of second class seats available after purchase
                                currUser.setMoney(currUser.getMoney() - totalPrice); //Subtracts total purchase price from users money amount
                                boolean flightAlreadyAdded = false; //Variable to see if flight was already purchased
                                for(int i = 0; i < currUser.getTicketsPurchased().size();i++){ //Updates the flight purchased attribute of Customer
                                    if(currUser.getTicketsPurchased().get(i).getFlightID().equals(flightID)){
                                        flightAlreadyAdded = true;
                                    }  
                                }
                                currUser.getTicketsPurchased().add(new Ticket(totalPrice, numTickets, confirmationNum, 0, 0, numTickets, numTickets, currUser, currDomesticFlight.getID())); //Adds ticket object to the ArrayList of tickets in the custmer obj
                                currDomesticFlight.getTicketList().add(new Ticket(totalPrice, numTickets, confirmationNum, 0, 0, numTickets, numTickets, currUser, currDomesticFlight.getID())); //Adds ticket object to the ArrayList of tickets in flight obj
                                if(!flightAlreadyAdded){
                                    currUser.setFlightsPurchased(currUser.getFlightsPurchased()+1);
                                }
                                System.out.println("Your account balance after this transaction is $" +currUser.getMoney());
                            }else{
                                System.out.println("The payment process has been stopped.");
                            }
                            break;
                    }
                }
            //International Flight Purchase Menu
            }else if(flightType.equals("International")){
                International currInternationalFlight = internationalMap.get(flightID);
                System.out.println("\nFlight ID: " + flightID + ", " + currInternationalFlight.getOriginAirport() + " to " + currInternationalFlight.getDestinationAirport());
                while(!userInput.toLowerCase().equals("back")){
                    System.out.println("\nEnter the number for the type of ticket you would like to purchase.\n1. First Class $" + currInternationalFlight.getFirstClassPrice() + "\n2. Business Class $" + currInternationalFlight.getBusinessClassPrice() + "\n3. Main Cabin $" + currInternationalFlight.getMainCabinPrice() + "\n\nOr type 'Back' in order to go back to the Purchase Menu.\n");
                    int numTickets = 0;
                    int totalPrice = 0 + currInternationalFlight.getSurcharge();
                    System.out.println("This flight is an International Flight and has a surcharge of $" + totalPrice + ".\n");
                    Random random = new Random();
                    int confirmationNum = random.nextInt(1000000); //Generates random confirmation number
                    userInput = scnr.nextLine();
                    switch(userInput){
                        case "1": //First Class Interaction
                            System.out.println("How many First Class Tickets do you want to buy?");
                            numTickets = scnr.nextInt();
                            scnr.nextLine(); //Skips line since previous line was int
                            if(numTickets < 1 || numTickets > 8){
                                System.out.println("Only 1-8 number of tickets are purchasable per transaction.");
                                break;
                            }
                            if(numTickets > currInternationalFlight.getFirstClassSeats()){
                                System.out.println("There is not enough seats in this section, try looking for another section.");
                            }
                            totalPrice += numTickets * currInternationalFlight.getFirstClassPrice();
                            if(currUser.getMoney() - totalPrice < 0){
                                System.out.println("Sorry, but you do not have enough money for this purchase");
                                break;
                            }
                            System.out.println("The total price of this transaction is $" + totalPrice + ", type 'Confirm' if you would like to proceed.");
                            userInput = scnr.nextLine();
                            if(userInput.toLowerCase().equals("confirm")){
                                currInternationalFlight.setTotalSeats(currInternationalFlight.getTotalSeats() - numTickets); //Changes the total number of seats available after purchase
                                currInternationalFlight.setFirstClassSeats((currInternationalFlight.getFirstClassSeats() - numTickets)); //Changes the total number of first class seats available after purchase
                                currUser.setMoney(currUser.getMoney() - totalPrice); //Subtracts total purchase price from users money amount
                                boolean flightAlreadyAdded = false; //Variable to see if flight was already purchased
                                for(int i = 0; i < currUser.getTicketsPurchased().size();i++){ //Updates the flight purchased attribute of Customer
                                    if(currUser.getTicketsPurchased().get(i).getFlightID().equals(flightID)){
                                        flightAlreadyAdded = true;
                                    }  
                                }
                                currUser.getTicketsPurchased().add(new Ticket(totalPrice, numTickets, confirmationNum, numTickets, 0, 0, numTickets, currUser, currInternationalFlight.getID())); //Adds ticket object to the arraylist of tickets in the custmer obj
                                currInternationalFlight.getTicketList().add(new Ticket(totalPrice, numTickets, confirmationNum, numTickets, 0, 0, numTickets, currUser, currInternationalFlight.getID())); //Adds ticket object to the ArrayList of tickets in flight obj
                                if(!flightAlreadyAdded){
                                    currUser.setFlightsPurchased(currUser.getFlightsPurchased()+1);
                                }
                                System.out.println("Your account balance after this transaction is $" +currUser.getMoney());
                            }else{
                                System.out.println("The payment process has been stopped.");
                            }
                            break;
                        case "2": //Business Class Interaction
                            System.out.println("How many Business Class Tickets do you want to buy?");
                            numTickets = scnr.nextInt();
                            scnr.nextLine(); //Skips line since previous line was int
                            if(numTickets < 1 || numTickets > 8){
                                System.out.println("Only 1-8 number of tickets are purchasable per transaction.");
                                break;
                            }
                            if(numTickets > currInternationalFlight.getBusinessSeats()){
                                System.out.println("There is not enough seats in this section, try looking for another section.");
                            }
                            totalPrice += numTickets * currInternationalFlight.getBusinessClassPrice();
                            if(currUser.getMoney() - totalPrice < 0){
                                System.out.println("Sorry, but you do not have enough money for this purchase");
                                break;
                            }
                            System.out.println("The total price of this transaction is $" + totalPrice + ", type 'Confirm' if you would like to proceed.");
                            userInput = scnr.nextLine();
                            if(userInput.toLowerCase().equals("confirm")){
                                currInternationalFlight.setTotalSeats(currInternationalFlight.getTotalSeats() - numTickets); //Changes the total number of seats available after purchase
                                currInternationalFlight.setBusinessClassSeats((currInternationalFlight.getBusinessSeats() - numTickets)); //Changes the total number of second class seats available after purchase
                                currUser.setMoney(currUser.getMoney() - totalPrice); //Subtracts total purchase price from users money amount
                                boolean flightAlreadyAdded = false; //Variable to see if flight was already purchased
                                for(int i = 0; i < currUser.getTicketsPurchased().size();i++){ //Updates the flight purchased attribute of Customer
                                    if(currUser.getTicketsPurchased().get(i).getFlightID().equals(flightID)){
                                        flightAlreadyAdded = true;
                                    }  
                                }
                                currUser.getTicketsPurchased().add(new Ticket(totalPrice, numTickets, confirmationNum, 0, numTickets, 0, numTickets, currUser, currInternationalFlight.getID())); //Adds ticket object to the ArrayList of tickets in the custmer obj
                                currInternationalFlight.getTicketList().add(new Ticket(totalPrice, numTickets, confirmationNum, 0, numTickets, 0, numTickets, currUser, currInternationalFlight.getID())); //Adds ticket object to the ArrayList of tickets in flight obj
                                if(!flightAlreadyAdded){
                                    currUser.setFlightsPurchased(currUser.getFlightsPurchased()+1);
                                }
                                System.out.println("Your account balance after this transaction is $" +currUser.getMoney());
                            }else{
                                System.out.println("The payment process has been stopped.");
                            }
                        case "3": //Main Cabin Interaction
                            System.out.println("How many Main Cabin Tickets do you want to buy?");
                            numTickets = scnr.nextInt();
                            scnr.nextLine(); //Skips line since previous line was int
                            if(numTickets < 1 || numTickets > 8){
                                System.out.println("Only 1-8 number of tickets are purchasable per transaction.");
                                break;
                            }
                            if(numTickets > currInternationalFlight.getMainCabinSeats()){
                                System.out.println("There is not enough seats in this section, try looking for another section.");
                            }
                            totalPrice += numTickets * currInternationalFlight.getMainCabinPrice();
                            if(currUser.getMoney() - totalPrice < 0){
                                System.out.println("Sorry, but you do not have enough money for this purchase");
                                break;
                            }
                            System.out.println("The total price of this transaction is $" + totalPrice + ", type 'Confirm' if you would like to proceed.");
                            userInput = scnr.nextLine();
                            if(userInput.toLowerCase().equals("confirm")){
                                currInternationalFlight.setTotalSeats(currInternationalFlight.getTotalSeats() - numTickets); //Changes the total number of seats available after purchase
                                currInternationalFlight.setMainCabinSeats((currInternationalFlight.getMainCabinSeats() - numTickets)); //Changes the total number of second class seats available after purchase
                                currUser.setMoney(currUser.getMoney() - totalPrice); //Subtracts total purchase price from users money amount
                                boolean flightAlreadyAdded = false; //Variable to see if flight was already purchased
                                for(int i = 0; i < currUser.getTicketsPurchased().size();i++){ //Updates the flight purchased attribute of Customer
                                    if(currUser.getTicketsPurchased().get(i).getFlightID().equals(flightID)){
                                        flightAlreadyAdded = true;
                                    }  
                                }
                                currUser.getTicketsPurchased().add(new Ticket(totalPrice, numTickets, confirmationNum, 0, 0, numTickets, numTickets, currUser, currInternationalFlight.getID())); //Adds ticket object to the ArrayList of tickets in the custmer obj
                                currInternationalFlight.getTicketList().add(new Ticket(totalPrice, numTickets, confirmationNum, 0, 0, numTickets, numTickets, currUser, currInternationalFlight.getID())); //Adds ticket object to the ArrayList of tickets in flight obj
                                if(!flightAlreadyAdded){
                                    currUser.setFlightsPurchased(currUser.getFlightsPurchased()+1);
                                }
                                System.out.println("Your account balance after this transaction is $" +currUser.getMoney());
                            }else{
                                System.out.println("The payment process has been stopped.");
                            }
                            break;
                    }
                }

            }
            System.out.println("\nPlease type 'Exit' if you wish the leave the purchase menu or press 'Enter' to make another purchase.");
            userInput = scnr.nextLine();
            System.out.println("");
        }
    }

    //Ticket Cancel Method
    public static void cancelTicket(HashMap<String,International> internationalMap, HashMap<String,Domestic> domesticMap, HashMap<String,Customer> customerMap, String customerName){
        Scanner scnr = new Scanner(System.in);
        String userInput = "";
        Customer currUser = customerMap.get(customerName);
        System.out.println(currUser.getFlightsPurchased());
        if(currUser.getFlightsPurchased() == 0){ //Returns users if no tickets have been purchased
            System.out.println("You have not purchased any tickets.\n");
            return;
        }
        System.out.println("These are all of the Flight ID in which you have purchased tickets for.");
        for(int i = 0; i < currUser.getTicketsPurchased().size(); i++){
            System.out.println("Flight ID: " + currUser.getTicketsPurchased().get(i).getFlightID() + " Confirmation Number: " + currUser.getTicketsPurchased().get(i).getConfirmationNum());
        }
        System.out.println("\nWhich ticket would you like to cancel. Please type the ID and Confirmation Number. Example: 2 78951\nType 'Back' to exit out of this cancelation.\n");
        userInput = scnr.nextLine();
        int idxOfTicket = 0;
        for(int i = 0; i < currUser.getTicketsPurchased().size(); i++){
            if(userInput == String.valueOf(currUser.getTicketsPurchased().get(i).getFlightID() + " " + currUser.getTicketsPurchased().get(i).getConfirmationNum())){
                idxOfTicket = i;
            }
        }
        String currFlightID = currUser.getTicketsPurchased().get(idxOfTicket).getFlightID();
        while(!userInput.toLowerCase().equals("exit")){
            if(internationalMap.containsKey(currFlightID)){
                System.out.println("Type 'confirm' you want to cancel this ticket or press 'Enter' to exit.");
                userInput = scnr.nextLine();
                if(userInput.toLowerCase().equals("confirm")){
                    internationalMap.get(currFlightID).setFirstClassSeats(internationalMap.get(currFlightID).getFirstClassSeats() + currUser.getTicketsPurchased().get(idxOfTicket).getFirstClassSeatsPurchased()); //Restores first class seats
                    internationalMap.get(currFlightID).setBusinessClassSeats(internationalMap.get(currFlightID).getBusinessSeats() + currUser.getTicketsPurchased().get(idxOfTicket).getBusinessClassSeatsPurchased()); //Restores business class seats
                    internationalMap.get(currFlightID).setMainCabinSeats(internationalMap.get(currFlightID).getMainCabinSeats() + currUser.getTicketsPurchased().get(idxOfTicket).getMainCabinSeatsPurchased()); //Restores main class seats
                    internationalMap.get(currFlightID).setTotalSeats(internationalMap.get(currFlightID).getTotalSeats() + currUser.getTicketsPurchased().get(idxOfTicket).getNumSeats()); //Restores total number of flight seats
                    customerMap.get(customerName).setMoney(customerMap.get(customerName).getMoney() + currUser.getTicketsPurchased().get(idxOfTicket).getPrice()); //Returns the users money
                    customerMap.get(customerName).getTicketsPurchased().remove(idxOfTicket); //Removes ticket from customer inventory
                    customerMap.get(customerName).setFlightsPurchased(customerMap.get(customerName).getFlightsPurchased()-1); //Updates customer flights purchased
                    System.out.println(" ");
                    break;
                }else{
                    break;
                }
            }else if(domesticMap.containsKey(currFlightID)){
                System.out.println("Type 'confirm' you want to cancel this ticket or press 'Enter' to exit.");
                userInput = scnr.nextLine();
                if(userInput.toLowerCase().equals("confirm")){
                    domesticMap.get(currFlightID).setFirstClassSeats(domesticMap.get(currFlightID).getFirstClassSeats() + currUser.getTicketsPurchased().get(idxOfTicket).getFirstClassSeatsPurchased()); //Restores first class seats
                    domesticMap.get(currFlightID).setBusinessClassSeats(domesticMap.get(currFlightID).getBusinessSeats() + currUser.getTicketsPurchased().get(idxOfTicket).getBusinessClassSeatsPurchased()); //Restores business class seats
                    domesticMap.get(currFlightID).setMainCabinSeats(domesticMap.get(currFlightID).getMainCabinSeats() + currUser.getTicketsPurchased().get(idxOfTicket).getMainCabinSeatsPurchased()); //Restores main class seats
                    domesticMap.get(currFlightID).setTotalSeats(domesticMap.get(currFlightID).getTotalSeats() + currUser.getTicketsPurchased().get(idxOfTicket).getNumSeats()); //Restores total number of flight seats
                    customerMap.get(customerName).setMoney(customerMap.get(customerName).getMoney() + currUser.getTicketsPurchased().get(idxOfTicket).getPrice()); //Returns the users money           
                    customerMap.get(customerName).getTicketsPurchased().remove(idxOfTicket); //Removes ticket from customer inventory
                    customerMap.get(customerName).setFlightsPurchased(customerMap.get(customerName).getFlightsPurchased()-1); //Updates customer flights purchased
                    System.out.println(" ");
                    break;
                }else{
                    break;
                } 
            }else{
                System.out.println("That is not an available ID, please try again.");
            }
        }
    }

    //View Specific Flight Method
    public static void viewFlight(HashMap<String,International> internationalMap, HashMap<String,Domestic> domesticMap, String flightID, String flightType){
        Scanner scnr = new Scanner(System.in);
        String userInput = "";
        if(flightType.equals("International")){
            internationalMap.get(flightID).printFlight();
            System.out.println("\nEnter the corresponding number to view a menu.\n1.Total Seats Remaining\n2.First Class Seats Remaining\n3.Business Class Seats Remaining\n4.Main Cabin Seats Remaining\n5.Customer Purchases\n");
            userInput = scnr.nextLine();
            switch(userInput){
                case "1": //Check total seats remaining
                    System.out.println("Total Seats Remaining: " + internationalMap.get(flightID).getTotalSeats());
                    break;
                case "2": //Check first class seats remaining
                    System.out.println("First Class Seats Remaining: " + internationalMap.get(flightID).getFirstClassSeats());
                    break;
                case "3": //Check business class seats remaining
                    System.out.println("Business Class Seats Remaining: " + internationalMap.get(flightID).getBusinessSeats());
                    break;
                case "4": //Check main cabin seats remaining
                    System.out.println("Main Cabin Class Seats Remaining: " + internationalMap.get(flightID).getMainCabinSeats());
                    break;
                case "5": //Check customers
                    ArrayList<Ticket> currTicketList = internationalMap.get(flightID).getTicketList();
                    for(int i = 0; i < currTicketList.size(); i++){
                        System.out.println("1." + currTicketList.get(i).getUser().getFirstName() + " " + currTicketList.get(i).getUser().getLastName() + "\n2.First Class Seats Purchased: " + currTicketList.get(i).getFirstClassSeatsPurchased() + "\n3.Business Class Seats Purchased: " + currTicketList.get(i).getBusinessClassSeatsPurchased() + "\n4.Main Cabin Seats Purchased: " + currTicketList.get(i).getMainCabinSeatsPurchased() + "\n5.Total Price $" + currTicketList.get(i).getPrice() + "\n");
                    }
                    break;
            }
        }else if(flightType.equals("Domestic")){
            domesticMap.get(flightID).printFlight();
            System.out.println("\nEnter the corresponding number to view a menu.\n1.Total Seats Remaining\n2.First Class Seats Remaining\n3.Business Class Seats Remaining\n4.Main Cabin Seats Remaining\n5.Customer Purchases\n");
            userInput = scnr.nextLine();
            switch(userInput){
                case "1": //Check total seats remaining
                    System.out.println("Total Seats Remaining: " + domesticMap.get(flightID).getTotalSeats());
                    break;
                case "2": //Check first class seats remaining
                    System.out.println("First Class Seats Remaining: " + domesticMap.get(flightID).getFirstClassSeats());
                    break;
                case "3": //Check business class seats remaining
                    System.out.println("Business Class Seats Remaining: " + domesticMap.get(flightID).getBusinessSeats());
                    break;
                case "4": //Check main cabin seats remaining
                    System.out.println("Main Cabin Class Seats Remaining: " + domesticMap.get(flightID).getMainCabinSeats());
                    break;
                case "5": //Check customers
                    ArrayList<Ticket> currTicketList = domesticMap.get(flightID).getTicketList();
                    for(int i = 0; i < currTicketList.size(); i++){
                        System.out.println("1." + currTicketList.get(i).getUser().getFirstName() + " " + currTicketList.get(i).getUser().getLastName() + "\n2.First Class Seats Purchased: " + currTicketList.get(i).getFirstClassSeatsPurchased() + "\n3.Business Class Seats Purchased: " + currTicketList.get(i).getBusinessClassSeatsPurchased() + "\n4.Main Cabin Seats Purchased: " + currTicketList.get(i).getMainCabinSeatsPurchased() + "\n5.Total Price $" + currTicketList.get(i).getPrice() + "\n");
                    }
                    break;
            }
        }
        System.out.println(" ");
        return;
    }

    //View Flight Revenue Method
     

}
