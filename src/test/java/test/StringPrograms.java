package test;

import org.testng.annotations.Test;
import java.util.*;
import java.util.stream.Collectors;

public class StringPrograms {

    @Test
    public static void RemoveDuplicateCharacterInGivenString() {
        String str = "rahulpatidar";
        char[] c = str.toCharArray();
        List<Character> list = new ArrayList<Character>();

        for (int i = 0; i < c.length; i++) {
            for (int j = i + 1; j < c.length; j++) { // checking in same array, so will start from next number
                if (c[i] != c[j]) {
                    if (!list.contains(c[i])) {
                        list.add(c[i]);
                    }
                }
            }
        }
        System.out.println(list);

        StringBuilder output = new StringBuilder();
        for (char ch : list) {
            output.append(ch);
        }
        System.out.println(output);
    }

    @Test
    public static void RemoveDuplicateCharacterInGivenString2ndWay() {
        String str = "rahulpatidar";
        char[] ch = str.toCharArray();

        Set<Character> set = new HashSet<>(); // set can not contain duplicates
        StringBuilder result = new StringBuilder();

        for (char c : ch) {
            if (!set.contains(c)) {
                set.add(c);
                result.append(c);
            }
        }
        System.out.println(result);
    }

    @Test
    public static void RemoveDuplicateWord() {
        String input = "Welcome to Java Session Java Session Session Java";
        String[] str = input.split(" ");

        Set<String> set = new HashSet<>();
        StringBuilder result = new StringBuilder();

        for (String word : str) {
            if (!set.contains(word)) {
                set.add(word);
                result.append(word).append(" ");
            }
        }
        System.out.println(result);
    }

    @Test
    public static void RemoveDuplicateWord2ndWay() {
        String input = "Welcome to Java Session Java Session Session Java";
        String[] words = input.split(" ");

        System.out.println(Arrays.asList(words));

        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
        System.out.println(uniqueWords);

        String output = String.join(" ", uniqueWords);
        System.out.println(output);
    }

    @Test
    public static void printDuplicateCaracter() {
        String input = "WelcometoJavaSession";
        char[] c = input.toCharArray();

        Set<Character> unique = new HashSet<>();
        Set<Character> duplicate = new HashSet<>();

        for (Character ch : c) {
            if (!unique.add(ch)) {
                duplicate.add(ch);
            }
        }
        System.out.println(duplicate);

//        String joinedString = String.join(" ", duplicate);
//        System.out.println(joinedString);
    }

    @Test
    public static void printDuplicateWord() {
        String input = "Welcome to Java Session Java Session Session Java";
        String[] str = input.split(" ");

        Set<String> unique = new HashSet<>();
        Set<String> duplicate = new HashSet<>();

        for (String word : str) {
            if (!unique.add(word)) {
                duplicate.add(word);
            }
        }
        System.out.println(duplicate);

        String joinedString = String.join(" ", duplicate);
        System.out.println(joinedString);
    }

