import org.junit.Test;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;



public class PersonTest {
    private static List<String> getFieldNames(Field[] fields) {
        List<String> fieldNames = new java.util.ArrayList<>();
        for (Field field : fields) {
            fieldNames.add(field.getName());

        }
        return fieldNames;
    }

    @Test
    public void givenObject_whenGetsFieldNamesAtRuntime_thenCorrect() {
        Object person = new Person();
        Field[] fields = person.getClass().getFields();
        List<String> actualFieldNames = getFieldNames(fields);


        assertTrue(Arrays.asList("name", "age")
                .containsAll(actualFieldNames));
    }
}

