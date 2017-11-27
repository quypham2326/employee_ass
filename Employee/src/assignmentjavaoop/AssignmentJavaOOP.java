/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentjavaoop;

import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author ChanhQuy
 */
public class AssignmentJavaOOP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
//        PersonManager personManager = new PersonManager(50);
        EmpList list = new EmpList();
       list.loadData();
        int choice = 0;
        do {

            System.out.println("1- Add an employee ");
            System.out.println("2- Search employee details using his/her code");
            System.out.println("3- Remove an employee  using his/her code");
            System.out.println("4- Update information of an employee using his/her code");
            System.out.println("5- Print out all the list");
//            System.out.println("6- Print out employees whose incomes (salary+allowance) are in the range r1, r2 (r1, r2 are inputted)");
            System.out.println("7- Save");
            System.out.print("Enter your option: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    list.addNewEmp();
                    break;
                case 2:
                   list.search();
                    break;
                case 3:
                    list.removeEmp();
                    break;
                case 4:
                    list.update();
                    break;
                case 5:
                    list.output();
                    break;
                case 6:
//                    list.printincome();
                    break;
                case 7:
                   list.saveData();
                    break;
                default:
                    System.out.println("Bye bye");
            }
        } while (choice > 0 && choice < 8);
    }
}
