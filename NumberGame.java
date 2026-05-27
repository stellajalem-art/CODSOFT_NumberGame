import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int totalScore = 0;
        int round = 1;
        char playAgain;

        do {

            int number = rand.nextInt(100) + 1;
            int guess;
            int attempts = 0;
            int maxAttempts = 7;
            boolean guessedCorrectly = false;

            System.out.println("========== ROUND " + round + " ==========");
            System.out.println("Guess a number between 1 and 100");
            System.out.println("You have only " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {

                System.out.print("Enter your guess: ");
                guess = sc.nextInt();

                attempts++;

                if (guess == number) {
                    System.out.println("Correct! You guessed the number.");
                    System.out.println("Attempts taken: " + attempts);

                    totalScore += (maxAttempts - attempts + 1) * 10;
                    guessedCorrectly = true;
                    break;
                }

                else if (guess > number) {
                    System.out.println("Too high!");
                }

                else {
                    System.out.println("Too low!");
                }

                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println("You lost!");
                System.out.println("The correct number was: " + number);
            }

            System.out.println("Total Score: " + totalScore);

            System.out.print("Do you want to play again? (y/n): ");
            playAgain = sc.next().charAt(0);

            round++;

        } while (playAgain == 'y' || playAgain == 'Y');

        System.out.println("Thank you for playing!");
        sc.close();
    }
}
