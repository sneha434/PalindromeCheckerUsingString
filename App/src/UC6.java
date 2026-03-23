
    import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;

public class UC6 {

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            // Input string
            System.out.print("Enter a string: ");
            String input = scanner.nextLine();

            // Convert to lowercase for uniform comparison
            input = input.toLowerCase();

            // Create Queue (FIFO) and Stack (LIFO)
            Queue<Character> queue = new LinkedList<>();
            Stack<Character> stack = new Stack<>();

            // Enqueue and Push characters
            for (char ch : input.toCharArray()) {
                if (Character.isLetterOrDigit(ch)) { // Ignore spaces/special chars
                    queue.add(ch);   // Enqueue
                    stack.push(ch);  // Push
                }
            }

            // Compare dequeue (FIFO) vs pop (LIFO)
            boolean isPalindrome = true;

            while (!queue.isEmpty() && !stack.isEmpty()) {
                char fromQueue = queue.remove(); // Dequeue
                char fromStack = stack.pop();    // Pop

                System.out.println("Queue (dequeue): " + fromQueue +
                        " | Stack (pop): " + fromStack);

                if (fromQueue != fromStack) {
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

