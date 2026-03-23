import java.util.*;

public class UC13 {

    // Normalize string (common for all methods)
    public static String normalize(String input) {
        return input.toLowerCase().replaceAll("[^a-z0-9]", "");
    }

    // Approach 1: Two-Pointer
    public static boolean isPalindromeTwoPointer(String str) {
        int start = 0, end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Approach 2: Stack
    public static boolean isPalindromeStack(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : str.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    // Approach 3: Recursion
    public static boolean isPalindromeRecursion(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return isPalindromeRecursion(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Input
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String normalized = normalize(input);

        System.out.println("\n--- Performance Comparison ---");

        // Two-Pointer
        long start1 = System.nanoTime();
        boolean res1 = isPalindromeTwoPointer(normalized);
        long end1 = System.nanoTime();

        // Stack
        long start2 = System.nanoTime();
        boolean res2 = isPalindromeStack(normalized);
        long end2 = System.nanoTime();

        // Recursion
        long start3 = System.nanoTime();
        boolean res3 = isPalindromeRecursion(normalized, 0, normalized.length() - 1);
        long end3 = System.nanoTime();

        // Display Results
        System.out.println("Two-Pointer  -> Result: " + res1 +
                " | Time: " + (end1 - start1) + " ns");

        System.out.println("Stack        -> Result: " + res2 +
                " | Time: " + (end2 - start2) + " ns");

        System.out.println("Recursion    -> Result: " + res3 +
                " | Time: " + (end3 - start3) + " ns");

        scanner.close();
    }
}