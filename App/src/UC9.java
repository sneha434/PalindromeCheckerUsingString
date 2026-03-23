import java.util.Scanner;

public class UC9 {

    // Recursive function to check palindrome
    public static boolean isPalindrome(String str, int start, int end) {

        // Base condition: if pointers cross or meet
        if (start >= end) {
            return true;
        }

        // Compare characters at start and end
        System.out.println("Comparing: " + str.charAt(start) + " vs " + str.charAt(end));

        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call for inner substring
        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Input string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine().toLowerCase();

        // Remove non-alphanumeric characters
        input = input.replaceAll("[^a-z0-9]", "");

        // Call recursive function
        boolean result = isPalindrome(input, 0, input.length() - 1);

        // Output result
        if (result) {
            System.out.println("The string is a PALINDROME.");
        } else {
            System.out.println(" The string is NOT a palindrome.");
        }

        scanner.close();
    }
}
