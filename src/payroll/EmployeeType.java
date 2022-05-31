package payroll;

/**
 *
 * @author Alexandros Dimitrakopoulos
 */

//abstract υπερκλάση τύπου υπαλλήλου (ωρομίσθιος ή μισθός με το μήνα)
public abstract class EmployeeType 
{
    private int hour;
    private int money;
    
    public EmployeeType(int hour) 
    {
        this.hour = hour;
    }       
 
    public EmployeeType() 
    {
        
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