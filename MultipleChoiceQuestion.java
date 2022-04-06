/*
Name: Joseph Parampathu
Date: November 25, 2021
Assignment: CSC 335, Unit 11 Case Problems
Class Purpose: Extends the subclass Question and creates a special type of question with access to the abstract superclass's methods
*/

public class MultipleChoiceQuestion extends Question
{
  //Define Instance Variables
  private int correctAnswerIndex;
  private String[] answerChoicesArray;
  //Constructor method

  //This method creates the multiple choice question object with user input
  public MultipleChoiceQuestion(String prompt, int questNumOfPoints, String[] answerChoices, int correctAnswerIndex)
  {
    //Calls the super constructor
    super(prompt, questNumOfPoints);
    //Setter methods set the other variables
    setAnswerChoices(answerChoices);
    setCorrectAnswer(correctAnswerIndex);
  }

  //This method sets the answer choices array to the answers provided
  public void setAnswerChoices(String[] answer)
  {
    answerChoicesArray = answer;
  }

  //This method returns the answer choices as an array
  public String[] getAnswerChoices()
  {
    return answerChoicesArray;
  }

  //This method sets the correct answer based on the user input if it is valid
  public void setCorrectAnswer(int correctGuess)
  {
    //Checks that value is valid
    if (correctGuess < 0 || correctGuess >= answerChoicesArray.length)
    {
      correctGuess = -1;
    }
    correctAnswerIndex = correctGuess;
  }

  //This method returns the correct answer
  public String getCorrectAnswer()
  {
    String questionMessage = "";
    //provides answer as a string if it is valid
    if (correctAnswerIndex == -1)
    {
      questionMessage = "ERROR: Correct Answer Unknown";
      return questionMessage;
    }
    else
    {
      questionMessage = answerChoicesArray[correctAnswerIndex];
      return questionMessage;
    }
  }

  //This method gets the display message for the question
  public String getQuestionDisplay()
  {
    String displayMessage = getPrompt();
    int i = 1;
    for (String answerChoice : answerChoicesArray)
    {
      displayMessage += "\n\t(" + i  + ") " + answerChoice;
      i++;
    }
    return displayMessage;
  }

  //This method returns true or false for whether the passed value is the correct answer
  @Override
  public boolean isCorrectAnswer(String guessedAnswer)
  {
    return (answerChoicesArray[correctAnswerIndex].equals(guessedAnswer));
  }
}
