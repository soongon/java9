package stream.intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MappingDemo {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a", "ab", "abc", "abcd", "abcde");
        IntStream ints = strings.stream()
                .mapToInt(String::length);

        IntStream intStream = IntStream.rangeClosed(1, 20);
        intStream
                .boxed() // Stream<Integer>
                //.peek(System.out::println)
                .map(i -> i * 2)
                .limit(10)
                //.peek(System.out::println)
                .forEach(System.out::println);
    }
}
