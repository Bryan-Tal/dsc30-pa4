

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DLLStackTest {
    DLLStack<Integer> stack;
    @Before
    public void setUp() throws Exception {
        stack = new DLLStack<>();
    }
    @Test
    public void workingConstructor(){
        try {
            DLLStack<Integer> stack2 = new DLLStack<Integer>();
        }catch (IllegalArgumentException e){
            fail("You Fail");
        }
    }


    @Test
    public void constructor2Works(){
        try {
            DLLStack<Integer> stack2 = new DLLStack<Integer>();
        }catch (IllegalArgumentException e){
            System.out.println("*Gilbert Gottfried Voice* You fool!");
            throw e;
        }
    }


    @Test
    public void constructor3Works(){
        DLLStack<Integer> stack2 = new DLLStack<Integer>();
    }

    @Test
    public void testsEmpty() {
        stack.push(56);
        stack.pop();
        assertTrue(stack.isEmpty());
        stack.push(23);
        assertFalse(stack.isEmpty());
        stack.push(53);
        stack.pop();
        assertFalse(stack.isEmpty());
    }



    @Test
    public void sizeTestx3() {
        stack.push(124);
        assertTrue(1 == stack.size());
        stack.pop();
        assertTrue(0 == stack.size());
        for (int i = 0; i < 4; i++) {
            stack.push(1);
        }
        assertTrue(4 == stack.size());
    }


    @Test
    public void peekTester() {
        stack.push(1);
        assertTrue(1 == stack.peek());
        int[] numbers = {5,23,56,6};
        int i = 0;
        while (i != 4){
            stack.push(numbers[i]);
            i++;
        }
        assertTrue(6 == stack.peek());
        int j = 0;
        while (j != 2){
            stack.pop();
            j++;
        }
        assertTrue(23 == stack.peek());
    }

    @Test (expected = IllegalArgumentException.class)
    public void pushTesterException(){
        stack.push(null);
    }

    @Test
    public void pushTester() {
        stack.push(23);
        assertTrue(23 == stack.peek());
        stack.push(645);
        stack.push(76);
        assertTrue(76 == stack.peek());
        stack.push(-32);
        assertTrue( -32 == stack.peek());
    }



    @Test
    public void popTester() {
        stack.push(221);
        stack.pop();
        stack.push(1);
        assertTrue(1 == stack.size());
        stack.push(2234);
        stack.push(11);
        stack.pop();
        stack.pop();
        assertTrue(1 == stack.size());
        stack.push(145);
        stack.push(53);
        stack.pop();
        stack.pop();
        assertTrue(1 == stack.size());
    }
}