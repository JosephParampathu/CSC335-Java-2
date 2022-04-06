/*
Name: Joseph Parampathu
Date: November 28, 2021
Assignment: CSC 335, Unit 12 Case Problems
Class Purpose: This class allows the user to create an array of movie objects and displays those objects information

*/

import java.util.*;
public class MovieDemo
{
  //main method
  public static void main(String[] args)
  {
    //Creates the array of movie objects
    Movie[] movies = new Movie[3];
    Movie MovieDemonstration;
    for (int loopControlVariable = 0; loopControlVariable < movies.length; ++loopControlVariable)
    {
      try
      {
        MovieDemonstration = new Movie(requestTitle(), requestDirector(), requestReleaseYear(), requestRuntime(), requestRating());
        movies[loopControlVariable] = MovieDemonstration;
      }
      catch (NegativeMovieRuntimeException error)
      {
        System.out.println("Unable to create a Movie object.");
        System.out.println(error.toString());
      }
      catch (ArrayIndexOutOfBoundsException error)
      {
        System.out.println("Unable to create a Movie object.");
        System.out.println(error.toString());
      }
    }
    //Displays the array
    displayMovies(movies);
  }

  //this method displays the information contained in each movie object in the passed array
  public static void displayMovies(Movie[] filmArray)
  {
    //uses a "for each" loop to display each variable for each object
    for (Movie film : filmArray)
    {
    System.out.println("Movie Title: " + film.getTitle());
    System.out.println("Movie Director: " + film.getDirector());
    System.out.println("Movie Release Year: " + film.getReleaseYear());
    System.out.println("Movie Runtime: " + film.getRuntime());
    System.out.println("Movie Rating: " + film.getRatingAsString(film.getRating()));
    }
  }

  //This method prompts the user to enter a movie title
  public static String requestTitle()
  {
    Scanner input = new Scanner(System.in);
    String title;
    System.out.println("Please enter the movie's title: >> ");
    title = input.nextLine();
    return title;
  }

  //This method prompts the user to enter a movie director
  public static String requestDirector()
  {
    Scanner input = new Scanner(System.in);
    String director;
    System.out.println("Please enter the movie's Director: >> ");
    director = input.nextLine();
    return director;
  }

  //This method prompts the user to enter a release year and validates it
  public static int requestReleaseYear()
  {
    Scanner input = new Scanner(System.in);
    int releaseYear;
    System.out.println("Please enter the movie's release year: >> ");
    while(!input.hasNextInt())
    {
      System.out.println("Please enter a valid integer: >> ");
      input.nextLine();
      System.out.println("Please enter the movie's release year: >> ");
    }
    releaseYear = input.nextInt();
    input.nextLine();
    return releaseYear;
  }

  //This method prompts the user to enter a movie run time and validates it
  public static int requestRuntime()
  {
    Scanner input = new Scanner(System.in);
    int runtime = -1;
    //If runtime is negative, prompts user for a valid input
    while(runtime < 0)
    {
      System.out.println("Please enter the movie's runtime (positive number): >> ");
      try
      {
        runtime = input.nextInt();
      }
      catch (Exception e)
      {
        input.nextLine();
        System.out.println("Your entry is not a valid positive number");
      }
    }
    input.nextLine();
    return runtime;
  }

  //This method prompts the user to enter a movie rating and validates it
  public static int requestRating()
  {
    int rating = 0;
    Scanner input = new Scanner(System.in);
    for (int j = 0; j < Movie.RATINGSLIST.length; j++)
    {
      System.out.println((j + 1) + ": " + Movie.getRatingAsString(j));
    }
    //While loop checks to make sure rating is a valid value
    while (rating != 1 && rating != 2 && rating != 3 && rating != 4 && rating != 5)
    {
      System.out.println("Please enter the movie's rating using the menu above (numbers 1-5): >> ");
      try
      {
        rating = input.nextInt();
        input.nextLine();
      }
      catch (Exception e)
      {
        input.nextLine();
        System.out.println("Your entry is not a valid positive number");
      }
    }
    rating = rating - 1;
    return rating;
  }

}
