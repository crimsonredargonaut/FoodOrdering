/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.foodordering;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Functions {
    
    public static void showLogo(){
        try {
           File file = new File(System.getProperty("user.dir")+File.separator+"logo.txt");
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
}
