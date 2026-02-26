import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ArrayListStackTest {

    @Test
    void testPushPop() {
        ArrayListStack<Integer> stack = new ArrayListStack<>();

        stack.push(1);
        stack.push(2);

        assertEquals(2, stack.pop());
        assertEquals(1, stack.peek());
    }

    @Test
    void testIsEmpty() {
        ArrayListStack<Integer> stack = new ArrayListStack<>();

        assertTrue(stack.isEmpty());

        stack.push(99);

        assertFalse(stack.isEmpty());
    }

    @Test
    void testEmptyException() {
        ArrayListStack<Integer> stack = new ArrayListStack<>();

        assertThrows(RuntimeException.class, stack::pop);
    }
}