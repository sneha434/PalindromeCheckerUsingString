import java.util.*;

public class UC12 {

    // Approach 1: Two-pointer (String)
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

        // Normalize input
        String normalized = input.toLowerCase().replaceAll("[^a-z0-9]", "");

        System.out.println("\n--- Performance Comparison ---");

        // 1. Two-pointer timing
        long startTime1 = System.nanoTime();
        boolean result1 = isPalindromeTwoPointer(normalized);
        long endTime1 = System.nanoTime();

        // 2. Stack timing
        long startTime2 = System.nanoTime();
        boolean result2 = isPalindromeStack(normalized);
        long endTime2 = System.nanoTime();

        // 3. Recursion timing
        long startTime3 = System.nanoTime();
        boolean result3 = isPalindromeRecursion(normalized, 0, normalized.length() - 1);
        long endTime3 = System.nanoTime();

        // Display results
        System.out.println("Two-Pointer Result: " + result1 +
                " | Time: " + (endTime1 - startTime1) + " ns");

        System.out.println("Stack Result: " + result2 +
                " | Time: " + (endTime2 - startTime2) + " ns");

        System.out.println("Recursion Result: " + result3 +
                " | Time: " + (endTime3 - startTime3) + " ns");

        scanner.close();
    }
}