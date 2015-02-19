package panshul.learning.algorithms.sorting;

public class SelectionSort
{
    public static void main(String[] args)
    {
        int[] target = {10, 2, 8, 6, 7, 3};
        int[] sorted = sort(target);
        for (int i : sorted)
        {
            System.out.println(i);
        }
    }

    private static int[] sort(int[] target)
    {
        int swap;
        int minIndex;
        for (int i = 0; i < target.length - 2; i++)
        {
            minIndex = i;
            for (int j = i + 1; j < target.length; j++)
            {
                if (target[minIndex] > target[j])
                {
                    minIndex = j;
                }
            }
            swap = target[i];
            target[i] = target[minIndex];
            target[minIndex] = swap;
        }
        return target;
    }
}
