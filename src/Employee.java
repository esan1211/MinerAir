public class Employee extends Person{
    //Attributes
    private int salary;
    private String position;
    private String[] schedule = new String[7];
    
    //Constructors
    public Employee(){
    
    }

    public Employee(String idIn, String firstNameIn, String lastNameIn, String dateOfBirthIn, String roleIn, double moneyIn, boolean minerAirMembershipIn, String usernameIn, String passwordIn){
        super(idIn, firstNameIn, lastNameIn, dateOfBirthIn, roleIn, moneyIn, minerAirMembershipIn, usernameIn, passwordIn);
    }

    //Getters & Setters
    public int getSalary(){
        return salary;
    }

    public void setSalary(int salaryIn){
        this.salary = salaryIn;
    }

    public String getPosition(){
        return position;
    }

    public void setPosition(String positionIn){
        this.position = positionIn;
    }

    public String[] getSchedule(){
        return schedule;
    }

    public void updateSchedule(String newSchedule, int day){
        this.schedule[day] = newSchedule;
    }
    
}
