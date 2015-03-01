package panshul.learning.algorithms.searching;

public class BinarySearch
{
    public static void main(String[] args)
    {
        int[] target = {3, 7, 20, 32, 45, 55, 60, 75};
        int searchElement = 75;
        int index = search(target, searchElement);
        if (index != -1)
        {
            System.out.println(searchElement + " found at index: " + index);
        }
        else
        {
            System.out.println("Element not found");
        }
    }

    private static int search(int[] target, int se)
    {
        int maxIndex = target.length - 1;
        int minIndex = 0;

        int midIndex = calculateMidIndex(maxIndex, minIndex);
        while (target[midIndex] != se)
        {
            System.out.println(midIndex);
            if (target[midIndex] < se)
            {
                minIndex = midIndex + 1;
            }
            else
            {
                maxIndex = midIndex;
            }
            if (minIndex > maxIndex)
            {
                return -1;
            }
            midIndex = calculateMidIndex(maxIndex, minIndex);
        }
        return midIndex;
    }

    private static int calculateMidIndex(int maxIndex, int minIndex)
    {
        return Math.floorDiv((maxIndex + minIndex), 2);
    }
}
