import com.thorugoh.animals.Goat;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GoatTest{
    private static List<String> getFieldNames(Field[] fields) {
        List<String> fieldNames = new java.util.ArrayList<>();
        for (Field field : fields) {
            fieldNames.add(field.getName());

        }
        return fieldNames;
    }

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
    public void givenClass_whenRecognisesModifiers_thenCorrect() throws ClassNotFoundException {
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

    // get constructor of the goat class
    @Test
    public void givenClass_whenGetsConstructor_thenCorrect() throws ClassNotFoundException {
        Class<?> goatClass = Class.forName("com.thorugoh.animals.Goat");

        Constructor<?>[] constructors = goatClass.getConstructors();

        assertEquals(1, constructors.length);
        assertEquals("com.thorugoh.animals.Goat", constructors[0].getName());
    }

    // Inspect fields of the animal class
    @Test
    public void givenClass_whenGetsFields_thenCorrect() throws ClassNotFoundException {
        Class<?> animalClass = Class.forName("com.thorugoh.animals.Animal");
        Field[] fields = animalClass.getDeclaredFields();

        List<String> actualFields = getFieldNames(fields);
        assertEquals(2, actualFields.size());
        assertTrue(actualFields.containsAll(Arrays.asList("name", "CATEGORY")));
    }

    private static List<String> getMethodNames(Method[] methods) {
        List<String> methodNames = new ArrayList<>();
        for (Method method : methods)
            methodNames.add(method.getName());
        return methodNames;
    }

    //Inspect the methods of the animal class
    @Test
    public void givenClass_whenGetsMethods_thenCorrect() throws ClassNotFoundException {
        Class<?> animalClass = Class.forName("com.thorugoh.animals.Animal");
        Method[] methods = animalClass.getDeclaredMethods();
        List<String> actualMethods = getMethodNames(methods);

        assertEquals(3, actualMethods.size());
        assertTrue(actualMethods.containsAll(Arrays.asList("getName", "setName", "getSound")));
    }
}