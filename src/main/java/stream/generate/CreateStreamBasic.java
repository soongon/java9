package stream.generate;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class CreateStreamBasic {
    public static void main(String[] args) {
        //1. 컬렉션에서 스트림 생성
        List<String> stringList = Arrays.asList("hello", "world", "kim", "soongon");
        Stream<String> stream = stringList.stream();

        //2. 배열에서 스트림 생성
        String[] stringArray = {"hello", "lee", "kim", "park"};
        int[] intArray = {1, 2, 3,4, 5, 6};
        double[] doubleArray = {1.0, 2.0, 3.1, 4.5};

        Stream<String> stringArray1 = Stream.of(stringArray);
        IntStream intArray1 = IntStream.of(intArray);
        DoubleStream doubleArray1 = DoubleStream.of(doubleArray);

        //3. 특정 범위로 스트림 생성
        IntStream range = IntStream.rangeClosed(1, 100);
        // range.forEach(System.out::println);

        OptionalDouble average =
                LongStream
                        .rangeClosed(1_000_000_000L, 10_000_000_000L)
                        .average();
        double v = average.orElse(0);
        System.out.println(v);



        // 중간연산과 최종연산 데모
//        stringArray1
//                .filter(str -> str.length() >= 5)
//                .forEach(System.out::println);
    }
}
