import org.example.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {

    @Test
    public void shouldInsertAndFindElementsCorrectly() {
        BinaryTree<String, String> tree = new BinaryTree<>();

        tree.insert("dog", "perro");
        tree.insert("cat", "gato");
        tree.insert("house", "casa");

        assertEquals("perro", tree.search("dog"));
        assertEquals("gato", tree.search("cat"));
        assertEquals("casa", tree.search("house"));
    }

    @Test
    public void shouldReturnNullWhenElementNotFound() {
        BinaryTree<String, String> tree = new BinaryTree<>();

        tree.insert("dog", "perro");

        assertNull(tree.search("cat"));
    }

    @Test
    public void shouldMaintainCorrectStructureAfterMultipleInsertions() {
        BinaryTree<String, String> tree = new BinaryTree<>();

        tree.insert("m", "1");
        tree.insert("a", "2");
        tree.insert("z", "3");

        assertEquals("1", tree.search("m"));
        assertEquals("2", tree.search("a"));
        assertEquals("3", tree.search("z"));
    }

    @Test
    public void shouldReplaceValueWhenInsertingDuplicateKey() {
        BinaryTree<String, String> tree = new BinaryTree<>();

        tree.insert("dog", "perro");
        tree.insert("dog", "canino");

        assertEquals("canino", tree.search("dog"));
    }
}