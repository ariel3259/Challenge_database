package com.ariel.Program;

import com.ariel.Models.MunicipalityEmployee;
import com.ariel.db.EmployeesDb;

import java.util.List;
import java.util.Scanner;

public class EmployeesProgram {
    private final Scanner scanner = new Scanner(System.in);
    private final EmployeesDb employeesDb = new EmployeesDb();

    /**
     *
     * @return String
     */

    public String getAllEmployees(){
        List<MunicipalityEmployee> employees = this.employeesDb.getEmployees();
        if(employees.isEmpty()){
            System.out.println("There are no employees");
            System.out.println("Do you want to continue?");
            return this.scanner.next();
        }
        for(MunicipalityEmployee employee: employees){
            System.out.println("################################################");
            System.out.println("Id: "+ employee.getId());
            System.out.println("Name: "+ employee.getName());
            System.out.println("Last name: "+ employee.getLastName());
            System.out.println("Email: "+ employee.getEmail());
            System.out.println("Years: "+ employee.getYears());
            System.out.println("Salary: $"+ employee.getSalary());
            System.out.println("Work: "+ employee.getWork());
            System.out.println("Municipality: "+ employee.getMunicipality());
            System.out.println("################################################");
        }
        System.out.println("Do you want to continue?");
        return this.scanner.next();
    }

    /**
     *
     * @return String
     */
    public String saveOneEmployee(){
        String name;
        String lastName;
        String email;
        int years;
        int salary;
        String work;
        String municipality;

        System.out.println("Insert employee's name: ");
        name = this.scanner.next();

        System.out.println("Insert employee's last name: ");
        lastName = this.scanner.next();

        System.out.println("Insert employee's email: ");
        email = this.scanner.next();

        System.out.println("Insert employee's antiquity(in years): ");
        years = Integer.parseInt(this.scanner.next());

        System.out.println("Insert employee's salary: ");
        salary = Integer.parseInt(this.scanner.next());

        //Next line
        this.scanner.nextLine();

        System.out.println("Insert employee's work: ");
        work = this.scanner.nextLine();

        System.out.println("Insert employee's municipality: ");
        municipality = this.scanner.nextLine();

        System.out.println(this.employeesDb.saveEmployee(new MunicipalityEmployee(0, name, lastName, email, years, salary, work, municipality)));

        System.out.println("Do you want to continue?");
        return this.scanner.next();
    }

    /**
     *
     * @return String
     */
    public String updateAEmployee(){
        String name;
        String lastName;
        String email;
        int years;
        int salary;
        String work;
        String municipality;
        int id;

        System.out.println("Insert employee's id: ");
        id = Integer.parseInt(this.scanner.next());

        System.out.println("Insert employee's name: ");
        name = this.scanner.next();

        System.out.println("Insert employee's last name: ");
        lastName = this.scanner.next();

        System.out.println("Insert employee's email: ");
        email = this.scanner.next();

        System.out.println("Insert employee's antiquity(in years): ");
        years = Integer.parseInt(this.scanner.next());

        System.out.println("Insert employee's salary: ");
        salary = Integer.parseInt(this.scanner.next());

        //Next line
        this.scanner.nextLine();

        System.out.println("Insert employee's work: ");
        work = this.scanner.nextLine();

        System.out.println("Insert employee's municipality: ");
        municipality = this.scanner.nextLine();

        System.out.println(this.employeesDb.modifyEmployee(new MunicipalityEmployee(id, name, lastName, email, years, salary, work, municipality)));

        System.out.println("Do you want to continue?");
        return this.scanner.next();
    }

    /**
     *
     * @return String
     */

    public String deleteEmployee(){
        int id;

        System.out.println("Insert employee's id: ");
        id = Integer.parseInt(this.scanner.next());

        System.out.println(this. employeesDb.deleteEmployee(id));

        System.out.println("Do you want to continue?");
        return this.scanner.next();
    }

    /**
     *
     * @return String
     */

    public String getAllHigherPaidAndHigherAntiquityEmployees(){
        List<MunicipalityEmployee> employees = this.employeesDb.getAllHigherPaidAndHigherAntiquityEmployees();
        if(employees.isEmpty()){
            System.out.println("There are no employees");
            System.out.println("Do you want to continue?");
            return this.scanner.next();
        }
        for(MunicipalityEmployee employee: employees){
            System.out.println("################################################");
            System.out.println("Id: "+ employee.getId());
            System.out.println("Name: "+ employee.getName());
            System.out.println("Last name: "+ employee.getLastName());
            System.out.println("Email: "+ employee.getEmail());
            System.out.println("Years: "+ employee.getYears());
            System.out.println("Salary: $"+ employee.getSalary());
            System.out.println("Work: "+ employee.getWork());
            System.out.println("Municipality: "+ employee.getMunicipality());
            System.out.println("################################################");
        }
        System.out.println("Do you want to continue?");
        return this.scanner.next();
    }
}
