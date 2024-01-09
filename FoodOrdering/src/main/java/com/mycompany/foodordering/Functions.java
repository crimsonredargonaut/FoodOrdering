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
    
    public static void createDefaultAccount(){
        
    }
    
    public static void showLandingPage() {
        System.out.println("Welcome to the Account System!");
        System.out.println("1. Create Kitchen Staff Account");
        System.out.println("2. Create Cashier Account");
        System.out.println("3. Login as Kitchen Staff");
        System.out.println("4. Login as Cashier");
        System.out.println("5. Forgot Password");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
        
    }
    
    /*public static void updateSecurityFiles(String role, int userLevel) {
        //check if file exists or not
        try {
            File documentPath = new File(documentFilePath);
            File securityPath = new File(securityFilePath);
            Scanner sc = new Scanner(System.in);
            
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    } */
    
    public static boolean createAccount( String role, int userLevel, String username, String password, String documentFilePath) {
        
       try (BufferedWriter writer = new BufferedWriter(new FileWriter(documentFilePath, true))){
            writer.write(userLevel + ";" + role +";"+ username + password + ";true");
            writer.newLine();
            return true;
        }catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        } 
       //System.out.println(documentFilePath);
        return false;
    }
    public static boolean isValidLogin (String username, String password, String documentFilePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(documentFilePath))) {
            String line;
            
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                String storedUsername = parts[2];
                String storedPassword = parts[3];
                
                return username.equals(storedUsername) && password.equals(storedPassword);
                
            }
        } catch (IOException e) {
            e.printStackTrace();
            
        }
        return true;
    }
    
}
