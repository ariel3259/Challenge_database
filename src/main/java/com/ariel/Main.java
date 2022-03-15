package com.ariel;

import com.ariel.Program.EmployeesProgram;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        EmployeesProgram employeesProgram = new EmployeesProgram();
        Scanner scan = new Scanner(System.in);
        String continueProgram = "yes";
        int option;
        System.out.println("Welcome to municipality register");

        while(continueProgram.equals("yes") || continueProgram.equals("affirmative") || continueProgram.equals("si") || continueProgram.equals("afirmativo")){
            System.out.println("################################################");
            System.out.println("1- Show all employees");
            System.out.println("2- Insert an employee");
            System.out.println("3- Modify an employee");
            System.out.println("4- Delete an employee");
            System.out.println("5- Show all higher-paid and higher-antiquity employees");
            System.out.println("Please chose an option");
            option = Integer.parseInt(scan.next());

            switch(option){
                case 1:
                    continueProgram = employeesProgram.getAllEmployees();
                break;
                case 2:
                    continueProgram = employeesProgram.saveOneEmployee();
                break;
                case 3:
                    continueProgram =  employeesProgram.updateAEmployee();
                break;
                case 4:
                    continueProgram = employeesProgram.deleteEmployee();
                break;
                case 5:
                    continueProgram = employeesProgram.getAllHigherPaidAndHigherAntiquityEmployees();
                break;
            }

        }
        System.out.println("Goodbye");

    }
}
