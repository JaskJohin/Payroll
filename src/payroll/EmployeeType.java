package payroll;

/**
 *
 * @author Alexandros Dimitrakopoulos
 */

//abstract υπερκλάση πληρωμών
public abstract class EmployeeType 

{
    private int hour;
    private int money;
 
    public EmployeeType() 
    {
    }
    
    public EmployeeType(int hour) 
    {
        this.hour = hour;
    }
	
    public int getHour() 
    {
        return hour;
    } 
	
    public int getMoney() 
    {
        return money;
    }

    public void setMoney(int money) 
    {
        this.money = money;
    }  
}