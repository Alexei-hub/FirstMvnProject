package Streams;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class StreamExample {
    public static void main(String[] args) {
        int countExample = Stream.of(1, 2, 3).reduce(0, (count, element) -> count + element);
        System.out.println(countExample);

        int count = 0;
        for (int element : new int[]{1, 2, 3}) {
            count += element;
        }

    }
}
