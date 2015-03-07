package panshul.learning.datastructures.linkedlist;

public class LinkedList<T>
{
    private Node<T> head;

    public void insertAtHead(T data)
    {
        Node<T> newNode = new Node<T>(data, this.head);
        this.head = newNode;
    }

    public void deleteFromHead()
    {
        this.head = this.head.getNextNode();
    }

    public Node find(T data)
    {
        Node current = this.head;

        while (current != null)
        {
            if (current.getData() == data)
            {
                return current;
            }
            current = current.getNextNode();
        }
        return null;
    }

    public void sort()
    {
        //to sort the linked list. using the equals method, since the data type of Node is generic
    }

    /**
     * insert an element in the linked list, will work only if the linked list is sorted. This method is also supposed to keep the structure sorted.
     * supposed to compare the given node data with the next node data of current node.
     * when found the correct location, then make the next node of new node = next node of current node and make the next node of current node = new node.
     */
    public void insert()
    {

    }

    public int length()
    {
        int length = 0;
        Node current = this.head;

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
        Node current = this.head;
        while (current != null)
        {
            result += current.toString() + ",";
            current = current.getNextNode();
        }
        result += "}";
        return result;
    }
}
