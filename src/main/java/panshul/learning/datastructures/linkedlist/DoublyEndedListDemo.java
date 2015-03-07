package panshul.learning.datastructures.linkedlist;

public class DoublyEndedListDemo
{
    public static void main(String[] args)
    {
        DoublyEndedList<Integer> dList = new DoublyEndedList<Integer>();

        dList.insertAtTail(19);
        dList.insertAtTail(18);
        dList.insertAtTail(17);

        System.out.println(dList);
    }
}
