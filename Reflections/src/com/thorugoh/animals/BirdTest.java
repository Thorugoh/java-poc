package com.thorugoh.animals;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class BirdTest {

    @Test
    public void givenClass_whenGetsAllConstructors_thenCorrect() throws ClassNotFoundException {
        Class<?> birdClass = Class.forName("com.thorugoh.animals.Bird");
        Constructor<?>[] constructors = birdClass.getConstructors();

        assertEquals(3, constructors.length);
    }

    @Test
    public void givenClass_whenGetsAllDeclaredConstructors_thenCorrect() throws ClassNotFoundException, NoSuchMethodException {
        Class<?> birdClass = Class.forName("com.thorugoh.animals.Bird");

        Constructor<?> cons1 = birdClass.getConstructor();
        Constructor<?> cons2 = birdClass.getConstructor(String.class);
        Constructor<?> cons3 = birdClass.getConstructor(String.class, boolean.class);
    }

    @Test
    public void givenClass_whenInstantiateObjectsAtRuntime_thenCorrect() throws Exception {
        Class<?> birdClass = Class.forName("com.thorugoh.animals.Bird");

        Constructor<?> cons1 = birdClass.getConstructor();
        Constructor<?> cons2 = birdClass.getConstructor(String.class);
        Constructor<?> cons3 = birdClass.getConstructor(String.class, boolean.class);

        Bird bird1 = (Bird) cons1.newInstance();
        Bird bird2 = (Bird) cons2.newInstance("Weaver bird");
        Bird bird3 = (Bird) cons3.newInstance("dove", true);

        assertEquals("bird", bird1.getName());
        assertEquals("Weaver bird", bird2.getName());
        assertEquals("dove", bird3.getName());

        assertFalse(bird1.walks());
        assertTrue(bird3.walks());
    }


    // Inspecting Fields
    @Test
    public void givenClass_whenGetsPublicFields_thenCorrect() throws ClassNotFoundException {
        Class<?> birdClass = Class.forName("com.thorugoh.animals.Bird");
        Field[] fields = birdClass.getFields();

        assertEquals(1, fields.length);
        assertEquals("CATEGORY", fields[0].getName());
    }

    @Test
    public void givenClass_whenGetsPublicFieldByName_thenCorrect() throws ClassNotFoundException, NoSuchFieldException {
        Class<?> birdClass = Class.forName("com.thorugoh.animals.Bird");
        Field field = birdClass.getField("CATEGORY");

        assertEquals("CATEGORY", field.getName());
    }

    @Test
    public void givenClass_whenGetsDeclaredFields_thenCorrect() throws ClassNotFoundException {
        Class<?> birdClass = Class.forName("com.thorugoh.animals.Bird");
        // Inspect private fields as well
        Field[] fields = birdClass.getDeclaredFields();

        assertEquals(1, fields.length);
        assertEquals("walks", fields[0].getName());
    }

    @Test
    public void givenClass_whenGetsDeclaredFieldByName_thenCorrect() throws ClassNotFoundException, NoSuchFieldException {
        Class<?> birdClass = Class.forName("com.thorugoh.animals.Bird");
        Field field = birdClass.getDeclaredField("walks");

        assertEquals("walks", field.getName());
    }

    public void givenClassField_whenGetsType_thenCorrect() throws ClassNotFoundException, NoSuchFieldException {
        Class<?> birdClass = Class.forName("com.thorugoh.animals.Bird");
        Field field = birdClass.getDeclaredField("walks");
        Class<?> fieldClass = field.getType();

        assertEquals("boolean", fieldClass.getSimpleName());
    }
}
