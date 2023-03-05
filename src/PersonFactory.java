/* Enrique Munoz
 * 2/28/2023
 * Adv. Object Oriented Programming CS3331, Dr. Mejia
 * Programming Assignment 2
*/

public class PersonFactory {

    public PersonFactory(){

    }

    public Person createPerson(String type, String idIn, String firstNameIn, String lastNameIn, String dateOfBirthIn, String roleIn, double moneyIn, boolean minerAirMembershipIn, String usernameIn, String passwordIn){
        if(type.equals("Customer")){
            return new Customer(idIn, firstNameIn, lastNameIn, dateOfBirthIn, roleIn, moneyIn, 0, minerAirMembershipIn, usernameIn, passwordIn);
        }else{
            return new Employee(idIn, firstNameIn, lastNameIn, dateOfBirthIn, roleIn, moneyIn, minerAirMembershipIn, usernameIn, passwordIn);
        }
    }
    
}
