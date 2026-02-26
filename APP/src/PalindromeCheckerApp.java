import java.util.Scanner;
public class PalindromeCheckerApp {
    // Node class for Singly Linked List
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    // Method to create linked list from string
    public static Node createLinkedList(String str) {
        Node head = null;
        Node tail = null;

        for (char ch : str.toCharArray()) {
            Node newNode = new Node(ch);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        return head;
    }

    // Method to reverse linked list
    public static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    // Method to check palindrome
    public static boolean isPalindrome(Node head) {

        if (head == null || head.next == null) {
            return true;
        }

        Node slow = head;
        Node fast = head;

        // Find middle using fast & slow pointers
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        Node secondHalf = reverse(slow);
        Node copySecondHalf = secondHalf;

        Node firstHalf = head;
        boolean palindrome = true;

        // Compare both halves
        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                palindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        // Optional: Restore original list
        reverse(copySecondHalf);

        return palindrome;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== UC8: Linked List Based Palindrome Checker ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Convert to lowercase (optional normalization)
        input = input.replaceAll("\\s+", "").toLowerCase();

        Node head = createLinkedList(input);

        if (isPalindrome(head)) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }



}