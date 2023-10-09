import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Task 1: Create an array with values (1, 2, 3, 4, 5, 6, 7) and shuffle it.
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        shuffleArray(arr);
        System.out.println("Shuffled Array: " + Arrays.toString(arr));

        // Task 2: Enter a Roman Number as input and convert it to an integer.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a Roman Number: ");
        String romanNumeral = scanner.nextLine();
        int integerEquivalent = romanToInteger(romanNumeral);
        System.out.println("Integer Equivalent: " + integerEquivalent);

        // Task 3: Check if the input is a pangram or not.
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine().toLowerCase();
        boolean isPangram = isPangram(sentence);
        if (isPangram) {
            System.out.println("The sentence is a pangram.");
        } else {
            System.out.println("The sentence is not a pangram.");
        }
    }

    // Helper method to shuffle an array
    private static void shuffleArray(int[] arr) {
        Random rand = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    // Helper method to convert a Roman numeral to an integer
    private static int romanToInteger(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int currentValue = romanMap.get(s.charAt(i));
            if (currentValue < prevValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
            prevValue = currentValue;
        }

        return result;
    }

    // Helper method to check if a sentence is a pangram
    private static boolean isPangram(String sentence) {
        boolean[] isAlphabetPresent = new boolean[26];
        int totalAlphabets = 0;

        for (char c : sentence.toCharArray()) {
            if (Character.isLetter(c)) {
                int index = c - 'a';
                if (!isAlphabetPresent[index]) {
                    isAlphabetPresent[index] = true;
                    totalAlphabets++;
                }
            }
        }

        return totalAlphabets == 26;
    }
}
