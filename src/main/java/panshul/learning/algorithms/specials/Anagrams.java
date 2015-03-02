package panshul.learning.algorithms.specials;

import java.util.Arrays;

/**
 * Write an algorithm that takes two strings and returns a boolean value indicating if the strings are anagrams.
 * If you don't know what an anagram is, search for the word (not the algorithm) online.
 * What is the time complexity of this algorithm?
 */

public class Anagrams
{
    public static void main(String[] args)
    {
        String string1 = "Anagram";
        String string2 = "A Rang Ma";
        boolean result = isAnagram(string1, string2);
        if (result)
        {
            System.out.println("is an Anagram");
        }
        else
        {
            System.out.println("is NOT an Anagram");
        }
    }

    private static boolean isAnagram(String string1, String string2)
    {
        string1 = string1.replace(" ", "");
        string2 = string2.replace(" ", "");
        char[] chars1 = string1.toLowerCase().toCharArray();
        char[] chars2 = string2.toLowerCase().toCharArray();
        chars1 = sort(chars1);
        chars2 = sort(chars2);
        System.out.println(chars1);
        System.out.println(chars2);
        return Arrays.equals(chars1, chars2);
    }

    //Implementing insertion sort
    private static char[] sort(char[] chars)
    {
        for (int i = 0; i < chars.length; i++)
        {
            char current = chars[i];
            int j = i - 1;
            while (j >= 0 && chars[j] > current)
            {
                chars[j + 1] = chars[j];
                j -= 1;
            }
            chars[j + 1] = current;
        }
        return chars;
    }

}
