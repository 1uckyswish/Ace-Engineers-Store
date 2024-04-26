package com.pluralsight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

public class OnlineStore {

    static ArrayList<Product> inventory = new ArrayList<>();
    static HashMap<String, CartItem> userCart = new HashMap<>();

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ MAIN METHOD ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        // load the inventory
        loadInventory();
        // System.out.println(inventory);
        displayUserHomeScreen();
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~ DISPLAY HOME SCREEN METHOD ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public static void displayUserHomeScreen() {
        // declare scanner to get home screen choice
        Scanner scanner = new Scanner(System.in);
        // present options to the user
        System.out.print("\n! Welcome to Best Buy !\n" +
                "(1) Display Products\n(2) Display Cart\n" +
                "(3) Exit\nSelection: ");
        // get user input
        String choice = scanner.nextLine();
        // switch case to call methods selected
        switch (choice) {
            case "1":
                displayProducts(scanner);
                break;
            case "2":
                displayCart(scanner);
                break;
            case "3":
                exitProgram();
                break;
            default:
                System.out.println("\n!!! Error invalid input please select again !!!");
                displayUserHomeScreen();
                break;
        }
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~ LOAD INVENTORY METHOD ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public static void loadInventory() {

        try { // use buffer to read from text but, must provide file reader
            BufferedReader reader = new BufferedReader(new FileReader("products.csv"));
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] productFields = line.split("\\|");
                Product currentProduct = new Product(Double.parseDouble(productFields[2]),
                        productFields[0], productFields[1], productFields[3]);
                inventory.add(currentProduct);
            }
            // close readers
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading inventory! Please come back later");
        }
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~ DISPLAY PRODUCTS SCREEN METHOD ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    private static void displayProducts(Scanner scanner) {

        System.out.println("\n~~~~~~~~ All current items Start ~~~~~~~");

        for (Product product : inventory) {
            System.out.println(product);
        }

        System.out.println("~~~~~~~~ All current items End ~~~~~~~");

        System.out.print("\nWould you like to do any of the following?\n" +
                "(1) Search by product by name, price or department\n" +
                "(2) Add a product to cart\n" +
                "(3) Go Back to home page\n" + "Selection: ");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                searchByChoice(scanner);
                break;
            case "2":
                addToCart(scanner);
                break;
            case "3":
                displayUserHomeScreen();
                break;
            default:
                System.out.println("\n!!! Error invalid input please select again !!!");
                displayProducts(scanner);
                break;
        }

    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~ SEARCH BY MAIN METHOD & OTHER SEARCHES ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public static void searchByChoice(Scanner scanner) {
        System.out.print("\nHow would you like to search by?\n" +
                "(1) Search by item name\n" +
                "(2) Search by price\n" +
                "(3) Search by department\n" +
                "Selection: ");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                searchByName(scanner);
                break;
            case "2":
                searchByPrice(scanner);
                break;
            case "3":
                searchByDepartment(scanner);
                break;
            default:
                System.out.println("Error please select a valid input");
                searchByChoice(scanner);
                break;
        }
    }

    // ********************* SEARCH BY NAME **********************

    public static void searchByName(Scanner scanner) {
        System.out.print("\nYou have chosen to search by name!" +
                "\nPlease provide name of item: ");
        String itemName = scanner.nextLine().trim().toLowerCase();
        System.out.printf("Items matching : %s\n", itemName);
        boolean itemFound = false;
        // check for matching search by name ignoring case
        for (Product product : inventory) {
            if (product.getName().toLowerCase().contains(itemName)) {
                System.out.println(product);
                itemFound = true;
            }
        }

        if (!itemFound) {
            System.out.printf("Sorry no items matching : %s\n", itemName);
        }

        // re-run program
        displayUserHomeScreen();
    }

    // *********************** SEARCH BY PRICE ************************

    public static void searchByPrice(Scanner scanner) {
        System.out.println("\nYou have chosen search by price");
        System.out.print("\nPlease provide the max price: ");
        // max price
        double max = scanner.nextDouble();
        System.out.print("\nPlease provide the min price: ");
        // min price
        double min = scanner.nextDouble();
        // clear left over in buffer
        scanner.nextLine();

        // loop through and search for matching price range
        for (Product price : inventory) {
            if ((price.getPrice() >= min) && (price.getPrice() <= max)) {
                System.out.println(price);
            }
        }

        // take user back to home screen after showing price range
        displayUserHomeScreen();
    }

    // ********************* SEARCH BY DEPARTMENT **********************

    public static void searchByDepartment(Scanner scanner) {
        // create array of departments

        String[] allDepartments = { "(1) Audio Video", "(2) Computers", "(3) Games", "(4) Electronics" };
        System.out.println("\nPlease select one of the following to search by: ");

        // print all available departments
        for (String dep : allDepartments) {
            System.out.println(dep);
        }

        // save user choice and assign department to loop through
        System.out.print("Selection: ");
        String choice = scanner.nextLine();
        String depChoice = "";
        switch (choice) {
            case "1":
                depChoice = "Audio Video";
                break;
            case "2":
                depChoice = "Computers";
                break;
            case "3":
                depChoice = "Games";
                break;
            case "4":
                depChoice = "Electronics";
                break;
            default:
                System.out.println("Invalid department choice please choose again!");
                searchByDepartment(scanner);
                break;
        }

        // display matching categories by checking through inventory
        System.out.printf("\nMatching categories for: %s\n", depChoice);
        for (Product currentDep : inventory) {
            if (currentDep.getDepartment().equals(depChoice)) {
                System.out.println(currentDep);
            }
        }

        // take user back to home screen after showing matching departments
        displayUserHomeScreen();
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ DISPLAY CART METHOD ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    // We need to loop check if items are inside
    private static void displayCart(Scanner scanner) {
        System.out.println("\nWelcome to your cart!");
        if (userCart.isEmpty()) {
            System.out.println("\nSorry no items found in cart");
            displayUserHomeScreen();
        } else {
            // Calculating cart total
            double total = 0.0;
            System.out.println("\n~~~~~ Your current cart items ~~~~~~~\n");
            for (CartItem displayProducts : userCart.values()) {
                // Show all cart items
                System.out.println(displayProducts);
                total += displayProducts.getTotalPrice();
            }

            System.out.printf("Your cart total for today is : $%,.2f\n", total);

            // display user cart options

            String[] cartOptions = { "(1) Checkout ", "(2) Remove product from cart",
                    "(3) Go Back to the home screen" };
            System.out.println("\nPlease select one of the following to search by: ");
            // print all available cart choices
            for (String selection : cartOptions) {
                System.out.println(selection);
            }
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    checkoutCart();
                    break;
                case "2":
                    removeFromCart(scanner);
                    break;
                case "3":
                    displayUserHomeScreen();
                    break;
                default:
                    System.out.println("Invalid choice please choose again!");
                    displayCart(scanner);
                    break;
            }
        }

    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ADD TO CART METHOD ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // We need to add the items from inventory to userCart variables declared up top
    public static void addToCart(Scanner scanner) {
        System.out.print("\nEnter the SKU number of the product you'd like to add to your cart: ");
        String userCartInput = scanner.nextLine().trim().toLowerCase();
        boolean addItemFlag = false;
        // AV1051

        for (Product product : inventory) {
            if (product.getSku().toLowerCase().equals(userCartInput)) {
                addItemFlag = true;
                if (userCart.containsKey(userCartInput)) {
                    CartItem updateCurrentItem = userCart.get(userCartInput);// sku number
                    updateCurrentItem.incrementQuantity();
                } else {
                    userCart.put(userCartInput, new CartItem(product, 1));
                }
            }
        }

        // ADD TO CART MESSAGE THANK YOU
        System.out.println("\nThe item has been added to the cart");
        for (CartItem item : userCart.values()) {
            System.out.println(item);
        }

        if (!addItemFlag) {
            System.out.println("\nProduct not found in inventory!");
        }
        displayProducts(scanner);
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ REMOVE ITEM FROM CART METHOD ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // We need to remove an item from user cart one by one
    public static void removeFromCart(Scanner scanner) {
        System.out.print("Enter the SKU number of the product you'd like to remove from your cart: ");
        String userRemovalChoice = scanner.nextLine().trim().toLowerCase();
        boolean skuItemInCart = false;

        for (String key : userCart.keySet()) {
            if (key.equalsIgnoreCase(userRemovalChoice)) {
                CartItem updateCartItem = userCart.get(key);
                skuItemInCart = true;
                if (updateCartItem.getQuantity() > 1) {
                    updateCartItem.decrementQuantity();
                    System.out.println("Item has been updated in the cart");
                } else {
                    System.out.println("Item has been removed from the cart");
                    userCart.remove(key);
                }
            }
        }

        System.out.println("USER CART updated****");
        for (CartItem item : userCart.values()) {
            System.out.println(item);
        }

        if (!skuItemInCart) {
            System.out.println("\nLooks like that item isn't currently in your cart\n");
        }
        displayProducts(scanner);
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ CHECKOUT METHOD ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public static void checkoutCart() {
        System.out.println("\n~~~~~~~ Thank you for shopping! ~~~~~~~~~~~~");
        double total = 0.0;
        for (CartItem displayProducts : userCart.values()) {
            total += displayProducts.getTotalPrice();
        }
        System.out.printf("\nYour total for today is %,.2f", total);
        // delete all items from cart
        userCart.clear();
        // Take user back home
        displayUserHomeScreen();
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ EXIT METHOD ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static void exitProgram() {
        System.out.println("Thank you for visiting! Goodbye, come again! :)");
    }
}

/*
 *
 *
 * ~~~~~~~~~~~~~~~ 10:30AM-1:00PM Display Products (T/N)~~~~~~~~~~~~~
 *
 * 10:30AM-10:40AM (DONE) Create a Product class that stores all the properties
 * defined in the csv file(N)
 * 10:40AM-10:55AM (DONE) Use the products.csv file to load the store's product
 * inventory into your application
 * 10:55AM-11:10AM (DONE) Displays a list of products that your store sells.
 * ---- On this screen the customer should be able to Search or filter the list
 * of products ----
 * 11:15AM-11:30AM (DONE) - Product Name (N)
 * 11:30AM-11:45AM (DONE) - Price (T)
 * 11:45AM-11:55AM (DONE) - Department(T)
 * LUNCH BREAK
 * 12:35PM-1:00PM (DONE) Add a product to their cart (N)
 * 12:50PM-1:00PM (DONE) - Go Back to the home page
 *
 * ~~~~~~~~~~~~~ 1:00PM-2:30PM Display Cart (N) ~~~~~~~~~~~~~~~~~~
 *
 * 1:05PM-1:15PM (DONE) This displays a list of line items that are in the
 * customer's cart.
 * 1:15PM-1:25PM (DONE) It should also display the total sales amount of the
 * cart.
 * The customer should be able to:
 * 1:30PM-1:45PM (DONE) Check Out
 * 1:45PM-2:00PM (DONE) Remove Product from the cart
 * 1:45PM-2:00PM (DONE) Go Back to the home screen
 * 2:10PM-2:30PM (DONE) If customer chooses to remove a product need to prompt
 * them for the product to remove
 *
 *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~ 2:30-3:00 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *
 * (TINA) TESTING
 * (NOEL) !!! READ ME !!!
 * (STAPHON) OPTIONAL TESTING
 *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~ !!!! FINISHED !!!! ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *
 * ~~~~~~~~~~~~~ 10:20AM-10:25AM The Store Home Screen (T) ~~~~~~~~~~~~~~
 *
 * The home screen should display a list of options that a user can choose from.
 * 1 MIN (DONE) Display Products
 * 1 MIN (DONE) Display Cart
 * 1 MIN (DONE) Exit closes out of the application
 *
 */
