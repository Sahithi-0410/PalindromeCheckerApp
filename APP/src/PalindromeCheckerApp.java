import java.util.Scanner;
public class PalindromeCheckerApp {
    // Method to check palindrome ignoring spaces and case
    public static boolean isPalindrome(String input) {

// Step 1: Normalize the string
// Remove all spaces using regular expression
        String normalized = input.replaceAll("\\s+", "");

// Convert to lowercase for case-insensitive comparison
        normalized = normalized.toLowerCase();

// Step 2: Convert string to char array (Data Structure usage)
        char[] charArray = normalized.toCharArray();

// Step 3: Apply palindrome logic
        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== UC10: Case-Insensitive & Space-Ignored Palindrome Checker =====");
        System.out.print("Enter a string: ");

        String input = scanner.nextLine();

        boolean result = isPalindrome(input);

        if (result) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }

        }