/**
 * Name: Joseph Parampathu
 * Date: 12/3/2021
 * Assignment: Unit 13 Case Problem 2
 *
 * Purpose (class description): This class contains creates book records using information about book sales from our dataset
 */

 public class BookSales
 {
   //Instance variables
   private String genre;
   private String soldBy;
   private String dailyAverageAmazonRevenue;
   private String dailyAverageAuthorRevenue;
   private String dailyAverageGrossSales;
   private String dailyAveragePublisherRevenue;
   private String dailyAverageUnitsSold;
   private String publisherName;
   private String publisherType;
   private String salePrice;
   private String salesRank;
   private String totalReviews;

   //Constructor method that takes the variables and sets to create the record, the parameters are each of the values (columns) in our dataset
   public BookSales(String bookGenre, String seller, String avgAmRev, String authorRev, String avgSales, String avgPubRev, String avgSold,
    String pubName, String pubType, String price, String rank, String reviews)
   {
     setGenre(bookGenre);
     setSoldBy(seller);
     setDailyAverageAmazonRevenue(avgAmRev);
     setDailyAverageAuthorRevenue(authorRev);
     setDailyAverageGrossSales(avgSales);
     setDailyAveragePublisherRevenue(avgPubRev);
     setDailyAverageUnitsSold(avgSold);
     setPublisherName(pubName);
     setPublisherType(pubType);
     setSalePrice(price);
     setSalesRank(rank);
     setTotalReviews(reviews);
   }

   //returns the genre of the book (fiction, nonfiction, etc)
   public String getGenre()
   {
     return genre;
   }

   //sets the genre (fiction, nonfiction, etc) of the book to the passed String
   public void setGenre(String genre)
   {
     this.genre = genre;
   }

   //returns the soldBy of the book (ex. Amazon, Random House)
   public String getSoldBy()
   {
     return soldBy;
   }

   //sets the soldBy of the book to the passed String (ex. Amazon, Random House)
   public void setSoldBy(String soldBy)
   {
     this.soldBy = soldBy;
   }

   //returns the dailyAverageAmazonRevenue of the book. This is the dollars earned on an average day by Amazon
   public String getDailyAverageAmazonRevenue()
   {
     return dailyAverageAmazonRevenue;
   }

   //sets the dailyAverageAmazonRevenue of the book to the passed value. This is the dollars earned on an average day by Amazon
   public void setDailyAverageAmazonRevenue(String dailyAverageAmazonRevenue)
   {
     this.dailyAverageAmazonRevenue = dailyAverageAmazonRevenue;
   }

   //returns the dailyAverageAuthorRevenue of the book. This is the dollars earned on an average day by the author
   public String getDailyAverageAuthorRevenue()
   {
     return dailyAverageAuthorRevenue;
   }

   //sets the dailyAverageAuthorRevenue of the book to the passed value. This is the dollars earned on an average day by the author
   public void setDailyAverageAuthorRevenue(String dailyAverageAuthorRevenue)
   {
     this.dailyAverageAuthorRevenue = dailyAverageAuthorRevenue;
   }

   //returns the getDailyAverageGrossSales of the book. This is the sales price times books sold on an average day (Dollar sales revenue per day)
   public String getDailyAverageGrossSales()
   {
     return dailyAverageGrossSales;
   }

   //sets the getDailyAverageGrossSales of the book to the passed value. This is the sales price time books sold on an average day (Dollar sales revenue per day)
   public void setDailyAverageGrossSales(String dailyAverageGrossSales)
   {
     this.dailyAverageGrossSales = dailyAverageGrossSales;
   }

   //returns the dailyAveragePublisherRevenue of the book. This is the dollars earned by the publisher for this book an average day
   public String getDailyAveragePublisherRevenue()
   {
     return dailyAveragePublisherRevenue;
   }

   //sets the dailyAveragePublisherRevenue of the book to the passed value. This is the dollars earned by the publisher for this book an average day
   public void setDailyAveragePublisherRevenue(String dailyAveragePublisherRevenue)
   {
     this.dailyAveragePublisherRevenue = dailyAveragePublisherRevenue;
   }

   //returns the dailyAverageUnitsSold of the book. This is the books sold on an average day
   public String getDailyAverageUnitsSold()
   {
     return dailyAverageUnitsSold;
   }

   //sets the dailyAverageUnitsSold of the book to the passed value. This is the books sold on an average day
   public void setDailyAverageUnitsSold(String dailyAverageUnitsSold)
   {
     this.dailyAverageUnitsSold = dailyAverageUnitsSold;
   }

   //returns the publisherName of the book. This is the book publisher's name
   public String getPublisherName()
   {
     return publisherName;
   }

   //sets the publisherName of the book to the passed value. This is the book publisher's name
   public void setPublisherName(String publisherName)
   {
     this.publisherName = publisherName;
   }

   //returns the publisherType of the book. This is the book publisher's type ("big five", "indie", "single author")
   public String getPublisherType()
   {
     return publisherType;
   }

   //sets the publisherType of the book to the passed value. This is the book publisher's type ("big five", "indie", "single author")
   public void setPublisherType(String publisherType)
   {
     this.publisherType = publisherType;
   }

   //returns the salePrice of the book. This is the book selling price.
   public String getSalePrice()
   {
     return salePrice;
   }

   //sets the salePrice of the book to the passed value. This is the book selling price.
   public void setSalePrice(String salePrice)
   {
     this.salePrice = salePrice;
   }

   //returns the salesRank of the book. This is the book selling rank compared to other books on the platform.
   public String getSalesRank()
   {
     return salesRank;
   }

   //sets the salesRank of the book to the passed value. This is the book selling rank compared to other books on the platform.
   public void setSalesRank(String salesRank)
   {
     this.salesRank = salesRank;
   }

   //returns the totalReviews of the book. This is the number of reviews on the platform for the book.
   public String getTotalReviews()
   {
     return totalReviews;
   }

   //sets the totalReviews of the book to the passed value. This is the number of reviews on the platform for the book.
   public void setTotalReviews(String totalReviews)
   {
     this.totalReviews = totalReviews;
   }

   /* DISABLED FOR JAUTHORSALES DEMO
   //This method overrides the toString method so that we can print the book information in a readable format
   @Override
   public String toString()
   {
     return "Genre: " + genre +
     "\nSold By: " + soldBy +
     "\nDaily Average Amazon Revenue: " + dailyAverageAmazonRevenue +
     "\nDaily Average Author Revenue: " + dailyAverageAuthorRevenue +
     "\nDaily Average Gross Sales: " + dailyAverageGrossSales +
     "\nDaily Average Publisher Revenue: " + dailyAveragePublisherRevenue +
     "\nDaily Average Units Sold: " + dailyAverageUnitsSold +
     "\nPublisher Name: " + publisherName +
     "\nPublisher Type: " + publisherType +
     "\nSales Price: " + salePrice +
     "\nSales Rank: " + salesRank +
     "\nTotal Reviews: " + totalReviews;
   }
   */
 }
