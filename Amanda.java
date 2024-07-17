package hackerrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Amanda {
    static int stringConstruction(String s) {
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : s.toCharArray()) {
            uniqueChars.add(c);
        }
        return uniqueChars.size(); // Number of unique characters is the minimum cost
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Read number of strings
        scanner.nextLine(); // Consume newline
        
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine(); // Read each string
            int cost = stringConstruction(s);
            System.out.println(cost);
        }
        
        scanner.close();
    }
}
