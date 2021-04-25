package PA04;

/*
 Name: Bryan Talavera
 PID: A14378593
 */

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;



public class DoublyLinkedListTest {
    DoublyLinkedList<Integer> DLL;

    @Before
    public void createDLL(){
        DLL = new DoublyLinkedList<>();
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testIndexOOBE() {
        DLL.add(2,24);
    }

    @Test (expected = NullPointerException.class)
    public void testNullPointerEx() {
        DLL.add(0,null);
    }

    @Test
    public void testFirstAdd() {
        DLL.add(1);

        assertEquals(new Integer(1),DLL.get(0));
        assertEquals(1,DLL.size());

    }

    @Test
    public void testSecondAdd() {
        for (int i = 0; i < 15; i++) {
            DLL.add(15);
        }
        assertEquals(15,DLL.size());
    }

    @Test
    public void testAdd3() {
        for (int i = 0; i < 50; i++) {
            if (i % 2 != 0){
                DLL.add(1);
            }
        }
        assertEquals(25,DLL.size());
    }

    @Test
    public void testAdd_T_1() {
        DLL.add(0,1);
        assertEquals(new Integer(1),DLL.get(0));
    }

    @Test
    public void testAdd_T_2() {
        for (int i = 0; i < 15; i++) {
            if (i == 7){
                DLL.add(i,i);
            }else {
                DLL.add(i, 2);
            }
        }
        assertEquals(DLL.get(7),new Integer(7));
    }

    @Test
    public void testAdd_T_3() {
        for (int i = 0; i < 100; i++) {
            DLL.add(i,1);
        }
        assertEquals(100,DLL.size());
    }


    @Test
    public void testClear() {
        DLL.add(1);
        DLL.clear();
        assertEquals(0,DLL.size());
    }

    @Test
    public void testClear2() {
        int i = 0;
        while ( i != 10){
            DLL.add(1);
            i++;
        }
        DLL.clear();
        assertEquals(0,DLL.size());
    }

    @Test
    public void testClear3() {
        int i = 0;
        for ( ;i != 10;i++){
            DLL.add(1);
            i++;
        }
        DLL.clear();
        assertEquals(0,DLL.size());
    }

    @Test
    public void testContains() {
        DLL.add(1);
        DLL.add(62);
        DLL.add(2);
        assertEquals(true,DLL.contains(62));
    }

    @Test
    public void testContains2() {
        for (int i = 0; i < 10; i++) {
            DLL.add(1);
            if (i == 8){
                DLL.add(415);
                break;
            }
        }
        assertEquals(true,DLL.contains(415));
    }

    @Test
    public void testContains3() {
        for (int i = 0; i < 10; i++) {
            DLL.add(1);
            if (i == 9){
                DLL.add(415);
                break;
            }
        }
        assertEquals(false,DLL.contains(414));
    }

    @Test
    public void testSet() {
        DLL.add(2);
        DLL.set(0,1);
        assertEquals(new Integer(1),DLL.get(0));
    }

    @Test
    public void testSet2() {
        for (int i = 0; i < 5; i++) {
            DLL.add(i);
            DLL.set(i,1);
        }
        assertEquals(new Integer(1),DLL.get(4));
    }

    @Test
    public void testSet3() {
        int i = 0;
        DLL.add(2);
        while (DLL.get(0) != 1){
            DLL.set(i,i+1);
        }
        assertEquals(new Integer(1),DLL.get(0));
    }

    @Test
    public void testGet() {
        DLL.add(1);
        assertEquals(new Integer(1),DLL.get(0));
    }

    @Test
    public void testGet2() {
        for (int i = 0; i < 5; i++) {
            DLL.add(i+2);
        }
        assertEquals(new Integer(5),DLL.get(4));
    }

    @Test
    public void testGet3() {
        int i = 1;
        while (i < 2){
            DLL.add(i * 2);
            i++;
        }
        assertEquals(new Integer(2),DLL.get(1));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testGetException() {
        int i = 0;
        while (i != 2){
            DLL.add(i*2);
            i++;
        }
        assertEquals(new Integer(2),DLL.get(4));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testGetExceptionAgain() {
        DLL.add(1);
        DLL.get(-1);
    }

    @Test
    public void testIsEmpty() {
        assertEquals(true,DLL.isEmpty());
    }

    @Test
    public void testIsEmpty2() {
        for (int i = 0; i < 13; i++) {
            DLL.add(1);
        }

        for (int i = 0; i < 12; i++) {
            DLL.remove(0);
        }
        assertEquals(false,DLL.isEmpty());
    }

    @Test
    public void testIsEmpty3() {
        for (int i = 0; i < 10; i++) {
            DLL.add(1);
        }
        DLL.clear();
        DLL.add(1);
        assertEquals(false,DLL.isEmpty());
    }

    @Test
    public void testRemove() {
        DLL.add(1);
        DLL.remove(0);
        assertEquals(true,DLL.isEmpty());
    }

    @Test
    public void testRemoveAgain() {
        DLL.add(8);
        DLL.add(0);
        DLL.add(9);
        DLL.add(3);
        for (int i = 3; i >= 0; i--) {
            DLL.remove(i);
        }
        assertEquals(true,DLL.isEmpty());
    }

    @Test
    public void testRemoveAgain_Again() {
        int i = 0;
        for (; i < 5; i++) {
            DLL.add(i);
        }
        for (i=i-1; i >= 0; i--) {
            DLL.remove(i);
        }
        assertEquals(true,DLL.isEmpty());
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testSetIndexOOB_Exception() {
        DLL.set(2,1);
    }

    @Test (expected = NullPointerException.class)
    public void testSetIndexOOB_Exception_2() {
        DLL.set(0,null);
        DLL.add(1);
    }



    @Test
    public void testSize() {
        DLL.add(1);
        assertEquals(1,DLL.size());
    }

    @Test
    public void testSize2() {
        for (int i = 0; i < 10; i++) {
            DLL.add(34);
        }
        assertEquals(10,DLL.size());
    }

    @Test
    public void testSize3() {
        int i = 0;
        while (i < 8){
            DLL.add(i);
            i++;
        }
        assertEquals(8,DLL.size());
    }

    @Test
    public void testToString() {
        DLL.add(754);
        DLL.add(123);
        DLL.add(421);
        assertEquals("[(head) -> 754 -> 123 -> 421 -> (tail)]",DLL.toString());
    }


    @Test
    public void removeMultipleOf() {
    }

    @Test
    public void swapSegment() {
    }

}
