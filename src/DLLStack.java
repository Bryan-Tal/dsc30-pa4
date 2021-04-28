/*
 * NAME: Bryan Talavera
 * PID: A14378593
 */

/**
 * This is a Stack Implementation which utilizes a Doubly Linked List
 * @param <T> generic container
 * @author Bryan Talavera
 * @since 04/25/21
 */
public class DLLStack<T> {

    private DoublyLinkedList<T> stack;

    public DLLStack() {
        this.stack = new DoublyLinkedList<>();
    }

    /**
     * This method returns the size of the stack
     * @return number of elements currently stored
     */
    public int size() {
        int size = this.stack.size();
        return size;
    }

    /**
     * Method checks if our stack is empty
     * @return True if our stack is empty, else it returns false
     */
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * This method pushes data to our stack
     * @param data - the T value we are adding to our stack
     * @throws IllegalArgumentException if data is null
     */
    public void push(T data) {
        try{
            if (data == null){
                throw new IllegalArgumentException();
            }else{
                this.stack.add(0,data);
            }
        }catch (IllegalArgumentException err){
            throw err;
        }
    }

    /**
     * This method removes the top (0th) element of the stack and returns it
     * @return - The element we popped, null if no elements exist
     */
    public T pop() {
        if (this.isEmpty()) return null;
        return this.stack.remove(0);
    }

    /**
     * "Peeks" at the top item in our stack, without removing it
     * @return the top
     */
    public T peek() {
        if (this.stack.get(0) != null) return this.stack.get(0);
        else return null;
    }

}
