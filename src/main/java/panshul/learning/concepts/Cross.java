package panshul.learning.concepts;

/**
 * Print a cross of given width
 */
public class Cross
{
    public static void main(String[] args)
    {
        System.out.println(cross(9));
    }

    static String blanks(int size)
    {
        String s = ""; // Stringbuilder or another string function would be better...
        for (int i = 0; i < size; i++)
        {
            s += " ";
        }
        return s;
    }

    private static String cross(int size)
    {
        String result = "";

        for (int i = 0; i <= size / 2; i++)
        {
            int span = size - i - 2; // 7 the first itr.

            int leftBlanks = size - span - 2; // 9-7-2 = 0
            int midBlanks = span - i; // 7

            //result += i + " " + midBlanks;

            if (midBlanks <= 0)
            {
                result += blanks(leftBlanks) + "*" + "\n";
            }
            else
            {
                result += blanks(leftBlanks) + "*" + blanks(midBlanks) + "*" + "\n";
            }
        }
        for (int i = (size / 2) - 1; i >= 0; i--)
        { // start with -1 because we don't like to print the middle twice
            int span = size - i - 2;

            int leftBlanks = size - span - 2; // 9-7-2 = 0
            int midBlanks = span - i; // 7

            result += blanks(leftBlanks) + "*" + blanks(midBlanks) + "*" + "\n";
        }

        return result;
    }
}
