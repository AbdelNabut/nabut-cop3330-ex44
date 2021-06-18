/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Abdel Nabut
 */


package ex44;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


public class App
{

    public static void main( String[] args ) throws FileNotFoundException {
        // read json file
        // convert json info to object array
        // ask user to input an object
        // check if object exists in object array
        // print object if it does, otherwise ask user again.

        boolean productFound = false;
        String productOfInterest;
        File file = new File("src/main/java/ex44/exercise44_input.json");
        ArrayList<Product> products;
        products = Product.getProducts(file);

        while(!productFound) {
            System.out.print("What is the product name: ");
            Scanner input = new Scanner(System.in);
            productOfInterest = input.nextLine().toLowerCase(Locale.ROOT);

            for (Product product : products) {
                if (product.getName().toLowerCase(Locale.ROOT).equals(productOfInterest)) {
                    Product.printProduct(product);
                    productFound = true;
                    break;
                }
            }
        }

    }
}
