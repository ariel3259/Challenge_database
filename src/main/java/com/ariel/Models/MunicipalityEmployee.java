package com.ariel.Models;

public class MunicipalityEmployee {

    private int id;

    private String name;

    private String lastName;

    private String email;

    private int years;

    private int salary;

    private String work;

    private String municipality;

    public MunicipalityEmployee(int id, String name, String lastName, String email, int years, int salary, String work, String municipality) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.years = years;
        this.salary = salary;
        this.work = work;
        this. municipality = municipality;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }


    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }


}

