import java.util.*;

public class RomanToInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a Roman numeral: ");
        String roman = scanner.nextLine();
        int result = romanToInt(roman);
        System.out.println("The integer representation of " + roman + " is " + result);
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        int i = 0;
        while (i < s.length()) {
            char c1 = s.charAt(i);
            int value1 = map.get(c1);
            if (i + 1 < s.length()) {
                char c2 = s.charAt(i + 1);
                int value2 = map.get(c2);
                if (value1 < value2) {
                    result += value2 - value1;
                    i += 2;
                    continue;
                }
            }
            result += value1;
            i++;
        }
        return result;
    }
}
