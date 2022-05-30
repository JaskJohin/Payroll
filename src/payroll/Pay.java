package payroll;

/**
 *
 * @author Alexandros Dimitrakopoulos
 */

//abstract υπερκλάση Πληρωμών
public abstract class Pay 

{
    private int money;
    private int hours;
 
    public Pay() 
    {
    }
    
    public Pay(int hours) 
    {
        this.hours = hours;
    }
	
    public int getHours() 
    {
        return hours;
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