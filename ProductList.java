/**
 * Name: Joseph Parampathu
 * Date: 11/07/21
 * Assignment: Unit 9 Case Problem 1
 *
 * Purpose (Class Description): Provides a list of products in the store and various methods to sort the list.
 */
 import java.util.*;

 //This class creates a product list as an ArrayList for each store
 public class ProductList
 {
   ArrayList<Product> products = new ArrayList<Product>();

   //This is a constructor method that takes no parameters and sets the initial inventory
   public ProductList()
   {
     setInitialInventory();
   }

   //This is the method to set the initial inventory ArrayList
   public ArrayList<Product> setInitialInventory()
   {
     products.add(new Product("1", "Beans", 5.00, 10.00));
     products.add(new Product("2", "Rice", 6.20, 12.00));
     products.add(new Product("6", "Salt", 1.00, 2.50));
     products.add(new Product("4", "Flour", 3.50, 5.00));
     products.add(new Product("10", "Cabbage", 15.00, 500.00));
     return products;
   }

   //This method takes in a product object and adds it to the arraylist products
   public void addProduct(Product itemToAdd)
   {
     products.add(itemToAdd);
   }

   //This method takes in a product object and removes it from the arraylist
   public void removeProduct(Product itemToRemove)
   {
     products.remove(itemToRemove);
   }

   //This method sorts the products by the id of the products objects
   public void sortProductsById()
   {
     int a = 1;
     int b = 0;
     Product temp;
     final int HIGHSUBSCRIPT = products.size() - 1;
     while (a < HIGHSUBSCRIPT)
     {
       temp = products.get(a);
       b = a - 1;
       while (b >= 0 && products.get(b).getId().compareTo(temp.getId()) > 0)
       {
         products.set(b + 1, products.get(b));
         --b;
       }
       products.set(b + 1, temp);
       ++a;
     }

   }

   //This method sorts the products by the name of the products objects
   public void sortProductsByName()
   {
     int a = 1;
     int b = 0;
     Product temp;
     final int HIGHSUBSCRIPT = products.size() - 1;
     while (a <= HIGHSUBSCRIPT)
     {
       temp = products.get(a);
       b = a - 1;
       while (b >= 0 && products.get(b).getName().compareTo(temp.getName()) > 0)
       {
         products.set(b + 1, products.get(b));
         --b;
       }
       products.set(b + 1, temp);
       ++a;
     }

   }

   //This method sorts the products by the Cost of the products objects
   public void sortProductsByCost()
   {
     int a = 1;
     int b = 0;
     Product temp;
     final int HIGHSUBSCRIPT = products.size() - 1;
     while (a < HIGHSUBSCRIPT)
     {
       temp = products.get(a);
       b = a - 1;
       while (b >= 0 && products.get(b).getCost() > temp.getCost())
       {
         products.set(b + 1, products.get(b));
         --b;
       }
       products.set(b + 1, temp);
       ++a;
     }

   }

   //This method sorts the products by the price of the products objects
   public void sortProductsByPrice()
   {
     int a = 1;
     int b = 0;
     Product temp;
     final int HIGHSUBSCRIPT = products.size() - 1;
     while (a < HIGHSUBSCRIPT)
     {
       temp = products.get(a);
       b = a - 1;
       while (b >= 0 && products.get(b).getPrice() > temp.getPrice())
       {
         products.set(b + 1, products.get(b));
         --b;
       }
       products.set(b + 1, temp);
       ++a;
     }

   }

   //This method displays all the products information in a readable format
   public String getProductsDisplay()
   {
     String productsDisplayMessage = "";
     for (Product eachProduct: products)
     {
       productsDisplayMessage += eachProduct.getProductsDisplay() + "\n";
     }
     return productsDisplayMessage;
   }
 }
