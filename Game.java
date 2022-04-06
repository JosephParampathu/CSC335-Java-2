/**
 * Name: Joseph Parampathu
 * Date: 11/14/21
 * Assignment: Unit 10 Case Problem 1
 *
 * Purpose (Class Description): A class called Game that is the base (parent) class. It defines some games with getters and setters and can be used to return a string defining the game.
 */

 public class Game
 {
   //This enumerator creates the game values
   public enum GameValues {CARD, BOARD, VIDEO};

   //This instantiates the variables
   private String name;
   private int minNumOfPlayers;
   private int maxNumOfPlayers;
   private GameValues type;

   //This is the constructor method that takes each of the variables and uses the setters to pass the values
   public Game(String cardName, int minPlayers, int maxPlayers, GameValues gameType)
   {
     setName(cardName);
     setMinPlayers(minPlayers);
     setMaxPlayers(maxPlayers);
     setType(gameType);
   }

   //The setter takes in a string and sets the name equal to it
   public void setName(String cardGameName)
   {
     name = cardGameName;
   }

   //The getter returns the name of the game
   public String getName()
   {
     return name;
   }

   //The setter takes in a number and sets the minimum players equal to it
   public void setMinPlayers(int min)
   {
     if (min < 1)
     {
       min = 1;
     }
     minNumOfPlayers = min;
   }

   //The getter returns the minimum players
   public int getMinPlayers()
   {
     return minNumOfPlayers;
   }

   //The setter takes in a number and sets the maximum players equal to it
   public void setMaxPlayers(int max)
   {
     if (max < minNumOfPlayers)
     {
       max = minNumOfPlayers;
     }
     maxNumOfPlayers = max;
   }

   //The getter returns the maximum players
   public int getMaxPlayers()
   {
     return maxNumOfPlayers;
   }

   //The setter takes in a game enum value and sets the type equal to it
   public void setType(GameValues cardGameType)
   {
     type = cardGameType;
   }

   //The getter returns the game type
   public GameValues getType()
   {
     return type;
   }

   //This creates the string representation of the game which is a message showing the basic details
   public String toString()
   {
     String message;
     message = name + " is a " + String.valueOf(type) + " game playable with " + minNumOfPlayers + " to " + maxNumOfPlayers + " players.";
     return message;
   }

 }
