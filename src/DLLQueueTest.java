/*
 Name: Bryan Talavera
 PID: A14378593
 */

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DLLQueueTest {
    DLLQueue<Integer> queue;

    @Before
    public void setupQueue(){
        queue = new DLLQueue<>();
    }

    @Test
    public void testWorkingQueueConst(){
        try {
            DLLQueue<Integer> queue2 = new DLLQueue<Integer>();
        }catch (IllegalArgumentException e){
            System.out.println("Test failed");
        }
    }


    @Test
    public void testWorkingQueueConst2(){
        try {
            DLLQueue<Integer> queue2 = new DLLQueue<Integer>();
        }catch (IllegalArgumentException e){
            System.out.println("*Gilbert Gottfried Voice* You fool!");
            throw e;
        }
    }


    @Test
    public void testWorkingQueueConst3(){
        DLLQueue<Integer> queue2 = new DLLQueue<Integer>();
    }

    @Test
    public void testisEmptyQueue() {
        queue.enqueue(12);
        assertFalse(queue.isEmpty());
        queue.dequeue();
        assertTrue(queue.isEmpty());
        queue.enqueue(43);
        queue.enqueue(674);
        queue.dequeue();
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }



    @Test
    public void testQueueSize() {
        queue.enqueue(12);
        assertTrue(1 == queue.size());
        queue.dequeue();
        assertTrue(0 == queue.size());
        for (int i = 0; i < 4; i++) {
            queue.enqueue(90);
        }
        assertTrue(4 == queue.size());
    }

    @Test
    public void testQueueEnqueue() {
        queue.enqueue(56);
        queue.enqueue(42);
        queue.enqueue(queue.dequeue());
        assertTrue(42 == queue.peek());
        queue.dequeue();
        assertTrue(56 == queue.peek());

    }

    @Test
    public void testQueuePeek() {
        queue.enqueue(1);
        assertTrue(1 == queue.peek());
        queue.dequeue();
        int[] numbers = {5,6,2,67};
        int i = 0;
        while (i != numbers.length){
            queue.enqueue(numbers[i]);
            i++;
        }
        assertTrue(5 == queue.peek());
        for (int j = 0; j < numbers.length-1 ; j++) {
            queue.dequeue();
        }
        assertTrue(67 == queue.peek());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testForEnqueueException(){
        queue.enqueue(null);
    }

    @Test
    public void testForEnqueue() {
        queue.enqueue(13);
        assertTrue(13 == queue.peek());
        queue.dequeue();
        queue.enqueue(356);
        assertTrue(356 == queue.peek());
        queue.dequeue();
        queue.enqueue(-15);
        assertTrue( -15 == queue.peek());
    }

    @Test
    public void testForDequeue() {
        queue.enqueue(234);
        queue.dequeue();
        assertTrue(0 == queue.size());
        queue.enqueue(223);
        queue.dequeue();
        assertTrue(0 == queue.size());
        queue.enqueue(134);
        queue.enqueue(254);
        int value = queue.dequeue();
        assertEquals(134, value);
    }
}