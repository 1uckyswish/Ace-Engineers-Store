
<div align="center">
  <h1> <img src = "https://github.com/1uckyswish/Ace-Engineers-Store/assets/107442415/cc664be7-dd72-4761-a7e0-abb629ad20e1" width = 300px height='300px'> </h1>
</div>

# Ace Engineers Store Java Online Store 



Welcome to Ace Engineers Store! This command-line application offers a seamless shopping experience, enabling users to conveniently browse, add items to their cart, and manage purchases directly from their terminal.

## Project Details

- **Collaborators:** 
  - Noel Guillen
  - Staphon Peterson
  - Tina Nguyen
  
- **Project Description:** Ace Engineers Store is a Java project developed collaboratively by three software engineers. It provides a user-friendly command-line interface for easy shopping.
- **Methodology:** We set multiple sprints and time deadlines to meet expectations promptly. The majority of the project was developed using a pair programming method, alternating between roles of driver and navigator. This helped us streamline the project to finish right on time.
- **Technical Details:** We utilized functional programming to split up tasks and recursion to maintain the application's functionality. Various data structures such as ArrayList and HashMap were employed, alongside heavy reliance on Object-Oriented Programming principles and the effectiveness of encapsulation within our classes.


## Main Class (Home)

<!--TEXT-->
This is the heart of our Ace Engineers Store project. The Main class manages all store functionalities. Check out the Maven Java folder structure on the left to see how the project is organized.

<!--IMAGE SCREENSHOT-->
![Screenshot 2024-04-26 at 2 12 37 PM](https://github.com/1uckyswish/Ace-Engineers-Store/assets/107442415/7fe0e3dd-5421-4c6f-80b2-a82e9c1675cc)


## Start of Program

<!--TEXT-->
This is the main screen of the Ace Engineers Store interface, offering users a variety of options to explore.

<!--IMAGE SCREENSHOT-->

![Screenshot 2024-04-26 at 2 12 54 PM](https://github.com/1uckyswish/Ace-Engineers-Store/assets/107442415/816a61a7-269f-43e2-97ef-327c637eaec3)

## Option 1 Home Screen: Display All Products in Online Store Inventory

<!--TEXT-->
This option provides a comprehensive list of all products available in the Javazon Online Store inventory. Users can conveniently browse through the selection and choose their desired items for purchase.

<!--IMAGE SCREENSHOT-->
![Screenshot 2024-04-26 at 2 13 04 PM](https://github.com/1uckyswish/Ace-Engineers-Store/assets/107442415/4a9160de-a4ad-4818-b6a7-fe52f998845d)


## Option 1 Menu: Proceed to Search for Products in the Inventory

<!--TEXT-->
This option allows users to search for products based on product names, price, and department. Users can input the relevant information to find the desired items in the inventory.
<!--IMAGE SCREENSHOT-->

![Screenshot 2024-04-26 at 2 13 14 PM](https://github.com/1uckyswish/Ace-Engineers-Store/assets/107442415/39e17f50-209d-4cef-a5fa-5a213d10fc08)

## Option 2 Sub Menu: Add Products to Cart by SKU Number

<!--TEXT-->
This option allows you to add products to your cart based on their SKU. After adding an item, it displays the updated quantity of the newly added product in your cart.
<!--IMAGE SCREENSHOT-->
![Screenshot 2024-04-26 at 2 13 49 PM](https://github.com/1uckyswish/Ace-Engineers-Store/assets/107442415/9eeb3a13-09f3-4993-9f07-dd275d96ee9f)


## Option 2 Home Screen: Proceed to View Shopping Cart

<!--TEXT-->
This option displays the products along with their details such as SKU, name, price, and quantity. It provides a comprehensive overview of your current cart contents.
<!--IMAGE SCREENSHOT-->
![Screenshot 2024-04-26 at 2 14 20 PM](https://github.com/1uckyswish/Ace-Engineers-Store/assets/107442415/5ac2b542-76ec-4d6e-95a9-1fc87202ba32)


## Option 1 Shopping Cart: User Checkout Section

<!--TEXT-->
In this section, users will be presented with the total cost of all the products in their cart. Additionally, they will have the option to proceed with checkout, which will clear their cart. Upon successful checkout, a thank you message will be displayed to acknowledge the transaction.

<!--IMAGE SCREENSHOT-->
![Screenshot 2024-04-26 at 3 01 09 PM](https://github.com/1uckyswish/Ace-Engineers-Store/assets/107442415/25a2ec8b-305c-4a07-b059-14e44e37058d)


## Option 2 Shopping Cart Sub Menu: Remove Shopping Item

<!--TEXT-->
This option allows users to remove items from the cart based on the SKU. If the user decides to delete an item with a quantity larger than 1, the quantity of that item in the cart will decrement each time the user enters the SKU of that product.

<!--IMAGE SCREENSHOT-->

![Screenshot 2024-04-26 at 2 27 31 PM](https://github.com/1uckyswish/Ace-Engineers-Store/assets/107442415/d1c733fe-4f8b-44b1-8927-eeaa08294fd1)



## Error Handling Section

### Main Class (Home) Error handle

<!--TEXT-->
The main screen of the Ace Engineers Store interface presents users with various options to choose from. It includes error handling to manage instances where users input an option that is not one of the displayed choices. If the user selects the wrong option, a message is displayed, and the menu is presented again for the user to make a correct selection.
<!--IMAGE SCREENSHOT-->

![Screenshot 2024-04-26 at 2 28 30 PM](https://github.com/1uckyswish/Ace-Engineers-Store/assets/107442415/a0644212-5e2a-41a7-a8ca-d54e5bcd2048)

### Error Handling For Searching Store Inventory

<!--TEXT-->
If a user enters a product name that does not exist in our inventory, they will be prompted again to input a valid product name.
<!--IMAGE SCREENSHOT-->

![Screenshot 2024-04-26 at 2 29 17 PM](https://github.com/1uckyswish/Ace-Engineers-Store/assets/107442415/f9f0b72b-7139-4013-a525-5eb72a23ee52)

### Error Handling: If the user tries to check out their cart, but it's empty.

<!--TEXT-->
If the user tries to view their cart or proceed to checkout when it's empty, they will be prompted with a message indicating that the cart is empty. Then, they will be directed back to the home screen.
<!--IMAGE SCREENSHOT-->

![Screenshot 2024-04-26 at 2 29 29 PM](https://github.com/1uckyswish/Ace-Engineers-Store/assets/107442415/bc7bf5b7-7967-490a-8b94-064da7947b4d)

## Interesting Section of code
### Optimized Department Selection for Improved User Experience
<!--TEXT-->
In this code, we aimed for efficiency by providing users with a selection of departments to search from. We achieved this by storing the department options in an array and looping through them using an enhanced for loop.

Additionally, users are prompted to choose one of the departments from the list. This approach ensures a structured selection process, guiding users easily through the available categories.

Error handling was implemented to address scenarios where users choose the wrong department. In such cases, they are prompted again to make a valid selection.
<!--IMAGE SCREENSHOT-->
![Screenshot 2024-04-26 at 2 29 58 PM](https://github.com/1uckyswish/Ace-Engineers-Store/assets/107442415/d286dade-67c4-4332-9c0f-f1d981ba4f6b)

---
