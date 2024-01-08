
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
    
    
    public static void main(String[] args) {
        showLogo(); // inherited
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Welcome to the Account System!");
        System.out.println("1. Create Kitchen Staff Account");
        System.out.println("2. Create Cashier Account");
        System.out.println("3. Login as Kitchen Staff");
        System.out.println("4. Login as Cashier");
        System.out.println("5. Forgot Password");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();
        
        switch(choice) {
            case 1:
                
        }
    }
}
