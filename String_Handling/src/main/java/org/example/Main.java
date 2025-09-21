package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter a string: ");
        String text = sc.nextLine();

        System.out.println("The number of Vowels of " + text + " is: " + countVowels(text));
        System.out.println("The number of Consonants of " + text + " is: " + countConsonants(text));

        String charToReplace;
        String replacementChar;
        System.out.print("Please enter a character to replace: ");
        charToReplace = sc.next();
        System.out.print("Please enter the replacement character: ");
        replacementChar = sc.next();

        String result = replaceAllCharacter(text, charToReplace, replacementChar);
        System.out.println("The result after replacement is: " + result);

        System.out.println("Is the text a palindrome? " + isPalindrome(text));
        sc.close();
    }

    public static int countVowels(String text) {
        return text.replaceAll("[^aeiouAEIOU]", "").length();
    }

    public static int countConsonants (String text) {
        return text.replaceAll("[^a-zA-Z]", "").replaceAll("[aeiouAEIOU]", "").length();
    }

    public static String replaceAllCharacter(String text, String charToReplace, String replacementChar) {
        return text.replaceAll(charToReplace, replacementChar);
    }

    public static boolean  isPalindrome(String text) {
        String cleanedText = text.replaceAll("[^a-zA-Z]", "").toLowerCase();
        String reversedText = new StringBuilder(cleanedText).reverse().toString();
        return cleanedText.equals(reversedText);
    }
}