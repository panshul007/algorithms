package panshul.learning.algorithms.searching.exercise;

/**
 * Write an algorithm which checks if there are duplicate characters in a string.
 * The method signature would look something like public boolean hasDuplicateChars(String s) .
 * If we pass "anaconda" the method should return true (repeated char 'a').
 * If we pass 'great', the method should return false, because there are no duplicate characters in the string.
 * What is the time complexity of this algorithm? If we know that the string contains ONLY ASCII characters, can we improve the algorithm?
 */

public class Duplicates
{
    public static void main(String[] args)
    {
        String target = "great";
        boolean result = hasDuplicate(target);
        if (result)
        {
            System.out.println("found duplicate");
        }
        else
        {
            System.out.println("Not found any duplicate");
        }
    }

    private static boolean hasDuplicate(String target)
    {
        char[] chars = target.toCharArray();
        for (int i = 0; i < chars.length - 1; i++)
        {
            for (int j = i + 1; j < chars.length; j++)
            {
                if (chars[i] == chars[j])
                {
                    return true;
                }
            }
        }
        return false;
    }
}
