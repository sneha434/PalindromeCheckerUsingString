import java.util.Scanner;
import java.util.Stack;

// Encapsulated class
class PalindromeChecker {

    // Public method to check palindrome
    public boolean checkPalindrome(String input) {

        // Step 1: Normalize string
        String normalized = input.toLowerCase().replaceAll("[^a-z0-9]", "");

        // Step 2: Use Stack (LIFO)
        Stack<Character> stack = new Stack<>();

        // Push all characters into stack
        for (char ch : normalized.toCharArray()) {
            stack.push(ch);
        }

        // Step 3: Compare original with reversed (via stack)
        for (char ch : normalized.toCharArray()) {
            char fromStack = stack.pop();
            System.out.println("Comparing: " + ch + " vs " + fromStack);

            if (ch != fromStack) {
                return false;
            }
        }

        return true;
    }
}

// Main application class
public class UC11 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Input
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Create object of PalindromeChecker
        PalindromeChecker checker = new PalindromeChecker();

        // Call method
        boolean result = checker.checkPalindrome(input);

        // Output result
        if (result) {
            System.out.println("The string is a PALINDROME.");
        } else {
            System.out.println("The string is NOT a palindrome.");
        }

        scanner.close();
    }
}