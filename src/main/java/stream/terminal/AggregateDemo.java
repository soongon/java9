package stream.terminal;

import stream.dish.Dish;

import java.util.*;
import java.util.stream.Collectors;

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
                .filter(Dish::isVegeterian)
                .mapToInt(Dish::getCalories)  // Stream<Integer> --> IntStream
                .average();

        double result = average.orElse(0);
        System.out.println(result);
        // 4. 과일과 기타 요리중에 가장 칼로리가 높은 음식의 이름을 출력하세요
        List<Dish> dishMax = dishes.stream()
                .filter(dish -> dish.getType().equals("FRUIT") || dish.getType().equals("OTHER"))
                .sorted((a, b) -> b.getCalories() - a.getCalories())
                .limit(1)
                .collect(Collectors.toList());
        System.out.println(dishMax.get(0).getName());

        // 4-1.과일과 기타 요리중에 가장 칼로리를 출력
        OptionalInt res = dishes.stream()
                .filter(dish -> dish.getType().equals("FRUIT") || dish.getType().equals("OTHER"))
                .mapToInt(dish -> dish.getCalories())
                .max();
        System.out.println(res.orElse(0));

        // 5. match 관련 - 칼로리가 700 이상인 요리가 있는가?
        boolean isOk = dishes.stream()
                .anyMatch(dish -> dish.getCalories() >= 900);
        System.out.println(isOk);

        // 6. reduce 사용하여 칼로리의 합계를 구하다.
        //    채식주의자용 요리의 칼로리 합
        Optional<Integer> result3 = dishes.stream()
                .filter(Dish::isVegeterian)
                .map(Dish::getCalories)  // Stream<Integer>
                .reduce(Integer::sum);
        System.out.println(result3.orElse(0));

        int result4 = dishes.stream()
                .filter(Dish::isVegeterian)
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);

    }
}
