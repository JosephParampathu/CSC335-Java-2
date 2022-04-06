import java.util.Scanner;
import java.util.ArrayList;
/**
 * Name: James Sekcienski
 * Date: 11/14/21
 * Assignment: Unit 11 Case Problem 1
 *
 * Purpose (Class Description): This is to allow the user to complete a sample quiz and see how well they did on it.
 */
public class QuizDemo {
  private final static Scanner INPUT = new Scanner(System.in);

  public static void main(String[] args) {
    Quiz currentQuiz = new Quiz();

    ArrayList<Question> questions = currentQuiz.getQuestions();
    int numOfQuestions = questions.size();
    int totalPoints = 0;
    int pointsEarned = 0;
    for (int i = 0; i < numOfQuestions; i++) {
      Question question = questions.get(i);
      int pointsForQuestion = question.getNumOfPoints();
      totalPoints += pointsForQuestion;

      System.out.println("Question " + (i + 1) + " of " + numOfQuestions + " (Points Possible: " + pointsForQuestion + ")");
      String userAnswer = askQuestion(question);
      if (question.isCorrectAnswer(userAnswer)) {
        pointsEarned += pointsForQuestion;
      }
      System.out.println();
    }

    System.out.println("You have now completed the quiz");
    System.out.println("You earned " + pointsEarned + " out of " + totalPoints);
  }

  /**
   * This will ask the user the given question.  If it is a MultipleChoiceQuestion it will also ensure a valid
   * response is provided first.  It returns the answer the user enters/selects.
   * @param question The question to ask the user
   * @return The answer entered/selected by the user
   */
  public static String askQuestion(Question question) {
    if (question instanceof MultipleChoiceQuestion) {
      return askMultipleChoiceQuestion((MultipleChoiceQuestion) question);
    } else {
      System.out.println(question.getQuestionDisplay());
      String userAnswer = INPUT.nextLine();
      return userAnswer;
    }
  }

  /**
   * This is to handle asking a MultipleChoiceQuestion to ensure the number the user enters
   * is a valid option.  It will then return the text of the answer choice number the user selected.
   * @param question The question to ask the user
   * @return The text of the answer choice number the user selects
   */
  public static String askMultipleChoiceQuestion(MultipleChoiceQuestion question) {
    String[] answerChoices = question.getAnswerChoices();
    int numOfAnswerChoices = answerChoices.length;

    System.out.println(question.getQuestionDisplay());
    int userAnswerNum = INPUT.nextInt();
    INPUT.nextLine();
    while (userAnswerNum < 1 || userAnswerNum > numOfAnswerChoices) {
      System.out.println("Invalid choice entered.  Enter a number from the choices.");
      userAnswerNum = INPUT.nextInt();
      INPUT.nextLine();
    }

    return answerChoices[userAnswerNum - 1];
  }
}
