import java.util.ArrayList;
/**
 * Name: James Sekcienski
 * Date: 11/28/21
 * Assignment: Unit 13 Case Problem 1
 *
 * Purpose (class description): The Playlist class is used to represent a playlist of songs. Every
 * Playlist has a name and a list of songs.
 */
public class Playlist {
  private String name;
  private ArrayList<Song> songs;

  /**
   * Constructs a Playlist with the specified name and songs
   * @param name the name of the playlist
   * @param songs the list of songs of the playlist
   */
  public Playlist(String name, ArrayList<Song> songs) {
    setName(name);
    setSongs(songs);
  }

  /**
   * Returns the name of this playlist
   * @return the name of this playlist
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of this playlist to the specified name
   * @param name the name to set for this playlist
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Returns the list of songs of this playlist
   * @return the list of songs of this playlist
   */
  public ArrayList<Song> getSongs() {
    return songs;
  }

  /**
   * Sets the list of songs of this playlist to the specified list of songs
   * @param songs the list of songs to set for this playlist
   */
  public void setSongs(ArrayList<Song> songs) {
    this.songs = songs;
  }

  /**
   * Overrides the toString method to return a String with details about this playlist and
   * its songs based on the values of the instance variables
   * @return the String representation of this playlist
   */
  @Override
  public String toString() {
    String result = "Playlist: " + name;
    for(int i = 0; i < songs.size(); i++) {
      result += "\n\t(" + (i + 1) + ") " + songs.get(i);
    }
    return result;
  }
}
