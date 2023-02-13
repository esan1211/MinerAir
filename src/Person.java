public abstract class Person {
    //Attributes
    private String firstName;
    private String lastName;
    
    //Constructors
    public Person(){
        
    }

    public Person(String firstNameIn, String lastNameIn){
        this.firstName = firstNameIn;
        this.lastName = lastNameIn;
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

}   
