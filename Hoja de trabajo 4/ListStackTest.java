import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ListStackTest {

    @Test
    void testPushPop() {
        ListStack<Integer> stack =
                new ListStack<>(new SinglyLinkedList<>());

        stack.push(5);
        stack.push(8);

        assertEquals(8, stack.pop());
        assertEquals(5, stack.peek());
    }

    @Test
    void testIsEmpty() {
        ListStack<Integer> stack =
                new ListStack<>(new SinglyLinkedList<>());

        assertTrue(stack.isEmpty());

        stack.push(10);

        assertFalse(stack.isEmpty());
    }

    @Test
    void testEmptyException() {
        ListStack<Integer> stack =
                new ListStack<>(new SinglyLinkedList<>());

        assertThrows(RuntimeException.class, stack::pop);
    }
}