import com.thorugoh.animals.Goat;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GoatTest{
    @Test
    public void givenObject_whenGetsClassName_thenCorrect() {
        Object goat = new Goat("goat");
        Class<?> clazz = goat.getClass();

        assertEquals("Goat", clazz.getSimpleName());
        assertEquals("com.thorugoh.animals.Goat", clazz.getName());
        assertEquals("com.thorugoh.animals.Goat", clazz.getCanonicalName());
    }
}