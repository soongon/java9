package stream.dish;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DishAnalizer {
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
        // 목적 : 칼로리가 400이하인 요리의 이름을 칼로리 순으로 정렬하여 상위 3개 출력
        List<String> collect = dishes.stream()
                .filter(dish -> dish.getCalories() <= 400) // Stream<Apple>
                .sorted(Comparator.comparingInt(Dish::getCalories))  // Stream<Apple>
                .map(Dish::getName)  // Stream<String>
                .collect(Collectors.toList());

        System.out.println(collect);

    }
}
