/*
 * NAME: Bryan Talavera
 * PID: A14378593
 */

import java.util.AbstractList;

/**
 * An Implementation of a Doubly Linked List
 * @author Bryan Talavera
 * @since 04-24-21
 */
public class DoublyLinkedList<T> extends AbstractList<T> {

    /* DLL instance variables */
    private int nelems;
    private Node head;
    private Node tail;

    /**
     * Node for chaining together to create a linked list
     */
    protected class Node {

        /* Node instance variables */
        T data;
        Node next;
        Node prev;

        /**
         * Constructor to create singleton Node
         */
        private Node(T element) {
            this.data = element;
        }

        /**
         * Constructor to create singleton link it between previous and next
         *
         * @param element  Element to add, can be null
         * @param nextNode successor Node, can be null
         * @param prevNode predecessor Node, can be null
         */
        private Node(T element, Node nextNode, Node prevNode) {
            this.data = element;
            this.next = nextNode;
            this.prev = prevNode;
        }

        /**
         * Set the element
         *
         * @param element new element
         */
        public void setElement(T element) {
            this.data = element;
        }

        /**
         * Accessor to get the Nodes Element
         */
        public T getElement() {
            return this.data;
        }

        /**
         * Set the next node in the list
         *
         * @param n new next node
         */
        public void setNext(Node n) {
            this.next = n;
        }

        /**
         * Get the next node in the list
         *
         * @return the successor node
         */
        public Node getNext() {
            return this.next;
        }

        /**
         * Set the previous node in the list
         *
         * @param p new previous node
         */
        public void setPrev(Node p) {
            this.prev = p;
        }


        /**
         * Accessor to get the prev Node in the list
         *
         * @return predecessor node
         */
        public Node getPrev() {
            return this.prev;
        }

        /**
         * Remove this node from the list.
         * Update previous and next nodes
         */
        public void remove() {
            this.next.prev = this.prev;
            this.prev.next = this.next;
        }
    }

    /**
     * Creates a new, empty doubly-linked list.
     */
    public DoublyLinkedList() {
        this.head = new Node(null,null,null);
        this.tail = new Node(null,null,this.head);
        this.head.setNext(this.tail);
    }

    /**
     * Add an element to the end of the list
     *
     * @param element data to be added
     * @return whether or not the element was added
     * @throws NullPointerException if data received is null
     */
    @Override
    public boolean add(T element) throws NullPointerException {
        try {
            if (element == null) throw new NullPointerException();
            Node nodeToAdd = new Node(element);
            // identify if our DLL is empty,
            // so we can set the new node accordingly
            if (isEmpty()){
                this.head.setNext(nodeToAdd);
                this.tail.setPrev(nodeToAdd);
                // pointing the nodeToAdd's next and prev
                nodeToAdd.setNext(this.tail);
                nodeToAdd.setPrev(this.head);
                // moving the head and tail pointers
                this.nelems += 1;
                return true;
            }
            nodeToAdd.setPrev(this.tail.getPrev());
            this.tail.getPrev().setNext(nodeToAdd);
            this.tail.setPrev(nodeToAdd);
            nodeToAdd.setNext(this.tail);
            this.nelems += 1;

            return true;
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * Adds an element to a certain index in the list, shifting exist elements
     * create room. Does not accept null values.
     *
     * @param index - the index of the list we want to add
     * @param element - the element we want to add into our list
     */
    @Override
    public void add(int index, T element)
            throws IndexOutOfBoundsException, NullPointerException {
        try{
            if (this.size() < index || index < 0) throw new IndexOutOfBoundsException();
            if (element == null) throw new NullPointerException();
            Node nodeToAdd = new Node(element);
            Node nthNode = this.getNth(index);

            nodeToAdd.setPrev(nthNode.getPrev());
            nodeToAdd.setNext(nthNode);

            nthNode.getPrev().setNext(nodeToAdd);
            nthNode.setPrev(nodeToAdd);

            this.nelems += 1;
        }catch (IndexOutOfBoundsException e){
            throw e;
        }catch (NullPointerException e){
            throw e;
        }
    }

    /**
     * Clear the linked list
     */
    @Override
    public void clear() {
        this.head.setNext(this.tail);
        this.tail.setPrev(this.head);
        this.nelems = 0;
    }

    /**
     * Determine if the list contains the data element anywhere in the list.
     *
     * @param element - the value we want to check
     */
    @Override
    public boolean contains(Object element) {
        T data = (T)element;
        Node checkNode = new Node(data);

        Node iterNode = this.head.getNext();

        while(!(iterNode.getElement().equals(checkNode.getElement()))){
            if (iterNode.getNext().getElement() == null){
                return false;
            }
            iterNode = iterNode.getNext();
        }
        return true;
    }

    /**
     * Retrieves the element stored with a given index on the list.
     * @return the data contained in the node @ given index
     * @throws IndexOutOfBoundsException - if index outside range (0, size-1)
     */
    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        try{
            if (this.size() < index || index < 0) throw new IndexOutOfBoundsException();
            Node nodeToGet = getNth(index);
            return nodeToGet.getElement();
        }catch (IndexOutOfBoundsException e){
            throw e;
        }
    }

    /**
     * Helper method to get the Nth node in our list
     * @param index - the index that we want to access
     */
    private Node getNth(int index) {
        int iterator = 0;
        Node nodeToIterate = this.head.getNext();
       do{
            if (iterator == index) break;
            nodeToIterate = nodeToIterate.getNext();
            iterator += 1;
        } while(iterator < index);
        return nodeToIterate;
    }

    /**
     * Determine if the list empty
     *
     * @return true if list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * Remove the element from position index in the list
     *
     * @throws IndexOutOfBoundsException - if idx out of bounds
     */
    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        try{
            if (index < 0 || index > this.size()) throw new IndexOutOfBoundsException();
            Node nthNode = this.getNth(index);
            nthNode.remove();
            this.nelems --;
            return nthNode.getElement();
        }catch (IndexOutOfBoundsException e){
            throw e;
        }

    }

