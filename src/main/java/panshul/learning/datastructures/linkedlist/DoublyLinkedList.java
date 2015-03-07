package panshul.learning.datastructures.linkedlist;

public class DoublyLinkedList<T>
{
    private DoublyLinkedNode<T> head;

    public void insertAtHead(T data)
    {
        DoublyLinkedNode<T> newNode = new DoublyLinkedNode<T>(data);
        newNode.setNextNode(this.head);
        if (this.head != null)
        {
            this.head.setPreviousNode(newNode);
        }
        this.head = newNode;
    }

    public int length()
    {
        if (this.head == null)
        {
            return 0;
        }
        int length = 0;
        DoublyLinkedNode current = this.head;

        while (current != null)
        {
            length++;
            current = current.getNextNode();
        }
        return length;
    }

    public String toString()
    {
        String result = "{";
        DoublyLinkedNode current = this.head;

        while (current != null)
        {
            result += current.getData() + ",";
            current = current.getNextNode();
        }
        result += "}";
        return result;
    }
}
