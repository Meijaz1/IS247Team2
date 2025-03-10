import java.util.*;

public class ReverseListAndRemoveDuplicates {
    public static void main(String[] args) {
        // Step 1: Create a list with duplicate values
        List<String> list = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry", "Date", "Banana", "Apple"));

        System.out.println("Original List: " + list);

        // Step 2: Remove duplicates manually using iteration and contains() method
        List<String> uniqueList = new ArrayList<>();
        for (String item : list) {
            if (!uniqueList.contains(item)) {
                uniqueList.add(item);
            }
        }

        System.out.println("List after removing duplicates: " + uniqueList);

        // Step 3: Use a stack to reverse the list
        Stack<String> stack = new Stack<>();
        for (String item : uniqueList) {
            stack.push(item);
        }

        List<String> reversedList = new ArrayList<>();
        while (!stack.isEmpty()) {
            reversedList.add(stack.pop());
        }

        // Step 4: Display the final reversed list
        System.out.println("Reversed List: " + reversedList);
    }
}
