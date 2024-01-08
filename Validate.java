
package com.mycompany.mavenproject1;

import Entity.Worker;
import java.util.ArrayList;
import java.util.Scanner;

public class Validate {
    private static Scanner sc = new Scanner(System.in);
    
    public static int checkInputLimit(int min, int max) {
        while (true) {            
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if(result< min || result>max) {
                    throw new NumberFormatException();
                } else {
                    return result;
                }
            } catch (NumberFormatException e) {
                System.out.println("please input number in rage ["+ min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public static String checkInputString() {
        while (true) {            
            String result = sc.nextLine().trim();
            if(result.isEmpty()) {
                System.out.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }
    
    // check id must be existed in DB.
    public static boolean checkIdExist(ArrayList<Worker> lw, String id) {
        //check from first to last list id worker exist or not
        for (Worker worker : lw) {
            if (id.equalsIgnoreCase(worker.getId())) {
                return true;
            }
        }
        return false;
    }
    
    public static int checkInputSalary() {
        while (true) {            
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if(result < 0) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Salary must be greater than 0");
                System.out.print("Enter again: ");
            }
        }
    }
    
    //check worker duplicate
    public static boolean checkWorkerExist(ArrayList<Worker> lw, String id,
            String name, int age, int salary, String workLocation) {
        //check from first to last list worker  worker exist or not
        for (Worker worker : lw) {
            if (id.equalsIgnoreCase(worker.getId())
                    && name.equalsIgnoreCase(worker.getName())
                    && age == worker.getAge()
                    && salary == worker.getSalary()) {
                return false;
            }
        }
        return true;
    }
}
