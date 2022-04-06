/*
Name: Joseph Parampathu
Date: November 25, 2021
Assignment: CSC 335, Unit 11 Case Problems
Class Purpose: Java Programming II class working with object oriented programming in java
*/

public class FillInTheBlankQuestion extends Question
{
  //Sets the instance variables
  private String correctAnswer;
  private boolean isAnswerCaseSensitive;

  public FillInTheBlankQuestion(String prompt, int questNumOfPoints, String correctAnswerChoice, boolean isCaseSensitive)
  {
    //Calls the super constructor
    super(prompt, questNumOfPoints);
    //Setter methods set the other variables
    setCorrectAnswer(correctAnswerChoice);
    setIsAnswerCaseSensitive(isCaseSensitive);
  }

  //This method returns the correct answer
  public String getCorrectAnswer()
  {
    return correctAnswer;
  }

  //This method sets the correct answer to the passed value
  public void setCorrectAnswer(String correctAnswerPick)
  {
    correctAnswer = correctAnswerPick;
  }

  //This method returns whether the answer is case sensitive
  public boolean getIsAnswerCaseSensitive()
  {
    return isAnswerCaseSensitive;
  }

  //This method sets the case sensitive boolean value to the passed value
  public void setIsAnswerCaseSensitive(boolean isAnswerCase)
  {
    isAnswerCaseSensitive = isAnswerCase;
  }

  //This method returns the prompt message
  public String getQuestionDisplay()
  {
    String displayMessage = getPrompt();
    return displayMessage;
  }

  //This takes the passed string and returns whether the parameter is equal to the correct answer
  public boolean isCorrectAnswer(String guessedAnswer)
  {
    if (isAnswerCaseSensitive)
    {
      return (correctAnswer.equals(guessedAnswer));
    }
    else
    {
      return ((correctAnswer.toLowerCase()).equals(guessedAnswer.toLowerCase()));
    }
  }
}
