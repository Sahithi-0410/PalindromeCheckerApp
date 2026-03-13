import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {


    public static boolean reverseMethod(String text) {
        String reversed = new StringBuilder(text).reverse().toString();
        return text.equals(reversed);
    }


    public static boolean twoPointerMethod(String text) {
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    public static boolean stackMethod(String text) {
        Stack<Character> stack = new Stack<>();

        for (char c : text.toCharArray()) {
            stack.push(c);
        }

        for (char c : text.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String input = sc.nextLine();


        long start1 = System.nanoTime();
        boolean r1 = reverseMethod(input);
        long end1 = System.nanoTime();


        long start2 = System.nanoTime();
        boolean r2 = twoPointerMethod(input);
        long end2 = System.nanoTime();


        long start3 = System.nanoTime();
        boolean r3 = stackMethod(input);
        long end3 = System.nanoTime();

        System.out.println("\nPerformance Comparison");
        System.out.println("Reverse Method Result: " + r1 + " Time: " + (end1 - start1) + " ns");
        System.out.println("Two Pointer Result: " + r2 + " Time: " + (end2 - start2) + " ns");
        System.out.println("Stack Method Result: " + r3 + " Time: " + (end3 - start3) + " ns");

        sc.close();
    }
}