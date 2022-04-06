/*
Name: Joseph Parampathu
Date: November 25, 2021
Assignment: CSC 335, Unit 11 Case Problems
Class Purpose: An Abstract method for the question that allows other classes to extend it
*/

public abstract class Question
{
  //Instance variables
  private String prompt;
  private int numOfPoints;

  //This is the constructor method for the question that sets the prompt and points
  public Question(String questionPrompt, int numberOfPoints)
  {
    setPrompt(questionPrompt);
    setNumOfPoints(numberOfPoints);
  }

  //Method that returns the questions prompt
  public String getPrompt()
  {
    return prompt;
  }

  //Method that sets the prompt equal to the passed string
  public void setPrompt(String questPrompt)
  {
    prompt = questPrompt;
  }

  //Method that returns the number of points
  public int getNumOfPoints()
  {
    return numOfPoints;
  }

  //Method that sets the number of points equal to the passed int
  public void setNumOfPoints(int points)
  {
    if (points >= 0)
    {
      numOfPoints = points;
    }
  }

  //Abstract method that returns the correct answer as a string
  public abstract String getCorrectAnswer();

  //Abstract method that returns the question as a string
  public abstract String getQuestionDisplay();

  //Abstract method that returns the true if the answer is correct or otherwise false
  public abstract boolean isCorrectAnswer(String answerChoice);
}
