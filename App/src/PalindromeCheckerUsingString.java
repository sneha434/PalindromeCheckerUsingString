public class PalindromeCheckerUsingString {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter a string to check: ");
            String original = scanner.nextLine();

            // Step 1: Reverse the string using a loop
            String reversed = "";

            // We start from the last index and move to 0
            for (int i = original.length() - 1; i >= 0; i--) {
                // String concatenation (+) creates a new String object in each iteration
                reversed = reversed + original.charAt(i);
            }

            // Step 2 & 3: Compare and Display Result
            System.out.println("Original: " + original);
            System.out.println("Reversed: " + reversed);

            // We use .equals() to compare content, not == which compares memory addresses
            if (original.equalsIgnoreCase(reversed)) {
                System.out.println("Result: The string is a Palindrome.");
            } else {
                System.out.println("Result: The string is NOT a Palindrome.");
            }

            scanner.close();
        }
    }
