
package com.mycompany.foodordering;

/**
 *
 * @author TOM-Mark
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class FoodOrdering extends Functions{  // superclass/subclass
    private static final int MAX_LOGIN_ATTEMPTS = 3;
    private static final int USER_LEVEL_ADMIN = 1;
    private static final int USER_LEVEL_CASHIER = 2;
    private static final int USER_LEVEL_KITCHEN_STAFF = 3;
    
    public static String documentFilePath = System.getProperty("user.dir")+File.separator+"documents"+File.separator + "accounts.txt";
    public static String securityFilePath = System.getProperty("user.dir")+File.separator+"documents"+File.separator + "security.txt";

    
    
    public static void main(String[] args) {
        showLogo(); // inherited
        Scanner sc = new Scanner(System.in);
        showLandingPage();
        int choice = sc.nextInt();
  
        switch(choice) {
            case 1 -> {
                System.out.print("create username: ");
                String username = sc.nextLine();
                System.out.print("create password: ");
                String password = sc.nextLine();
                
                if(Functions.createAccount("Kitchen Staff", USER_LEVEL_KITCHEN_STAFF, username, password, documentFilePath)) {
                    System.out.println("Created account");
                }
            }
            case 2 -> {
                System.out.print("Enter Username: ");
                String username = sc.nextLine();
                System.out.print("Enter password: ");
                String password = sc.nextLine();
                
                if(isValidLogin(username, password, documentFilePath)) {
                    
                }
            }
        }
    }
}
