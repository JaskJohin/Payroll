package payroll;

import java.util.ArrayList;

/**
 *
 * @author Alexandros Dimitrakopoulos
 */

//abstract υπερκλάση Employee
public abstract class Employee 
{
    private Pay payment;
    private String name;
    private ArrayList<Project> projectList = new ArrayList<>(); //Η λίστα με τα projects
    
    //Constructor υπαλλήλλου με όνομα και τύπο μισθοδοσίας
    public Employee(String name, Pay payment) 
    {
        this.name = name;
        this.payment = payment;
    }
	
    public String getName() 
    {
        return name;
    }

    public Pay getPay() 
    {
        return payment;
    }
    
    public void addProject(Project project)
    {
        projectList.add(project);
    }
}