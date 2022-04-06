/*
Name: Joseph Parampathu
Date: October 31, 2021
Assignment: CSC 335, Unit 8 Case Problems
Class Purpose: Java Programming II class working with object oriented programming in java
*/

import java.util.*;
import java.lang.*;
public class QuizGenerator
{
  //main method
  public static void main(String[] args)
  {
    //Creates the array of MultipleChoiceQuestion objects
    MultipleChoiceQuestion[] multichoice = new MultipleChoiceQuestion[5];
    for (int x = 0; x < multichoice.length; ++x)
    //Calls the helper to construct the array objects
      {
        multichoice[x] = construct();
      }
    //Displays the array
    displayQuizDetails(multichoice);
  }

  //displayQuizDetails method takes the array and prints the questions and answers
  public static void displayQuizDetails(MultipleChoiceQuestion[] questionArray)
  {
    //uses a "for each" loop to display each variable for each object
    for (MultipleChoiceQuestion questions : questionArray)
    {
      System.out.println("Question: " + questions.getQuestion());
      System.out.println("Answers: ");
      char letterChoice = 'A';
      for (String value : questions.getAnswerChoicesArray())
        {
          if (value != null)
          { System.out.println("\n" + letterChoice + " - " + value);
            letterChoice++;
          }

        }
        //Transforms the correct answer into a letter character and provides the correct text answer
      System.out.println("Correct Answer: " + (char)('A' + questions.getAnswer()) + " - " + questions.getCorrectAnswerAsString());
    }

  }

  //multihelper method to create the objects
  public static MultipleChoiceQuestion construct()
  {
    //creates the MultipleChoiceQuestion object by prompting user for input (calls the request functions)
    String questionPassing = requestQuestion();
    String[] array = requestAnswerChoicesArray();
    MultipleChoiceQuestion multiple = new MultipleChoiceQuestion(questionPassing, array, requestCorrectAnswerIndex(questionPassing, array));
    return multiple;
  }

  //Define methods to create each individual variable part of the MultipleChoiceQuestion objects
    public static String requestQuestion()
    {
      Scanner input = new Scanner(System.in);
      String question;
      System.out.println("Please enter the question: >> ");
      question = input.nextLine();
      return question;
    }

    //This method requests the correct answer based on the question and answer choices
    public static int requestCorrectAnswerIndex(String quest, String[] answerChoices)
    {
      Scanner input = new Scanner(System.in);
      System.out.println("\nQuestion: " + quest);
      System.out.println("\nAnswers: ");
      int correctAnswerIndex;
      char answerChar;
      char letterOption = 'A';
      for (String ans : answerChoices)
        {
          //Prints only valid answers, not null values
          if (ans != null)
          {
            System.out.println("\n" + letterOption + " - " + ans);
            letterOption++;
          }

        }

      System.out.println("\nPlease enter the correct answer: >> ");
      answerChar = input.next().charAt(0);
      correctAnswerIndex = answerChar - 65;
      return correctAnswerIndex;
    }

    //This method takes the answer choices and uses them to create an array
    public static String[] requestAnswerChoicesArray()
    {
      Scanner input = new Scanner(System.in);
      String presentAnswerChoice;
      int numberOfChoices;
      System.out.println("How many answer choices will there be?: >> ");
      numberOfChoices = input.nextInt();
      //Deletes any blank new line space
      input.nextLine();
      String[] answerChoicesArray = new String[numberOfChoices];
      int y;
      for (y = 1; y <= numberOfChoices; ++y)
        {
          System.out.println("Enter the answer choice: >> ");
          answerChoicesArray[y-1] = input.nextLine();
        }
      return answerChoicesArray;
    }

}
