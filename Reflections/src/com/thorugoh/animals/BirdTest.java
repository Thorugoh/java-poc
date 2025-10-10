package com.thorugoh.animals;

import org.junit.Test;

import java.lang.reflect.Constructor;

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
}
