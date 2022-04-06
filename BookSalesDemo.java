/**
 * Name: Joseph Parampathu
 * Date: 12/5/2021
 * Assignment: Unit 13 Case Problem 2
 *
 * Purpose (class description): This class contains creates book records using information about book sales from our dataset
 * Dataset Download Link: https://corgis-edu.github.io/corgis/csv/publishers/
 */
 import java.nio.file.*;
 import java.io.*;
 import java.nio.ByteBuffer;
 import java.util.Scanner;
 import java.util.ArrayList;


 public class BookSalesDemo
 {
   private final static Scanner INPUT = new Scanner(System.in);

   //main method asks for file path and then attempts to open the file and list its contents
   public static void main(String[] args)
   {
     String filename = "";
     filename = askForFilePath();
     ArrayList<BookSales> listOfBookData = openDataFile(filename);
     System.out.println("Attempting to open file");
     if (listOfBookData != null)
     {
       System.out.println("Data file successfully opened");
       displayData(listOfBookData);
     }
   }

   //thie method retrieves the string name for a file that the user wants to open
   public static String askForFilePath()
   {
     String pathResponse = "";
     System.out.println("Enter the file path: >> ");
     pathResponse = INPUT.nextLine();
     return pathResponse;
   }

   //Returns a booksales list with the booksales objects for each row of the desired file. It takes the parameter for the filename
   public static ArrayList<BookSales> openDataFile(String file)
   {
     ArrayList<BookSales> bookSalesInfo = new ArrayList<BookSales>();
     String s = "";
     String delimiter = ",";
     String genre = "";
     String soldBy = "";
     String dailyAverageAmazonRevenue;
     String dailyAverageAuthorRevenue;
     String dailyAverageGrossSales;
     String dailyAveragePublisherRevenue;
     String dailyAverageUnitsSold;
     String publisherName = "";
     String publisherType = "";
     String salePrice;
     String salesRank;
     String totalReviews;
     String[] array = new String[12];

     try
     {
       Path filePath = Paths.get(file);
       InputStream input = new BufferedInputStream(Files.newInputStream(filePath));
       BufferedReader reader = new BufferedReader(new InputStreamReader(input));
       reader.readLine();
       s = reader.readLine();
       while(s != null)
       {
         array = s.split(delimiter);
         genre = array[0];
         soldBy = array[1];
         dailyAverageAmazonRevenue = array[2];
         dailyAverageAuthorRevenue = array[3];
         dailyAverageGrossSales = array[4];
         dailyAveragePublisherRevenue = array[5];
         dailyAverageUnitsSold = array[6];
         publisherName = array[7];
         publisherType = array[8];
         salePrice = array[9];
         salesRank = array[10];
         totalReviews = array[11];
         bookSalesInfo.add(new BookSales(genre, soldBy, dailyAverageAmazonRevenue, dailyAverageAuthorRevenue, dailyAverageGrossSales, dailyAveragePublisherRevenue, dailyAverageUnitsSold, publisherName, publisherType, salePrice, salesRank, totalReviews));
         s = reader.readLine();
       }
       reader.close();
     }
     catch(Exception error)
     {
       System.out.println("Message: " + error);
       bookSalesInfo = null;
     }
     return bookSalesInfo;
   }

   //This method displays the information from the passed arraylist of booksales objects
   public static void displayData(ArrayList<BookSales> BookData)
   {
     for(BookSales eachBook : BookData)
     {
       System.out.println(eachBook);
     }
   }

 }
