package payroll;

import java.io.IOException;

/**
 *
 * @author Alexandros Dimitrakopoulos
 */

public class Payroll 
{    
    public static void main(String[]args) throws IOException
    { 
    Company c = new Company();
    c.addEmployee(new Developer("AA", new Salary()));
    c.addEmployee(new Manager("BB", new Salary()));
    c.addEmployee(new Analyst("VV", new PerHour(15)));
    c.addEmployee(new Technical("CC", new Salary()));
    c.addEmployee(new Developer("KK", new Salary()));
    c.addProjectToEmployee("AA", new DevelopmentProject("Website for UoM"));
    c.addProjectToEmployee("BB", new DevelopmentProject("Website for UoM "));
    c.addProjectToEmployee("VV", new DevelopmentProject("Website for UoM "));
    c.addProjectToEmployee("CC", new TechnicalProject("Network setup for EAP"));
    c.addProjectToEmployee("KK", new DevelopmentProject("Website for UoM"));
    c.addProjectToEmployee("BB", new TechnicalProject("Network setup for EAP"));
    //c.calcPayroll();
    System.out.println(c.calcPayroll());
    c.save();
    }    
}