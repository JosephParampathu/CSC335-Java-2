/**
 * Name: James Sekcienski
 * Date: 11/28/21
 * Assignment: Unit 13 Case Problem 1
 *
 * Purpose (class description): The Song class is used to represent songs.  Every Song has a
 * title and an artist.
 */
public class Song {
  private String title;
  private String artist;

  /**
   * Constructs a song with the specified title and artist
   * @param title the title of this song
   * @param artist the artist that performs this song
   */
  public Song(String title, String artist) {
    setTitle(title);
    setArtist(artist);
  }

  /**
   * Returns the title of this song
   * @return the title of this song
   */
  public String getTitle() {
    return title;
  }

  /**
   * Sets the title of this song to the specified title
   * @param title the title to set for this song
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * Returns the artist of this song
   * @return the artist of this song
   */
  public String getArtist() {
    return artist;
  }

  /**
   * Sets the artist of this song to the specified artist
   * @param artist the artist to set that performs this song
   */
  public void setArtist(String artist) {
    this.artist = artist;
  }

  /**
   * Overrides the toString method to return a String with a details about this song
   * based on the values of the instance variables
   * @return a String representation of this song
   */
  @Override
  public String toString() {
    return "Title: " + title + "\tArtist: " + artist;
  }
}
