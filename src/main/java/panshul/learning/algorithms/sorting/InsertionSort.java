package panshul.learning.algorithms.sorting;

public class InsertionSort
{
    public static void main(String[] args)
    {
        int[] target = {5, 2, 8, 12, 7};
        int[] sorted = sort(target);
        for (int i : sorted)
        {
            System.out.println(i);
        }
    }

    private static int[] sort(int[] target)
    {
        for (int i = 0; i < target.length; i++)
        {
            int current = target[i];
            int j = i - 1;
            while (j >= 0 && target[j] > current)
            {
                target[j + 1] = target[j];
                j -= 1;
            }
            target[j + 1] = current;
        }
        return target;
    }
}
