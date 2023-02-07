public class Employee extends Person{
    //Attributes
    private int salary;
    private String position;
    private String[] schedule = new String[7];
    
    //Constructors
    public Employee(){
    
    }

    public Employee(String firstName, String lastName, int salary, String position, String[] schedule){
        super(firstName, lastName);
        this.salary = salary;
        this.position = position;
        this.schedule = schedule;
    }

    //Getters & Setters
    public int getSalary(){
        return salary;
    }

    public void setSalary(int salary){
        this.salary = salary;
    }

    public String getPosition(){
        return position;
    }

    public void setPosition(String position){
        this.position = position;
    }

    public String[] getSchedule(){
        return schedule;
    }

    public void updateSchedule(String newSchedule, int day){
        this.schedule[day] = newSchedule;
    }
    
}
