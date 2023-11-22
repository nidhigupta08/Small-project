package smallProject;

import java.util.Scanner;
import java.util.Random;

public class HangmanGame {
    public static void main(String[] args) {
        System.out.println("Welcome to Hangman! Try to guess the word.");
        System.out.println("The word is from the category of fruits.\n");

        Scanner scanner = new Scanner(System.in);

        String[] words = {"apple", "banana", "orange", "strawberry", "watermelon"};

        Random random = new Random();
        String wordToGuess = words[random.nextInt(words.length)];

        char[] guessedLetters = new char[wordToGuess.length()];

        for (int i = 0; i < guessedLetters.length; i++) {
            guessedLetters[i] = '_';
        }

        int attempts = 0;
        boolean wordGuessed = false;

        System.out.println("The below dashes shows the number of letters present in the word: ");

        while (!wordGuessed && attempts < 7) {
            String currentDisplay = displayWord(guessedLetters);
            System.out.println(currentDisplay);

            System.out.print("Enter a letter or guess the word: ");
            String guess = scanner.nextLine();

            if (guess.length() == 1) {
                char letterGuess = guess.charAt(0);

                if (!isLetterAlreadyGuessed(letterGuess, guessedLetters)) {
                    boolean found = false;

                    for (int i = 0; i < wordToGuess.length(); i++) {
                        if (wordToGuess.charAt(i) == letterGuess) {
                            guessedLetters[i] = letterGuess;
                            found = true;
                        }
                    }

                    if (!found) {
                        attempts++;
                        System.out.println("Incorrect guess. Attempts left: " + (7 - attempts));
                    }

                    if (isWordGuessed(guessedLetters)) {
                        wordGuessed = true;
                        System.out.println("Congratulations! You've guessed the word: " + wordToGuess);
                    }
                } else {
                    System.out.println("You've already guessed this letter.");
                }
            } else if (guess.length() == wordToGuess.length()) {
                if (guess.equals(wordToGuess)) {
                    wordGuessed = true;
                    System.out.println("Congratulations! You've guessed the word: " + wordToGuess);
                } else {
                    System.out.println("Sorry, incorrect guess.");
                    attempts++;
                }
            } else {
                System.out.println("Guess another word.");
            }
        }

        if (!wordGuessed) {
            System.out.println("Sorry, you ran out of attempts. The word was: " + wordToGuess);
        }

        scanner.close();
    }

    public static String displayWord(char[] guessedLetters) {
        StringBuilder result = new StringBuilder();

        for (char letter : guessedLetters) {
            result.append(letter).append(" ");
        }

        return result.toString();
    }

    public static boolean isLetterAlreadyGuessed(char guess, char[] guessedLetters) {
        for (char letter : guessedLetters) {
            if (letter == guess) {
                return true;
            }
        }
        return false;
    }

    public static boolean isWordGuessed(char[] guessedLetters) {
        for (char letter : guessedLetters) {
            if (letter == '_') {
                return false;
            }
        }
        return true;
    }
}
