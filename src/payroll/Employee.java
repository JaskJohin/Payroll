package payroll;

import java.util.ArrayList;

/**
 *
 * @author Alexandros Dimitrakopoulos
 */

//abstract υπερκλάση Employee
public abstract class Employee 
{
    private EmployeeType type; //Τύπος υπαλλήλου (Με την ώρα ή με το μήνα)
    private String name;
    private ArrayList<Project> projectList = new ArrayList<>(); //Η λίστα με τα projects
    
    //Constructor υπαλλήλλου με όνομα και τύπο μισθοδοσίας
    public Employee(String name, EmployeeType earnings) 
    {
        this.name = name;
        this.type = earnings;
    }
	
    public String getName() 
    {
        return name;
    }

    public EmployeeType getType() 
    {
        return type;
    }
    
    public void addProject(Project project)
    {
        projectList.add(project);
    }
}