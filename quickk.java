package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class quickk {
    public static List<Integer> quickSort(List<Integer> arr) {
        int n = arr.size();
        int pivot = arr.get(0);
        List<Integer> less = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        
        // Partition the array into less, equal, and greater
        for (int i = 1; i < n; i++) {
            int num = arr.get(i);
            if (num < pivot) {
                less.add(num);
            } else if (num > pivot) {
                greater.add(num);
            } else {
                equal.add(num);
            }
        }
        
        // Concatenate all three parts into a single list
        List<Integer> result = new ArrayList<>();
        result.addAll(less);
        result.addAll(equal);
        result.add(pivot); // Add pivot element
        result.addAll(greater);
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Read size of array
        List<Integer> arr = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) { // Read the pivot and array elements
            arr.add(scanner.nextInt());
        }
        
        List<Integer> sorted = quickSort(arr);
        for (int num : sorted) {
            System.out.print(num + " ");
        }
        
        scanner.close();
    }
}
