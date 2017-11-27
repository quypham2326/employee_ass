/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentjavaoop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author ChanhQuy
 */
public class EmpList {

    public String fileName = "employee.txt";
    Scanner sc = new Scanner(System.in);
    public ArrayList<Employee> listOfEmp = new ArrayList<>();

    public EmpList() {
        super();
    }

    public void addNewEmp() {
        Scanner sc = new Scanner(System.in);
        String id, name, address;
        double salary, allowance;

        boolean flag = true;
        do {
            System.out.print("input EmpID: ");
            id = sc.nextLine();
            flag = id.matches("^[E][0-9]{3}$");
            if (flag) {
                int index = checkCode(id);
                if (index < 0) {
                    System.out.print("input EmpName: ");
                    name = sc.nextLine();
                    System.out.print("input EmpAddress: ");
                    address = sc.nextLine();
                    System.out.print("Input EmpSalary :");
                    salary = Double.parseDouble(sc.nextLine());
                    System.out.print("Input EmpAllowance: ");
                    allowance = Double.parseDouble(sc.nextLine());
                    listOfEmp.add(new Employee(id, name, address, salary, allowance));
                } else {
                    System.out.println("The ID has been had yet");
                }
            } else {
                System.out.println("Wrong ID : (e.g:E123)");
            }
        } while (!flag);
        System.out.println("Added");

    }

    private int checkCode(String id) {
        for (int i = 0; i < listOfEmp.size(); i++) {
            if (listOfEmp.get(i).id.equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    public void removeEmp() {
        String id;
        boolean flag = true;
        do {
            System.out.print("Enter the code of removed employee :");
            id = sc.nextLine();
            flag = id.matches("^[E][0-9]{3}$");
            if (flag) {
                int index = checkCode(id);
                if (index < 0) {
                    System.out.println("This code does not exist");
                } else {
                    listOfEmp.remove(index);
                    System.out.println("The employee" + id + "has been removed");
                }
            } else {
                System.out.println("Wrong ID");
            }
        } while (!flag);
    }

    public void output() {
        if (listOfEmp.size() == 0) {
            System.out.println("Empty List");
            return;
        }
        System.out.println("---Employees list---");
        for (int i = 0; i < listOfEmp.size(); i++) {
            if(listOfEmp.get(i)instanceof Employee){
                listOfEmp.get(i).print();
            }
            
        }
    }

    public void update() {
        String id, name, address;
        double salary, allowance;
        System.out.println("Input code of Emp to update:");
        id = sc.nextLine();
        int location = checkCode(id);
        if (location != -1) {
            System.out.println("Input new name: ");
            name = sc.nextLine();
            System.out.println("Input new address");
            address = sc.nextLine();
            System.out.println("Input new Salary: ");
            salary = Double.parseDouble(sc.nextLine());
            System.out.println("Input new allowance: ");
            allowance = Double.parseDouble(sc.nextLine());
            listOfEmp.get(location).setName(name);
            listOfEmp.get(location).setAddress(address);
            listOfEmp.get(location).setSalary(salary);
            listOfEmp.get(location).setAllowance(allowance);
            System.out.println("Emp has been update");
        } else {
            System.out.println("Not valid code");
        }
    }

    public void search() {
        if (listOfEmp.size() == 0) {
            System.out.println("Empty List");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Input person ID:");
        String id = sc.next().trim(); //trim(): remove whitespace
        int index = checkCode(id);
        if (index < 0) {
            System.out.println("ID not found");
        } else {
            listOfEmp.get(index).print();
        }
    }

    public void printincome() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input r1: ");
        double r1 = Double.parseDouble(sc.next());
        System.out.println("Input r2: ");
        double r2 = Double.parseDouble(sc.next());
        for (int i = 0; i < listOfEmp.size(); i++) {
            double income = listOfEmp.get(i).getSalary() + listOfEmp.get(i).getAllowance();
            if (r1 <= income && income <= r2) {
                listOfEmp.get(i).print();
            }

        }
    }

    public void loadData() {
        try {
            File f = new File(fileName);
            if (f.exists() == false) {
                return;
            }
            String details;
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            while ((details = br.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(details, ";");
                String id = stk.nextToken().trim();
                String name = stk.nextToken().trim();
                String address = stk.nextToken().trim();
                double salary = Double.parseDouble(stk.nextToken());
                double allowance = Double.parseDouble(stk.nextToken());
                Employee b = new Employee(id, name, address, salary, allowance);
                listOfEmp.add(b);

            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveData() {
        try {
            FileWriter fw = new FileWriter(fileName);
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 0; i < listOfEmp.size(); i++) {
                String data = String.format("%s; %s; %s; %.2f; %.2f", listOfEmp.get(i).getId(),
                        listOfEmp.get(i).getName(), listOfEmp.get(i).getAddress(),
                        listOfEmp.get(i).getSalary(), listOfEmp.get(i).getAllowance());
                pw.println(data);
            }
            pw.close();
            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