    @Test
    public static void printWordCount() {
        String str = "rahul patidar rahul is my is";
        String[] ar = str.split(" ");

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < ar.length; i++) {
            int count = 0;
            for (int j = 0; j < ar.length; j++) {
                if (ar[i].equals(ar[j])) {
                    count++;
                }
                map.put(ar[i], count);
            }
        }
        System.out.println(map);
    }

    @Test
    public static void printCharacterCount() {
        String str = "rahulpatidar";
        char[] ar = str.toCharArray();

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < ar.length; i++) {
            int count = 0;
            for (int j = 0; j < ar.length; j++) {
                if (ar[i] == ar[j]) {
                    count++;
                }
                map.put(ar[i], count);
            }
        }
        System.out.println(map);
    }

    @Test
    public static void ConvertFirstCharacterToUpperCase() {
        String input = "hello how are you";
        String[] words = input.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(word.substring(0, 1).toUpperCase()).append(word.substring(1)).append(" ");
        }
        System.out.println(result);
    }

    @Test
    public static void reverseAllWordOfString1() {
        String str = "hello how are you"; // you are how hello
        String[] words = str.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]).append(" ");
        }
        System.out.println(result);
    }

    @Test
    public static void reversString() {
        //Input: hello how are you
        //Output: uoy era woh olleh

        String input = "hello how are you";
        String output = "";

        for (int i = input.length() - 1; i >= 0; i--) {
            output = output + input.charAt(i);
        }

        System.out.println("Input: " + input);
        System.out.println("Output: " + output);
    }

    @Test
    public static void reverseAllWordOfString2() {
        //Input: hello how are you
        //Output: olleh woh era uoy

        String input = "hello how are you";
        String[] words = input.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            result.append(new StringBuilder(word).reverse() + " ");
        }
        System.out.println("Output: " + result);
    }

    @Test
    public static void insertAnyWordInString() {
        String input = "my name is Rahul";
        String wordToInsert = "123";
        int index = input.indexOf("Rahul");
        StringBuilder result = new StringBuilder(input);
        result.insert(index, wordToInsert + " ");
        System.out.println(result);
    }

    @Test
    public static void PallindromString() {
        String str = "rar";
        String rev = new StringBuffer(str).reverse().toString();

        if (str.equalsIgnoreCase(rev)) {
            System.out.println("string is pallindrom");
        } else
            System.out.println("not pallindrom");
    }

    @Test
    public static void PallindromString2ndWay() {

        String str = "rar";
        String rev = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            rev = rev + str.charAt(i);
        }

        if (str.equals(rev))
            System.out.println(str + " is a palindrome");
        else
            System.out.println(str + " is not a palindrome");

    }

    @Test
    public static void reverseString() {
        String str = "Rahul Patidar";
        String reverse = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverse = reverse + str.charAt(i);
        }
        System.out.println(reverse);

        StringBuffer sf = new StringBuffer(str);
        System.out.println(sf.reverse());

        StringBuilder sb = new StringBuilder(str);
        System.out.println(sb.reverse());
    }

    @Test
    public static void appendAllCharacterWIthDelimeter() {
        String[] s = {"a", "c", "f"};
        String s1 = String.join("|", s);
        System.out.println(s1);

        String s2 = Arrays.asList(s).stream().collect(Collectors.joining("@"));
        System.out.println(s2);

        int[] a = {2, 4, 5, 6};
        String a1 = Arrays.asList(2, 4, 5, 6).stream().map(e -> String.valueOf(e))
                .collect(Collectors.joining(""));
        System.out.println(a1);
    }

    @Test
    public static void sumOfNumbersInGivenString() {
        String str = "my name 21 is 35 rahul";
        int sum = 0;
        String[] words = str.split(" ");
        for (String word : words) {
            try {
                int num = Integer.parseInt(word);
                sum = sum + num;
            } catch (NumberFormatException e) {
//                System.out.println("not a number");
            }
        }
        System.out.println("Sum of numbers in string: " + sum);
    }

    @Test
    public static void FirstNonRepeatedCharacterinString() {
        String s = "aabbbcdddd";
        char[] ch = s.toCharArray();
        for (char c : ch) {
            if (s.indexOf(c) == s.lastIndexOf(c)) {
                System.out.println("First non-repeat char = " + c);
                break;
            }
        }
    }

    @Test
    public static void AnagramChecker() {
        String str1 = "listen";
        String str2 = "silent1";
        str1 = str1.toLowerCase().replaceAll("\\s", "");
        str2 = str2.toLowerCase().replaceAll("\\s", "");
        if (str1.length() != str2.length()) {
            System.out.println("Not an anagram");
        } else {
            char[] charArray1 = str1.toCharArray();
            char[] charArray2 = str2.toCharArray();
            Arrays.sort(charArray1);
            Arrays.sort(charArray2);
            if (Arrays.equals(charArray1, charArray2)) {
                System.out.println("An anagram");
            } else {
                System.out.println("Not an anagram");
            }
        }
    }

}
