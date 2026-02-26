import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DoublyLinkedListTest {

    @Test
    void testAddFirst() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.addFirst(1);
        list.addFirst(2);

        assertEquals(2, list.getFirst());
        assertEquals(2, list.size());
    }

    @Test
    void testRemoveFirst() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.addFirst(3);
        list.addFirst(7);

        assertEquals(7, list.removeFirst());
        assertEquals(1, list.size());
    }

    @Test
    void testEmptyException() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        assertThrows(RuntimeException.class, list::removeFirst);
    }
}