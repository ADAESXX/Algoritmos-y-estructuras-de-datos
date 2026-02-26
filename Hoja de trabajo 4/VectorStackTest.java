import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class VectorStackTest {

	@Test
	void testPushPop() {
	    VectorStack<Integer> stack = new VectorStack<>();

	    stack.push(10);
	    stack.push(20);

	    assertEquals(20, stack.pop());
	    assertEquals(1, stack.size());
	}

    
    @Test
    void testPeek() {
        VectorStack<Integer> stack = new VectorStack<>();

        stack.push(50);

        assertEquals(50, stack.peek());
    }

    @Test
    void testEmptyException() {
        VectorStack<Integer> stack = new VectorStack<>();

        assertThrows(RuntimeException.class, stack::pop);
    }
}