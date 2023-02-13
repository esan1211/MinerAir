public class Employee extends Person{
    //Attributes
    private int salary;
    private String position;
    private String[] schedule = new String[7];
    
    //Constructors
    public Employee(){
    
    }

    public Employee(String firstNameIn, String lastNameIn, int salaryIn, String positionIn, String[] scheduleIn){
        super(firstNameIn, lastNameIn);
        this.salary = salaryIn;
        this.position = positionIn;
        this.schedule = scheduleIn;
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
