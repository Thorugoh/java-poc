import com.thorugoh.animals.Goat;
import org.junit.Test;

import java.lang.reflect.Modifier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GoatTest{
    @Test
    public void givenObject_whenGetsClassName_thenCorrect() {
        Object goat = new Goat("goat");
        Class<?> clazz = goat.getClass();

        assertEquals("Goat", clazz.getSimpleName());
        assertEquals("com.thorugoh.animals.Goat", clazz.getName());
        assertEquals("com.thorugoh.animals.Goat", clazz.getCanonicalName());
    }

    @Test
    public void givenClassName_whenCreatesObject_thenCorrect() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.thorugoh.animals.Goat");

        assertEquals("Goat", clazz.getSimpleName());
        assertEquals("com.thorugoh.animals.Goat", clazz.getName());
        assertEquals("com.thorugoh.animals.Goat", clazz.getCanonicalName());
    }

    @Test
    public void givenClass_whenRecognisesModifiers_thenCorrect()throws ClassNotFoundException {
        Class<?> goatClass = Class.forName("com.thorugoh.animals.Goat");
        Class<?> animalClass = Class.forName("com.thorugoh.animals.Animal");

        int goatMods = goatClass.getModifiers();
        int animalMods = animalClass.getModifiers();

        assertTrue(Modifier.isPublic(goatMods));
        assertTrue(Modifier.isPublic(animalMods));
        assertTrue(Modifier.isAbstract(animalMods));
    }

    @Test
    public void givenClass_whenGetsPackageInfo_thenCorrect() {
        Goat goat = new Goat("goat");
        Class<?> goatClass = goat.getClass();
        Package pkg = goatClass.getPackage();

        assertEquals("com.thorugoh.animals", pkg.getName());
    }
}