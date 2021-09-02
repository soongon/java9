package stream.terminal;

import stream.dish.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class AggregateDemo {
    public static void main(String[] args) {
        List<Dish> dishes = Arrays.asList(
                new Dish("beef", false, 600, "MEAT"),
                new Dish("pork", false, 800, "MEAT"),
                new Dish("chicken", false, 450, "MEAT"),
                new Dish("french fries", true, 530, "OTHER"),
                new Dish("rice", true, 300, "OTHER"),
                new Dish("spagetti", true, 400, "NOODLE"),
                new Dish("apple", true, 300, "FRUIT"),
                new Dish("melon", true, 320, "FRUIT"),
                new Dish("salmon", true, 420, "FISH"),
                new Dish("prawn", true, 410, "FISH")
        );

        // 1. 전체 요리의 갯수
        long count = dishes.stream()
                .count();
        System.out.println("전체 요리 갯수는 " + count);
        // 2. 칼로리가 300 이상인 FISH 요리의 갯수는?
        long count2 = dishes.stream()
                .filter(dish -> dish.getCalories() >= 300)
                .filter(dish -> dish.getType().equals("FISH"))
                .count();
        System.out.println(count2);
        // 3. vegeterian 용 요리의 평균 칼로리는?
        OptionalDouble average = dishes.stream()
                .filter(dish -> dish.isVegeterian())
                .mapToInt(dish -> dish.getCalories())  // Stream<Integer> --> IntStream
                .average();

        double result = average.orElse(0);
        System.out.println(result);
        // 4. 과일과 기타 요리중에 가장 칼로리가 높은 음식의 이름을 출력하세요

    }
}
