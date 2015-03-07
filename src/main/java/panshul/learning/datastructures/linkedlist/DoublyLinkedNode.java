package panshul.learning.datastructures.linkedlist;

public class DoublyLinkedNode<T>
{
    private T                   data;
    private DoublyLinkedNode<T> nextNode;
    private DoublyLinkedNode<T> previousNode;

    public DoublyLinkedNode(T data)
    {
        this.data = data;
    }

    public T getData()
    {
        return data;
    }

    public void setData(T data)
    {
        this.data = data;
    }

    public DoublyLinkedNode<T> getNextNode()
    {
        return nextNode;
    }

    public void setNextNode(DoublyLinkedNode<T> nextNode)
    {
        this.nextNode = nextNode;
    }

    public DoublyLinkedNode<T> getPreviousNode()
    {
        return previousNode;
    }

    public void setPreviousNode(DoublyLinkedNode<T> previousNode)
    {
        this.previousNode = previousNode;
    }
}
