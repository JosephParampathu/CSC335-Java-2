/*
Name: Joseph Parampathu
Date: November 22, 2021
Assignment: CSC 335, Unit 12 Case Problems
Class Purpose: The movie class holds the data for each movie object which includes its director, title, release year, runtime, and rating

*/

public class Movie
{
  //Define Instance Variables
  private String title;
  private String director;
  private int releaseYear;
  private int runtime;
  private int rating;
  //Define array for movie ratings in text form
  static final String[] RATINGSLIST = {"G", "PG", "PG-13", "R", "NC-17"};
  //Constructor method that uses the passed information to create a movie object
  public Movie(String movTitle, String movDirector, int movReleaseYear, int movRunTime, int movRating) throws NegativeMovieRuntimeException, ArrayIndexOutOfBoundsException
  {
    setTitle(movTitle);
    setDirector(movDirector);
    setReleaseYear(movReleaseYear);
    setRuntime(movRunTime);
    setRating(movRating);
  }

  //This method takes the passed string and sets the title equal to it
  public void setTitle(String movieTitle)
  {
    title = movieTitle;
  }

    //This method returns the title
  public String getTitle()
  {
    return title;
  }

  //This method takes the passed string and sets the director equal to it
  public void setDirector(String movieDirector)
  {
    director = movieDirector;
  }

    //This method returns the director
  public String getDirector()
  {
    return director;
  }

  //This method takes the passed integer and sets the release year equal to it
  public void setReleaseYear(int year)
  {
    releaseYear = year;
  }

    //This method returns the release year
  public int getReleaseYear()
  {
    return releaseYear;
  }

  //This method takes the passed integer and sets the runtime equal to it
  public void setRuntime(int movieRuntime) throws NegativeMovieRuntimeException
  {
    if (movieRuntime < 0)
    {
      throw new NegativeMovieRuntimeException();
    }
    runtime = movieRuntime;
  }

    //This method returns the runtime
  public int getRuntime()
  {
    return runtime;
  }

  //This method takes the passed integer and sets the movie rating equal to it
  public void setRating(int rate) throws ArrayIndexOutOfBoundsException
  {
    //Check that rating is within the acceptable range or throw the exception
    if(rate > RATINGSLIST.length || rate < 0)
    {
      throw new ArrayIndexOutOfBoundsException();
    }
    else
    {
    rating = rate;
    }
  }

  //This method returns the rating as a string
  public static String getRatingAsString(int movieRate)
  {
    return RATINGSLIST[movieRate];
  }

  //This method returns the rating as an index
  public int getRating()
  {
    return rating;
  }
  
}
