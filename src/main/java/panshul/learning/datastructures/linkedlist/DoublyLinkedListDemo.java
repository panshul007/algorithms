package panshul.learning.datastructures.linkedlist;

public class DoublyLinkedListDemo
{
    public static void main(String[] args)
    {
        DoublyLinkedList<Integer> integers = new DoublyLinkedList<Integer>();

        integers.insertAtHead(10);
        integers.insertAtHead(12);
        integers.insertAtHead(16);
        integers.insertAtHead(17);
        integers.insertAtHead(8);
        integers.insertAtHead(20);

        System.out.println(integers);
    }
}
