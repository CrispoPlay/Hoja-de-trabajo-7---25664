import org.example.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DictionaryTest {

    @Test
    public void shouldLoadDictionaryAndFindExistingWord() {
        Dictionary dict = new Dictionary();

        dict.loadDictionary("diccionario.txt");

        String result = dict.getTree().search("dog");

        assertEquals("perro", result);
    }
}