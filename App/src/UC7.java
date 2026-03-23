import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class UC7 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Input string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Convert to lowercase for uniform comparison
        input = input.toLowerCase();

        // Create Deque
        Deque<Character> deque = new ArrayDeque<>();

        // Insert characters into deque
        for (char ch : input.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) { // Ignore spaces/special chars
                deque.addLast(ch); // Insert at rear
            }
        }

        // Compare front and rear elements
        boolean isPalindrome = true;

        while (deque.size() > 1) {
            char front = deque.removeFirst(); // Remove from front
            char rear = deque.removeLast();   // Remove from rear

            System.out.println("Front: " + front + " | Rear: " + rear);

            if (front != rear) {
                isPalindrome = false;
                break;
            }
        }

        // Result
        if (isPalindrome) {
            System.out.println("The string is a PALINDROME.");
        } else {
            System.out.println("The string is NOT a palindrome.");
        }

        scanner.close();
    }
}