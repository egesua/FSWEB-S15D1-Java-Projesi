package com.workintech.ShoppingCart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ShoppingCart {
    private static ArrayList<String> groceryList = new ArrayList<String>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        printInstructions();
        while (!quit) {
            System.out.println("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 0:
                    quit = true;
                    break;
                case 1:
                    addItem();
                    break;
                case 2:
                    removeItem();
                case 3:
                    checkItemIsInList();
                    break;
                case 4:
                    printSorted();
                    break;
                default:
                    System.out.println("Invalid choice..");
                    break;
            }
        }
    }

    public static void printInstructions(){
        System.out.println("\nPress ");
        System.out.println("\t 0 - To quit the app.");
        System.out.println("\t 1 - To add an item to the list.");
        System.out.println("\t 2 - To remove an item from the list.");
        System.out.println("\t 3 - To check if an item is in the list.");
        System.out.println("\t 4 - To print the sorted list");
    }
    public static  void addItem(){
        System.out.print("Enter the item or items you want to add: ");
        String[] items = scanner.nextLine().split(",");
        Collections.addAll(groceryList, items);
        Collections.sort(groceryList);
        System.out.println("Item or items added to the list.");
    }
    public static void removeItem(){
        System.out.println("Select the item or items you want to remove: ");
        String[] items = scanner.nextLine().split(",");
        for(String item: items){
            if(groceryList.contains(item)){
                groceryList.remove(item);
            }
        }
        Collections.sort(groceryList);
        System.out.println("Item or items removed from the list.");
    }
    public static void checkItemIsInList(){
        System.out.println("Select the item you want to check.");
        String item = scanner.nextLine();
        if(groceryList.contains(item)){
            System.out.println(item + " is in the list.");
        }
    }
    public static void printSorted(){
        System.out.println("Grocery list sorted in alphabetical order: ");
        for(String item: groceryList){
            System.out.println(item);
        }
    }
}
