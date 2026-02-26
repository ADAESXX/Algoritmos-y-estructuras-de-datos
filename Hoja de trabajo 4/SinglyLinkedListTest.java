import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SinglyLinkedListTest {

    @Test
    void testAddFirst() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        list.addFirst(10);
        list.addFirst(20);

        // El último insertado debe estar primero
        assertEquals(20, list.getFirst());
        assertEquals(2, list.size());
    }

    @Test
    void testRemoveFirst() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        list.addFirst(5);
        list.addFirst(8);

        assertEquals(8, list.removeFirst());
        assertEquals(1, list.size());
    }

    @Test
    void testEmptyException() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        assertThrows(RuntimeException.class, list::removeFirst);
    }
}