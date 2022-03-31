import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class StackTest {
    Stack stack;


    @Before
    public void init(){
        stack = new Stack();
    }
    
    @Test
    public void testPush(){
        stack.push(new Element(30));
        assertEquals(stack.getTop().getInfo(), 30);
    }

    @Test
    public void testPop(){
        stack.push(new Element(10));
        stack.push(new Element(20));
        stack.push(new Element(30));
        assertEquals(stack.pop(), 30);
        assertEquals(stack.getTop().getInfo(), 20);

    }

    @Test
    public void testPushN(){
        stack.pushN(5, new int[]{1,2,3,4,5});
        assertEquals(stack.toString(), "5\n4\n3\n2\n1\n");
        assertEquals(stack.getTop().getInfo(), 5);
        assertEquals(stack.getNoElements(), 5);
    }

    @Test
    public void testPopN(){
        stack.pushN(5, new int[] { 1, 2, 3, 4, 5 });
        assertArrayEquals(stack.popN(3).stream().mapToInt((Integer i)->i.intValue()).toArray(),
         new int[]{5,4,3});
        assertEquals(stack.getTop().getInfo(), 2);
        assertEquals(stack.getNoElements(), 2);
    }
}
