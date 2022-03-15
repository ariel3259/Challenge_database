package com.ariel.db;

import com.ariel.Models.MunicipalityEmployee;


import java.sql.*;
import java.text.MessageFormat;
import java.util.LinkedList;
import java.util.List;


public class EmployeesDb {

    /**
     * @return con Connection
     *
     * */

    public Connection getConnection(){
        Connection con;
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/municipality_db?serverTimezone=UTC", "root", "1234");
            return con;
        }catch(Exception err){
            System.out.println(err);
            System.out.println("Connection failed");
            return null;
        }
    }

    /**
     *
     * @return employees List of MunicipalEmployee
     *
     */

    public List<MunicipalityEmployee> getEmployees(){
        try{
            PreparedStatement ps= getConnection().prepareStatement("select * from employees");
            ResultSet rs = ps.executeQuery();
            List<MunicipalityEmployee> employees = new LinkedList<>();
            while (rs.next()) {

                employees.add(new MunicipalityEmployee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getInt("years"),
                        rs.getInt("salary"),
                        rs.getString("work"),
                        rs.getString("municipality")
                ));
            }
            rs.close();
            return employees;
        }catch (SQLException e){
            return null;
        }
    }

    /**
     *
     * @param employee MunicipalEmployee
     * @return message String
     */

    public String saveEmployee(MunicipalityEmployee employee){
        try{
           PreparedStatement ps = getConnection().prepareStatement("insert into employees( name, last_name, email, years, salary, work, municipality) VALUES (?, ?, ?, ?, ?, ?, ?)");
           ps.setString(1, employee.getName());
           ps.setString(2, employee.getLastName());
           ps.setString(3, employee.getEmail());
           ps.setInt(4, employee.getYears());
           ps.setInt(5, employee.getSalary());
           ps.setString(6, employee.getWork());
           ps.setString(7, employee.getMunicipality());
           ps.executeUpdate();
           return MessageFormat.format("{0} {1} storages", employee.getName(), employee.getLastName());
        }catch (SQLException e){
            System.out.println(e);
            return "Something is wrong";
        }
    }

    /**
     *
     * @param employee MunicipalityEmployee
     * @return message String
     */

    public String modifyEmployee(MunicipalityEmployee employee){
        try{
            PreparedStatement ps = getConnection().prepareStatement("update employees set name=?, last_name=?, email=?, years=?, salary=?, work=?, municipality=? where id=?");
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getLastName());
            ps.setString(3, employee.getEmail());
            ps.setInt(4, employee.getYears());
            ps.setInt(5, employee.getSalary());
            ps.setString(6, employee.getWork());
            ps.setString(7, employee.getMunicipality());
            ps.setInt(8, employee.getId());

            ps.executeUpdate();
            return MessageFormat.format("{0} {1} updated", employee.getName(), employee.getLastName());
        } catch(SQLException err){
            System.out.println(err);
            return "Something is wrong";
        }
    }

    /**
     *
     * @param id integer
     * @return message String
     */
    public String deleteEmployee(int id){
        try{
            PreparedStatement ps = getConnection().prepareStatement("delete from employees where id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            return "Employee fired";
        }catch (SQLException err){
            return "Something is wrong";
        }
    }

    /**
     *
     * @return List of MunicipalEmployee
     */

    public List<MunicipalityEmployee> getAllHigherPaidAndHigherAntiquityEmployees(){
        try{
            PreparedStatement ps= getConnection().prepareStatement("select * from employees where salary >= 70000 and years >= 10");
            ResultSet rs = ps.executeQuery();
            List<MunicipalityEmployee> employees = new LinkedList<>();
            while (rs.next()) {
                employees.add(new MunicipalityEmployee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getInt("years"),
                        rs.getInt("salary"),
                        rs.getString("work"),
                        rs.getString("municipality")
                ));
            }
            rs.close();
            return employees;
        }catch (SQLException e){
            return null;
        }
    }
}
