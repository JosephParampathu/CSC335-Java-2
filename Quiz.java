/*
Name: Joseph Parampathu
Date: November 25, 2021
Assignment: CSC 335, Unit 11 Case Problems
Class Purpose: Java Programming II class working with object oriented programming in java
*/
import java.util.*;
public class Quiz
{
  //Instantiated variables
  private ArrayList<Question> questions = new ArrayList<Question>();

  //This is the constructor method for the quiz class that takes no parameters
  public Quiz()
  {
    createSampleQuiz();
  }

  //This method returns the value of the questions array list
  public ArrayList<Question> getQuestions()
  {
    return questions;
  }

  //This method sets the value of the array list
  public void setQuestions(Question eachQuestion)
  {
    questions.add(eachQuestion);
  }

  //This method creates the quiz for the game
  public void createSampleQuiz()
  {
    String[] answersOne = {"Five", "Six", "Nine Thousand", "Fourteen", "Forty"};
    String[] answersTwo = {"9,000", "40", "17", "0", "5,000,000"};
    setQuestions(new FillInTheBlankQuestion("What is the capital city of California?", 5, "Sacramento", false));
    setQuestions(new FillInTheBlankQuestion("What object-oriented programming language uses ArrayLists?", 5, "Java", false));
    setQuestions(new MultipleChoiceQuestion("Which of these numbers is largest?", 5, answersOne, 2));
    setQuestions(new MultipleChoiceQuestion("What is 5 + 12?", 5, answersTwo, 2));
  }
}