    /**
     * Set the value of an element at a certain index in the list.
     *
     * @param index - the index of the list we are setting our element to
     * @param element - the element we are setting
     */
    @Override
    public T set(int index, T element)
            throws IndexOutOfBoundsException, NullPointerException {
        try{
            if (element == null) throw new NullPointerException();
            if (index > this.size() || index < 0) throw new IndexOutOfBoundsException();

            Node nthNode = this.getNth(index);

            T elem = nthNode.getElement();
            nthNode.setElement(element);

            return elem;
        }catch (IndexOutOfBoundsException e){
            throw e;
        }catch (NullPointerException e){
            throw e;
        }
    }

    /**
     * Retrieves the amount of elements that are currently on the list.
     *
     */
    @Override
    public int size() {
        return this.nelems;
    }

    /**
     * String representation of this list in the form of:
     * "[(head) -> elem1 -> elem2 -> ... -> elemN -> (tail)]"
     *
     */
    @Override
    public String toString() {
        String str = new String("");
        str += new String("[(head) -> ");
        int i = 0;
        Node iter = this.head.getNext();
        while (i < size()){
            str = str + "" + iter.getElement()+ new String(" -> ");
            iter = iter.getNext();
            i++;
        }
        str = str + new String("(tail)]");
        return str;
    }

    /* ==================== EXTRA CREDIT ==================== */

    /**
     * Remove nodes whose index is a multiple of base
     *
     * @param base - the number we will be removing multiples of
     */
    public void removeMultipleOf(int base) {
        if (base < 1) throw new IllegalArgumentException();
        int counter = 0;
        int counter2 = 0;
        // first loop counts all values that are divisible by base
        for (int i = 0; i < this.size(); i++) {
            if (i % base == 0){
                counter++;
            }
        }

        // we make a nums[] which has a size of all these values
        int[] nums = new int[counter];
        for (int i = 0; i < this.size() - 1; i++) {
            if (i % base == 0) {
                // we hold all values divisible by base in nums array
                nums[counter2] = i;
                counter2++;
            }
        }
        // iterating backwards, we remove each value in the nums array DLL
        for (int i = nums.length-1; i >= 0 ; i--) {
            this.remove(nums[i]);
        }

    }

    /**
     * Swap the nodes between index [0, splitIndex] of two lists
     *
     * @param other - the other DLL we will be accessing
     * @param splitIndex - the index at which we will split our two lists
     *
     */
    public void swapSegment(DoublyLinkedList other, int splitIndex) {
        // iterating backwards to make sure all nodes are taken
        for (int i = splitIndex - 1; i >= 0; i--) {
            // we remove the last node from each DLL and hold it in a variable
            T valueToFirst = (T) other.remove(i);
            T toOtherList = this.remove(i);
            // we then insert that node in the ith position of our DLL
            this.add(i,valueToFirst);
            other.add(i,toOtherList);
        }
    }

}