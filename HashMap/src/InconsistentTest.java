import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;


public class InconsistentTest {

    @Test
    public void givenHashMap_whenSumParallel_thenError() throws Exception {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> sumList = parallelSum100(map, 100);

        assertNotEquals(1, sumList.stream().distinct().count());
        long wrongResultCount = sumList
                .stream()
                .filter(num -> num != 100)
                .count();
        assertTrue(wrongResultCount > 0);
    }

    @Test
    public void givenConcurrentMap_whenSumParallel_thenCorrect() throws Exception {
        Map<String, Integer> map = new ConcurrentHashMap<>();
        List<Integer> sumList = parallelSum100(map, 1000);

        assertEquals(1, sumList.stream().distinct().count());
        long wrongResultCount = sumList.stream().filter(num -> num != 100).count();
        assertEquals(0, wrongResultCount);
    }

    @Test(expected = NullPointerException.class)
    public void givenConcurrentHashMap_whenPutWithNullKey_thenThrowsNPE(){
        Map<String, Integer> map = new ConcurrentHashMap<>();
        map.put(null, 1);
    }

    @Test(expected = NullPointerException.class)
    public void givenConcurrentHashMap_whenPutWithNullValue_thenThrowsNPE(){
        Map<String, Integer> map = new ConcurrentHashMap<>();
        map.put("test", null);
    }

    @Test
    public void givenKeyPresent_whenComputeRemappingNull_thenMappingRemoved() {
        Object oldValue = "value";
        Map<String, Object> map = new ConcurrentHashMap<>();
        map.put("test", oldValue);
        map.compute("test", (key, value) -> null);
        assertNull(map.get("test"));

    }

    private List<Integer> parallelSum100(Map<String, Integer> map,
                                         int executionTimes) throws InterruptedException {
        List<Integer> sumList = new ArrayList<>(1000);
        for (int i = 0; i < executionTimes; i++) {
            map.put("test", 0);
            ExecutorService executorService =
                    Executors.newFixedThreadPool(4);
            for (int j = 0; j < 10; j++) {
                executorService.execute(() -> {
                    for (int k = 0; k < 10; k++)
                        map.computeIfPresent(
                                "test",
                                (_, value) -> value + 1
                        );
                });
            }
            executorService.shutdown();
            executorService.awaitTermination(5, TimeUnit.SECONDS);
            sumList.add(map.get("test"));
        }
        return sumList;
    }
}