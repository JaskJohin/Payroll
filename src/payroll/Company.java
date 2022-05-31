package payroll;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Alexandros Dimitrakopoulos
 */

public class Company 

{
    //Λίστα με τις πληρωμές των υπαλλήλων
    private ArrayList<EmployeeType> wages = new ArrayList<>();
    
    //Λίστα υπαλλήλων της εταιρείας
    private ArrayList<Employee> employees = new ArrayList<>();
    
    //Ανάθεση νέου project σε υπάλληλο
    public void addProjectToEmployee(String empl, Project project) 
    {
        for (Employee employeeee : employees) 
        {
            //Αν ο υπάλληλος υπάρχει στη λίστα υπαλλήλων
            if (empl.equals(employeeee.getName())) 
                {
                    employeeee.addProject(project); //Ανάθεσέ του project
                    employeeee.getPay().setMoney(employeeee.getPay().getMoney() + 80); //Προσθήκη Bonus
                }
        }
    }
    
    //Αποθήκευση σε αρχείο TXT
    public void save() throws IOException
    {
        BufferedWriter out = new BufferedWriter(new FileWriter("Payroll.txt"));
        try 
        {
            out.write(calcPayroll());
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            out.close();
        }    
    }
    
    //Προσθήκη νέου υπαλλήλου στην εταιρεία
    public void addEmployee(Employee employee) 
    {
        employees.add(employee);
    }
     
    //Υπολογισμός μισθοδοσίας της εταιρείας για έναν συγκεκριμένο μήνα 
    public String calcPayroll()
    {
        String payroll = "";
       // String payroll = "Μήνας Μισθοδοσίας: " + month + "\n" + "----------------------------------------";
        int sum = 0;
        
        for (Employee employee : employees) //Χρησιμοποιούμε for-each για τη διαπέραση της λίστας των υπαλλήλων 
        {
            //θα χρησιμοποιήσουμε το instanceof για τον ελεγχο της σχέσης υπερκλάσης π.χ (Pay) και υποκλάσης (Salary)
            //Επίσης, για να υπολογίσουμε τις αποδοχές θα διαβάσουμε πρώτα (μέσω της μεθόδου getPay()),
            
            //Υπολογισμός μηνιαίων αποδοχών
            if (employee.getPay() instanceof Salary) //Έλεγχος σχέσης υπερκλάσης (EmployeeType) και υποκλάσης (Salary)
            {
                //Αν ο υπάλληλος είναι Manager 
                if (employee instanceof Manager) 
                {
                    employee.getPay().setMoney(employee.getPay().getMoney() + 2000);
                }
                //Αν ο υπάλληλος είναι Developer 
                if (employee instanceof Developer) 
                {
                    employee.getPay().setMoney(employee.getPay().getMoney() + 1200);
                }
                //Αν ο υπάλληλος είναι Analyst 
                if (employee instanceof Analyst) 
                {
                    employee.getPay().setMoney(employee.getPay().getMoney() + 1500);
                }
                //Αν ο υπάλληλος είναι Technical 
                if (employee instanceof Technical) 
                {
                    employee.getPay().setMoney(employee.getPay().getMoney() + 800);
                }
            }

            //Υπολογισμός αποδοχών με την ώρα
            if (employee.getPay() instanceof PerHour) 
            {
                //Αν ο υπάλληλος είναι Analyst 
                if (employee instanceof Analyst) 
                {
                    employee.getPay().setMoney(employee.getPay().getMoney() + (15 * employee.getPay().getHour()));
                }                

                //Αν ο υπάλληλος είναι Developer 
                if (employee instanceof Developer) 
                {
                    employee.getPay().setMoney(employee.getPay().getMoney() + (12 * employee.getPay().getHour()));
                }
            
                //Αν ο υπάλληλος είναι Technical
                if (employee instanceof Technical) 
                {
                    employee.getPay().setMoney(employee.getPay().getMoney() + (8 * employee.getPay().getHour()));
                }
                
                //Αν ο υπάλληλος είναι Manager 
                if (employee instanceof Manager) 
                {
                    employee.getPay().setMoney(employee.getPay().getMoney() + (20 * employee.getPay().getHour()));
                }
            }
            //Υπολογισμός συνολικής μισθοδοσίας της εταιρείας για έναν μήνα            
            sum = sum + employee.getPay().getMoney();
            //Επιμέρους μισθοδοσίες των υπαλλήλων για έναν μήνα
            payroll = payroll + "\nΥπάλληλος: " + employee.getName() + "\nΑποδοχές: " + employee.getPay().getMoney() + " Ευρώ\n";
        }
        payroll = payroll + "----------------------------------------" + "\nΣυνολική Μισθοδοσία Εταιρείας: " + sum + " Ευρώ\n";
        return payroll;
    }
}