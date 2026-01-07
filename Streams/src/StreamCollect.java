import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamCollect {
    public static void main(String[] args) {
        List<String> technologies = List.of("Java", "React", "Node", "JS", "Html");

        Map<Integer, List<String>> groupedByLength = technologies.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println(groupedByLength);
    }
}
