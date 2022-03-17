public interface Queue <E>{

    public E pop() throws EmptyQueueException;
    public void push(E e) throws FullQueueException;
    public int size();



}
