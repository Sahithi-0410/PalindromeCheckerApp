import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class PalindromeCheckerApp {

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            Stack<Character> stack = new Stack<>();
            Queue<Character> queue = new LinkedList<>();

            System.out.println("=== Queue + Stack Based Palindrome Checker ===");
            System.out.print("Enter a string: ");
            String input = scanner.nextLine();

            // Process input (remove spaces and convert to lowercase)
            String processedInput = input.replaceAll("\\s+", "").toLowerCase();

            // Enqueue and Push characters
            for (int i = 0; i < processedInput.length(); i++) {
                char ch = processedInput.charAt(i);
                queue.add(ch);   // Enqueue (FIFO)
                stack.push(ch);  // Push (LIFO)
            }

            boolean isPalindrome = true;

            // Compare dequeue from queue and pop from stack
            while (!queue.isEmpty()) {
                char fromQueue = queue.remove();  // Dequeue
                char fromStack = stack.pop();     // Pop

                if (fromQueue != fromStack) {
                    isPalindrome = false;
                    break;
                }
            }

            // Display result
            if (isPalindrome) {
                System.out.println("Result: The given string is a Palindrome.");
            } else {
                System.out.println("Result: The given string is NOT a Palindrome.");
            }

            scanner.close();
        }



}