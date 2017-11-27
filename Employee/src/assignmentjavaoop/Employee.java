/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentjavaoop;

/**
 *
 * @author ChanhQuy
 */
public class Employee {

String id,Name,Address;
private double salary,allowance;

    public Employee(String id, String Name, String Address, double salary, double allowance) {
        this.id = id;
        this.Name = Name;
        this.Address = Address;
        this.salary = salary;
        this.allowance = allowance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }
 public void print() {
        System.out.format("%s ; %s ; %s ; %.2f ;%.2f\n",this.id,this.Name, this.Address, this.salary, this.allowance);
    }


    
}
