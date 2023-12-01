package smallProject;

import java.util.Random;
import java.util.Scanner;

public class CoinFlipSimulator {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        Random random = new Random();

	        System.out.println("Welcome to the Coin Flip Game! \n");
	        System.out.println("You'll make predictions for each coin toss.");

	        int rounds;
	        do {
	            System.out.print("Enter the number of rounds you want to play: ");
	            while (!scanner.hasNextInt()) {
	                System.out.println("Please enter a valid number.");
	                scanner.next();
	            }
	            rounds = scanner.nextInt();
	            if (rounds <= 0) {
	                System.out.println("Please enter a positive number of rounds.");
	            }
	        } while (rounds <= 0);

	        int playerScore = 0;

	        for (int round = 1; round <= rounds; round++) {
	            System.out.println("\nRound " + round);
	            System.out.print("Predict 'Heads' or 'Tails': ");
	            String prediction = scanner.next().toLowerCase();

	            // Simulate coin toss
	            int result = random.nextInt(2); // 0 for Heads, 1 for Tails
	            String coinResult = (result == 0) ? "Heads" : "Tails";

	            System.out.println("Coin result: " + coinResult);

	            // Compare prediction and actual result
	            if (prediction.equalsIgnoreCase(coinResult)) {
	                System.out.println("Your prediction was correct!");
	                playerScore++;
	            } else {
	                System.out.println("Your prediction was incorrect.");
	            }
	        }

	        System.out.println("\nGame Over!");
	        System.out.println("Your total score: " + playerScore + " out of " + rounds);

	        scanner.close();
	    }
}
