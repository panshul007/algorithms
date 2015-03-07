package panshul.learning.datastructures.linkedlist;

public class DoublyEndedList<T>
{
    private Node<T> head;
    private Node<T> tail;

    public void insertAtTail(T data)
    {
        Node<T> newNode = new Node<T>(data);

        if (this.head == null)
        {
            this.head = newNode;
            this.tail = newNode;
        }
        if (this.tail != null)
        {
            this.tail.setNextNode(newNode);
            this.tail = newNode;
        }
    }

    public String toString()
    {
        String result = "{";
        Node<T> current = this.head;

        while (current != null)
        {
            result += current.toString() + ",";
            current = current.getNextNode();
        }
        result += "}";
        return result;
    }
}
