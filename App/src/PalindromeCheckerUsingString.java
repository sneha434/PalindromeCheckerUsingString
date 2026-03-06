import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerUsingString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String originalInput = scanner.nextLine();

        // CLEANUP: Remove spaces and punctuation, convert to lowercase
        // This makes "Race Car" work as a palindrome
        String cleanInput = originalInput.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        Stack<Character> stack = new Stack<>();

        // Step 1: Push characters onto the stack
        for (int i = 0; i < cleanInput.length(); i++) {
            stack.push(cleanInput.charAt(i));
        }

        // Step 2: Pop characters to reverse
        StringBuilder reversedString = new StringBuilder();
        while (!stack.isEmpty()) {
            reversedString.append(stack.pop());
        }

        String reversed = reversedString.toString();

        System.out.println("Original (Cleaned): " + cleanInput);
        System.out.println("Reversed via Stack: " + reversed);

        if (cleanInput.equals(reversed)) {
            System.out.println("Result: Success! It is a palindrome.");
        } else {
            System.out.println("Result: Failure. It is not a palindrome.");
        }

        scanner.close();
    }
}