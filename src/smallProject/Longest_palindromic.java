package smallProject;
import java.util.Scanner;

public class Longest_palindromic {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter a sentence: ");
	        String input = scanner.nextLine();
	        
	        String longestPalindrome = findLongestPalindrome(input);
	        
	        if (longestPalindrome.isEmpty()) {
	            System.out.println("No palindromic string found in the sentence.");
	        } else {
	            System.out.println("Longest palindromic string: " + longestPalindrome);
	        }
	    }

	    public static String findLongestPalindrome(String input) {
	        String[] words = input.split("\\s+"); // Split the sentence into words
	        
	        String longestPalindrome = "";
	        
	        for (String word : words) {
	            if (isPalindrome(word) && word.length() > longestPalindrome.length()) {
	                longestPalindrome = word;
	            }
	        }
	        
	        return longestPalindrome;
	    }

	    public static boolean isPalindrome(String str) {
	        int left = 0;
	        int right = str.length() - 1;

	        while (left < right) {
	            if (str.charAt(left) != str.charAt(right)) {
	                return false;
	            }
	            left++;
	            right--;
	        }

	        return true;
	    }
}
