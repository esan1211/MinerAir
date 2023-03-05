/* Enrique Munoz
 * 2/28/2023
 * Adv. Object Oriented Programming CS3331, Dr. Mejia
 * Programming Assignment 2
*/

public abstract class Person {
    //Attributes
    private String firstName;
    private String lastName;
    private String role;
    private String id;
    private String username;
    private String password;
    private boolean minerAirMembership;
    private double money;
    private String dateOfBirthIn;
    
    //Constructors
    public Person(){
        
    }

    public Person(String idIn, String firstNameIn, String lastNameIn, String dateOfBirthIn, String roleIn, double moneyIn, boolean minerAirMembershipIn, String usernameIn, String passwordIn){
        this.firstName = firstNameIn;
        this.lastName = lastNameIn;
        this.dateOfBirthIn = dateOfBirthIn;
        this.role = roleIn;
        this.money = moneyIn;
        this.minerAirMembership = minerAirMembershipIn;
        this.username = usernameIn;
        this.password = passwordIn;
    }

    //Getters & Setters
    public String getFirstName(){
        return firstName;
    }


    public void setFirstName(String firstNameIn){
        this.firstName = firstNameIn;
    }


    public String getLastName(){
        return lastName;
    }


    public void setLastName(String lastNameIn){
        this.lastName = lastNameIn;
    }

    public String getRole(){
        return role;
    }

    public void role(String roleIn){
        this.role = roleIn;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String usernameIn){
        this.username = usernameIn;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String passwordIn){
        this.password = passwordIn;
    }

    public String getID(){
        return id;
    }

    public void setID(String idIn){
        this.id = idIn;
    }

    public boolean isMinerAirMembership(){
        return minerAirMembership;
    }

    public void setMinerAirMembership(boolean minerAirMembership){
        this.minerAirMembership = minerAirMembership;
    }

    public double getMoney(){
        return money;
    }

    public void setMoney(double money){
        this.money = money;
    }

    public String getDateOfBirthIn(){
        return dateOfBirthIn;
    }

    public void setDateOfBirthIn(String dateOfBirthIn){
        this.dateOfBirthIn = dateOfBirthIn;
    }
    
}   
