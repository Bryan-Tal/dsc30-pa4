/*
 * NAME: Bryan Talavera
 * PID: A14378593
 */

/**
 * This is a Queue Implementation which utilizes a Doubly Linked List
 * @param <T> generic container
 * @author Bryan Talavera
 * @since 04/25/21
 */
public class DLLQueue<T> {

    private DoublyLinkedList<T> queue;

    public DLLQueue() {
        this.queue = new DoublyLinkedList<>();
    }

    /**
     * This method returns the size of the stack
     * @return number of elements currently stored
     */
    public int size() {
        return this.queue.size();
    }

    /**
     * Method checks if our stack is empty
     * @return True if our stack is empty, else it returns false
     */
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * Adding our data to the back of the queue
     * @param data - the data we will add to the queue
     * @throws IllegalArgumentException - if data is null
     */
    public void enqueue(T data) {
        try{
            if (data == null) throw new IllegalArgumentException();
            this.queue.add(data);
        }catch (IllegalArgumentException err){
            throw err;
        }
    }

    /**
     * This Method removes the top elem from the queue and returns it.
     * @return the first T value if there are elements, otherwise null
     */
    public T dequeue() {
        if (this.isEmpty()) return null;
        return this.queue.remove(0);
    }

    /**
     * "Peek" at the top element of the queue w/o returning it
     * @return - the first element of our queue
     */
    public T peek() {
        if (this.isEmpty()) return null;
        return this.queue.get(0);
    }

}
