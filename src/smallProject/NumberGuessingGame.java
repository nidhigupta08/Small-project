package smallProject;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 50;
        int maxAttempts = 5;
        int rounds = 0;
        int score = 0;

        System.out.println("Welcome to the Fun-tastic Number Guessing Game!");

        while (true) {
            int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            int roundScore = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("Round " + (rounds + 1));
            System.out.println("I'm thinking of a mysteriously magical number between " + lowerBound + " and " + upperBound + ".");
            System.out.println("You have " + maxAttempts + " attempts to uncover its whimsical secrets.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your enchanting guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < lowerBound || userGuess > upperBound) {
                    System.out.println("Oh no! Please enter a number between " + lowerBound + " and " + upperBound + " like a wizard.");
                } else if (userGuess < numberToGuess) {
                    System.out.println("Oops, you're too low! You have " + (maxAttempts - attempts) + " magical attempts left.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Oops, you're too high! You have " + (maxAttempts - attempts) + " magical attempts left.");
                } else {
                    hasGuessedCorrectly = true;
                    break;
                }
            }

            if (hasGuessedCorrectly) {
                roundScore = maxAttempts - attempts + 1;
                score += roundScore;
                System.out.println("Congratulations! You've unlocked the mystical secrets! The number was " + numberToGuess + "!");
                System.out.println("Round score: " + roundScore);
                displayFunMessage();
            } else {
                System.out.println("Alas! The secrets remain hidden. The number was " + numberToGuess + ".");
                System.out.println("Round score: 0");
            }

            System.out.println("Your total score is now a magical " + score);
            System.out.print("Do you want to embark on another enchanting adventure? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
//            input is anything other than "yes," the condition is met, and the break statement is executed.
            if (!playAgain.equals("yes")) {
                break;
            }

            rounds++;
        }

        System.out.println("Thanks for playing! You've completed " + (rounds + 1) + " truly enchanting adventures.");
        scanner.close();
    }

    private static void displayFunMessage() {
        String[] messages = {
            "You're a mind reader!",
            "The number trembles in your presence!",
            "You've got the magic touch!",
            "Fortune favors the bold!",
            "The number bows before your might!",
            "You're the sorcerer of numbers!",
            "Hocus Pocus! You've nailed it!",
            "The number is no match for your wizardry!",
        };

        Random random = new Random();
        int index = random.nextInt(messages.length);
        System.out.println(messages[index]);
    }
}

