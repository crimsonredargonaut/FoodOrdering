
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
         boolean i = true;
        while (i) {
            System.out.println("Welcome to the Account System!");
        System.out.println("1. Create Kitchen Staff Account");
        System.out.println("2. Create Cashier Account");
        System.out.println("3. Login as Kitchen Staff");
        System.out.println("4. Login as Cashier");
        System.out.println("5. Forgot Password");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        
        switch(choice) {
            case 1 -> {
                System.out.println("**Create Kitchen Staff Account**");
                System.out.print("create username: ");
                String username = sc.next();
                System.out.print("create password: ");
                String password = sc.next();
                
                if(createAccount("Kitchen Staff", USER_LEVEL_KITCHEN_STAFF, username, password, documentFilePath)) {
                   System.out.println("Kitchen Staff Account created!");
                   System.out.println();
                    continue;
                }
            }
            case 2 -> {
                System.out.println("**Create Cashier Account**");
                System.out.print("create username: ");
                String username = sc.next();
                System.out.print("create password: ");
                String password = sc.next();
                
                if(createAccount("Cashier", USER_LEVEL_CASHIER, username, password, documentFilePath)) {
                   System.out.println("Cashier Account created!");
                   System.out.println();
                    continue;
                }
            }
            case 3 -> {
                System.out.println("**Kitchen Staff Login**");
                System.out.print("Enter Username: ");
                String username = sc.next();
                System.out.print("Enter password: ");
                String password = sc.next();
                
                if(isValidLogin(username, password, documentFilePath, USER_LEVEL_KITCHEN_STAFF)) {
                    System.out.println("Logged in as Kitchen Staff");
                }
            
            }
            case 4 -> {
                System.out.println("**Cashier Login**");
                System.out.print("Enter Username: ");
                String username = sc.next();
                System.out.print("Enter password: ");
                String password = sc.next();
                
                if(isValidLogin(username, password, documentFilePath, USER_LEVEL_CASHIER)) {
                    System.out.println("Logged in!\n");

                    System.out.print("Enter Cashier Name: ");
                    String cashierName = sc.next();

                    System.out.print("Enter Guest Name: ");
                    String guestName = sc.next();
                    
                    Transaction transaction = new Transaction(cashierName, guestName);
                    
                    while (true) {
            //DITO TATAWAGEN YUNG FOOD MENU CLASS
                        System.out.println("\nFood Menu:");
                        System.out.println("1. Burger - 95.00");
                        System.out.println("2. Pizza - 198.00");
                        System.out.println("3. Drink - 30.00");
                        System.out.println("4. Finish Order");

                        System.out.print("Select an option: ");
                        int c = sc.nextInt();

                        if (c == 4) {
                            break;
                        }

                        String itemName = "";
                        double price = 0;

                        switch (c) {
                            case 1:
                                itemName = "Burger";
                                price = 95.00;
                                break;
                            case 2:
                                itemName = "Pizza";
                                price = 198.00;
                                break;
                            case 3:
                                itemName = "Drink";
                                price = 30.00;
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                                continue;
                        }

                        transaction.addOrder(itemName, price);
                        System.out.println("Added " + itemName + " to the order.");
                    }
                    System.out.print("\nEnter Discount Percentage (if any): ");
                    double discountPercentage = sc.nextDouble();
                    transaction.calculateDiscount(discountPercentage);
                    
                    System.out.print("Enter Payment Mode (Cash/GCash): ");
                    String paymentMode = sc.next();

                    double amountPaid;
                    do {
                        System.out.print("Enter Amount Paid: ");
                        amountPaid = sc.nextDouble();

                        if (amountPaid < transaction.totalAmount) {
                            System.out.println("Insufficient amount. Please enter a valid amount.");
                        }
                    } while (amountPaid < transaction.totalAmount);

                    transaction.processPayment(paymentMode, amountPaid);
                    transaction.printReceipt();
                    
                } else {
                    continue;
                }
            }
        }
        }
        
    }
}
