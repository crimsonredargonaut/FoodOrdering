/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.foodordering;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Functions {
    
    public static void showLogo(){
        try {
           File file = new File(System.getProperty("user.dir")+File.separator+"documents"+File.separator+"logo.txt");
            Scanner input = new Scanner(file);

            System.out.println("Reading file...");
            while (input.hasNextLine()) {
                String data = input.nextLine();
                System.out.println(data);
            }
            input.close(); // Close the scanner to release resources
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static boolean createAccount( String role, int userLevel, String username, String password, String documentFilePath) {
        
       try (BufferedWriter writer = new BufferedWriter(new FileWriter(documentFilePath, true))){
            writer.write(userLevel + ";" + role +";"+ username +";"+ password + ";true");
            writer.newLine();
            return true;
        }catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        } 
       //System.out.println(documentFilePath);
        return false;
    }
    public static boolean isValidLogin (String username, String password, String documentFilePath, int userLevel) {
        try (BufferedReader br = new BufferedReader(new FileReader(documentFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                String storedUsername = parts[2];
                String storedPassword = parts[3];
                int role = Integer.parseInt(parts[0]);
                             
                if(role == userLevel) {
                    return storedPassword.equals(password)&&storedUsername.equals(username);
                } else {
                    br.readLine();
                }
            } br.close();  
        } catch (IOException e) { e.printStackTrace(); }
        return true;
    }
    
}

class Order {
    String itemName;
    double price;

    public Order(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
    }
}
class Transaction {
    String cashierName;
    Date transactionDateTime;
    String guestName;
    Map<String, Order> orders = new HashMap<>();
    String paymentMode;
    double totalAmount;
    double discount;
    double amountPaid;
    double change;

    public Transaction(String cashierName, String guestName) {
        this.cashierName = cashierName;
        this.guestName = guestName;
        this.transactionDateTime = new Date();
    }

    public void addOrder(String itemName, double price) {
        orders.put(itemName, new Order(itemName, price));
        totalAmount += price;
    }

    public void calculateDiscount(double discountPercentage) {
        discount = totalAmount * (discountPercentage / 100);
        totalAmount -= discount;
    }

    public void processPayment(String paymentMode, double amountPaid) {
        this.paymentMode = paymentMode;
        this.amountPaid = amountPaid;
        change = amountPaid - totalAmount;
    }

    public void printReceipt() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println("Transaction Date and Time: " + dateFormat.format(transactionDateTime));
        System.out.println("Cashier: " + cashierName); //BALI DITO GAGAWEN KONG DEFAULT KUNG ANO YUNG ACCOUNT NAME NILA SIGURO BUT MABABAGO PA DEN
        System.out.println("Guest: " + guestName);

        System.out.println("\nOrders:");
        for (Order order : orders.values()) {
            System.out.println(order.itemName + ": P" + order.price);
        }

        System.out.println("\nTotal Amount: " + totalAmount);
        System.out.println("Discount: " + discount);
        System.out.println("Payment Mode: " + paymentMode);
        System.out.println("Amount Paid:" + amountPaid);
        System.out.println("Change: " + change);
    }
}
