import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.nio.file.*;
import java.io.*;
import java.nio.ByteBuffer;
import static java.nio.file.StandardOpenOption.*;
/**
 * Name: Joseph Parampathu
 * Date: 12/5/2021
 * Assignment: Unit 13 Case Problem 1
 *
 * Purpose (class description): This class demonstrates the Song.java and Playlist.java files and allows the user to add songs to the playlist
 */
public class PlaylistDemo {
  private final static Scanner INPUT = new Scanner(System.in);

  public static void main(String[] args) {
    Playlist userPlaylist = askForPlaylist();
    System.out.println(userPlaylist);
    System.out.println("Attempting to save the playlist");
    if(userPlaylist != null)
    {
      if (savePlaylist(userPlaylist))
      {
        System.out.println("Playlist successfully saved");
      }
      else
      {
        System.out.println("Playlist not successfully saved");
      }
    }
    else
    {
      System.out.println("Playlist is empty.");
    }
    System.out.println("Attempting to open the playlist");

    userPlaylist = openPlaylist(userPlaylist.getName());
    System.out.println("Playlist successfully saved");
    System.out.println(userPlaylist);

    // TODO: Add on to this based on the requirements in the README for this assignment
  }

  /**
   * Requests information from the user needed to create a playlist. It will construct the
   * playlist based on the user input and return it.
   * @return the playist created based on user input
   */
  public static Playlist askForPlaylist() {
    String name = askForStringValue("Enter playlist name: ");
    ArrayList<Song> songs = askForSongs();
    return new Playlist(name, songs);
  }

  /**
   * Requests information from the user needed to create a list of songs. It will continue asking
   * for more information as long as the user wishes to continue.  When the user decides to stop
   * adding songs, it will return the list of songs created based on the user.
   * @return the list of songs created based on user input
   */
  public static ArrayList<Song> askForSongs() {
    ArrayList<Song> songs = new ArrayList<Song>();
    boolean isAddingSongs = true;
    do {
      isAddingSongs = askIfAddingSong();
      System.out.println();

      if (isAddingSongs) {
        Song song = askForSong();
        System.out.println();
        songs.add(song);
      }
    } while (isAddingSongs);
    return songs;
  }

  /**
   * Requests information from the user needed to create a song.  Returns the song created
   * based on the user input.
   * @return the song created based on user input
   */
  public static Song askForSong() {
    String title = askForStringValue("Enter the title of the song: ");
    String artist = askForStringValue("Enter the artist of the song: ");
    return new Song(title, artist);
  }

  /**
   * Asks the user if they would like to add another song to the playlist and repeats until a valid
   * response is provided.  Returns a boolean representing whether the user would like to add
   * another song to the playlist or not.
   * @return boolean representing whether the user would like to add another song to the playlist
   * or not
   */
  public static boolean askIfAddingSong() {
    while (true) {
      String continueResponse = askForStringValue("Would you like to add a song to the playlist (y/n)? ");
      if (continueResponse.equalsIgnoreCase("y")) {
        return true;
      } else if (continueResponse.equalsIgnoreCase("n")) {
        return false;
      } else {
        System.out.println("Invalid response.  Please enter 'y' for YES or 'n' for NO");
      }
    }
  }

  /**
   * Outputs the prompt to the user to request information.  Reads in the next line of information
   * and returns it.
   * @param prompt the prompt to output to the user for the requested information
   * @return the String value entered by the user
   */
  public static String askForStringValue(String prompt) {
    System.out.println(prompt);
    return INPUT.nextLine();
  }

  /**
   * Outputs the prompt to the user to request information.  Tries to read in the next integer
   * value.  It will provide an error message and repeat the prompt if the next value is
   * not an integer, if it is less than the specified minValue, or if it is greater than
   * the specified maxValue.  Returns the valid integer value entered by the user.
   * @param prompt the prompt to output to the user for the requested information
   * @param minValue the lowest valid integer value
   * @param maxValue the highest valid integer value
   * @return the valid integer value entered by the user
   */
  public static int askForIntBounded(String prompt, int minValue, int maxValue) {
    System.out.println(prompt);
    int answer;
    while (true) {
      try {
        answer = INPUT.nextInt();
        INPUT.nextLine();
        if (answer < minValue) {
          System.out.println("Value must not be less than " + maxValue);
        } else if (answer > maxValue) {
          System.out.println("Value must not exceed " + maxValue);
        } else {
          break;
        }
      } catch (InputMismatchException e) {
        System.out.println("You need to enter a number.");
        INPUT.nextLine();
      }
    }
    return answer;
  }

  //This method will attempt to save the details of the list of songs to a file, it takes a parameter of the playlist object and saves its details
  public static boolean savePlaylist(Playlist playlistName)
  {
    boolean success = false;
    Path file = Paths.get(playlistName.getName() + ".txt");
    String s = "";
    String delimiter = "/t";
    ArrayList<Song> songsList = playlistName.getSongs();
    OutputStream output = null;

    try
    {
      file.getFileSystem().provider().checkAccess(file);
      System.out.println("Do you want to overwrite the existing file? (Y/N) >> ");
      String response = "";
      response = INPUT.nextLine();
      while (!response.equals("Y") && !response.equals("N"))
      {
        System.out.println("Invalid input. Enter only 'Y' or 'N'. >> ");
        response = INPUT.nextLine();
      }
      if (response.equals("N"))
      {
        System.out.println("Pick a new playlist name. >> ");
      }
      else
      {
        //Overtwrite the file
        try
        {
          output = new BufferedOutputStream(Files.newOutputStream(file, WRITE, CREATE, TRUNCATE_EXISTING));
          for(Song eachSong : songsList)
          {
            s += eachSong.getTitle() + delimiter + eachSong.getArtist() + "\n";
          }
          byte[] data = s.getBytes();
          output.write(data);
          output.flush();
          output.close();
          success = true;
        }
        catch (Exception errorMessage)
        {
          System.out.println("Message: " + errorMessage);
        }
      }
    }
    catch (Exception e)
    {
      System.out.println("A new file will need to be created for the playlist.");
      try
      {
        output = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
        for(Song eachSong : songsList)
        {
          s += eachSong.getTitle() + delimiter + eachSong.getArtist() + "\n";
        }
        byte[] data = s.getBytes();
        output.write(data);
        output.flush();
        output.close();
        success = true;
      }
      catch (Exception error)
      {
        System.out.println("Message: " + error);
      }
    }
    return success;
  }

  //This method will attempt to open a playlist taking a String parameter for the name of the playlist file
  public static Playlist openPlaylist(String playlistToOpen)
  {
    Playlist listToOpen;
    ArrayList<Song> songsForList = new ArrayList<Song>();
    String songName = "";
    String songArtist = "";
    String s = "";
    String delimiter = "/t";
    String[] array = new String[2];

    try
    {
      Path filePath = Paths.get(playlistToOpen + ".txt");
      filePath.getFileSystem().provider().checkAccess(filePath);
      InputStream input = new BufferedInputStream(Files.newInputStream(filePath));
      BufferedReader reader = new BufferedReader(new InputStreamReader(input));
      s = reader.readLine();
      while(s != null)
      {
        array = s.split(delimiter);
        songName = array[0];
        songArtist = array[1];
        songsForList.add(new Song(songName, songArtist));
        s = reader.readLine();
      }
      reader.close();
      listToOpen = new Playlist(playlistToOpen, songsForList);
    }
    catch(Exception potentialError)
    {
      System.out.println("Message: " + potentialError);
      listToOpen = null;
    }
    return listToOpen;
  }
}
