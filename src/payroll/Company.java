package payroll;

import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 *
 * @author Alexandros Dimitrakopoulos
 */

public class Company
{
    //Λίστα με τoυς τύπους των υπαλλήλων
    final ArrayList<EmployeeType> types = new ArrayList<>();
    
    //Λίστα υπαλλήλων της εταιρείας
    private ArrayList<Employee> employees = new ArrayList<>();
    
    //Ανάθεση νέου project σε υπάλληλο
    public void addProjectToEmployee(String empl, Project project) 
    {
        //Java functional operations (Πρόταση του JDK αντι για την χρήση for)
        //Αν ο υπάλληλος υπάρχει στη λίστα υπαλλήλων
        employees.stream().filter((employeeee) -> (empl.equals(employeeee.getName()))).map((employeeee) -> 
        {
            employeeee.addProject(project); //Ανάθεσέ του project
            return employeeee;
        }).forEachOrdered((employeeee) -> 
        {
            employeeee.getType().setMoney(employeeee.getType().getMoney() + 80); //Προσθήκη Bonus
        });
    }
    
    //Αποθήκευση σε αρχείο TXT των επιμέρους αποδοχών καθώς και τη συνολική της εταιρείας
    public void save() throws IOException
    {
        BufferedWriter output;        
        output = new BufferedWriter(new FileWriter("Payroll.txt"));
        try 
        {
            output.write(calcPayroll());
        } 
        catch (IOException e) 
        {
            System.out.println(e);
        } 
        finally 
        {
            output.close();
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
        int total = 0; //Αρχικοποίηση της μισθοδοσίας 
        
        for (Employee employee : employees) //Για κάθε υπάλληλο (διαπέραση της λίστας των υπαλλήλων) 
        {
            //θα χρησιμοποιήσουμε το instanceof για τον ελεγχο της σχέσης υπερκλάσης π.χ (EmployeeType) και υποκλάσης (Salary)
            //Επίσης, για να υπολογίσουμε τις αποδοχές θα διαβάσουμε πρώτα (μέσω της μεθόδου getType()),
            
            //Υπολογισμός μηνιαίων αποδοχών
            if (employee.getType() instanceof Salary) //Έλεγχος σχέσης υπερκλάσης (EmployeeType) και υποκλάσης (Salary)
            {
                //Αν ο υπάλληλος είναι Manager 
                if (employee instanceof Manager) 
                {
                    employee.getType().setMoney(employee.getType().getMoney() + 2000);
                }
                //Αν ο υπάλληλος είναι Developer 
                if (employee instanceof Developer) 
                {
                    employee.getType().setMoney(employee.getType().getMoney() + 1200);
                }
                //Αν ο υπάλληλος είναι Analyst 
                if (employee instanceof Analyst) 
                {
                    employee.getType().setMoney(employee.getType().getMoney() + 1500);
                }
                //Αν ο υπάλληλος είναι Technical 
                if (employee instanceof Technical) 
                {
                    employee.getType().setMoney(employee.getType().getMoney() + 800);
                }
            }

            //Υπολογισμός αποδοχών με την ώρα
            if (employee.getType() instanceof PerHour) 
            {
                //Αν ο υπάλληλος είναι Analyst 
                if (employee instanceof Analyst) 
                {
                    employee.getType().setMoney(employee.getType().getMoney() + (15 * employee.getType().getHour()));
                }                

                //Αν ο υπάλληλος είναι Developer 
                if (employee instanceof Developer) 
                {
                    employee.getType().setMoney(employee.getType().getMoney() + (12 * employee.getType().getHour()));
                }
            
                //Αν ο υπάλληλος είναι Technical
                if (employee instanceof Technical) 
                {
                    employee.getType().setMoney(employee.getType().getMoney() + (8 * employee.getType().getHour()));
                }
                
                //Αν ο υπάλληλος είναι Manager 
                if (employee instanceof Manager) 
                {
                    employee.getType().setMoney(employee.getType().getMoney() + (20 * employee.getType().getHour()));
                }
            }
            //Επιμέρους μισθοδοσίες των υπαλλήλων για έναν μήνα
            payroll = payroll + "\nΥπάλληλος: " + employee.getName() + "\nΑποδοχές: " + employee.getType().getMoney() + " Ευρώ\n";                       
            total = total + employee.getType().getMoney();
        }
        //Υπολογισμός συνολικής μισθοδοσίας της εταιρείας για έναν μήνα
        payroll = payroll + "----------------------------------------" + "\nΣυνολική Μισθοδοσία Εταιρείας: " + total + " Ευρώ\n";
        return payroll;
    }
}