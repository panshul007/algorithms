package panshul.learning.concepts;

/**
 * Reverse a string using recursion
 */
public class Recursion
{
    public static void main(String[] args)
    {
        System.out.println(reverse("zalando"));
    }

    private static String reverse(String s)
    {
        if (s.length() == 1)
        {
            return s;
        }
        return reverse(s.substring(1, s.length())) + s.charAt(0);
    }
}
