package panshul.learning.algorithms.sorting;

public class BubbleSort
{
    public static void main(String[] args)
    {
        int[] target = {12, 8, 7, 5, 2};

        int[] sorted = sort(target);
        for (int i : sorted)
        {
            System.out.println(i);
        }
    }

    private static int[] sort(int[] target)
    {
        for (int i = 0; i < target.length - 1; i++)
        {
            for (int j = 0; j < target.length - 1 - i; j++)
            {
                if (target[j] > target[j + 1])
                {
                    swap(target, j);
                }
            }
        }
        return target;
    }

    private static void swap(int[] target, int j)
    {
        int swap;
        swap = target[j];
        target[j] = target[j + 1];
        target[j + 1] = swap;
    }
}
