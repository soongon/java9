package apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class AppleClassifier {

    // filtering, mapping, reducing

    public static void main(String[] args) {

        List<Apple> apples = Arrays.asList(
                new Apple(250, "green"),
                new Apple(350, "red"),
                new Apple(550, "green"),
                new Apple(150, "red"),
                new Apple(450, "green"),
                new Apple(250, "green"),
                new Apple(550, "red")
        );

        // 1. 300 그램 이상인 사과를 필터링
//        List<Apple> appleOver300 = new ArrayList<>();
//        for (Apple apple : apples) {
//            if (apple.getWeight() > 300) {
//                appleOver300.add(apple);
//            }
//        }

        Predicate<Apple> condition = a -> a.getColor().equals("red") && a.getWeight() > 300;

        List<Apple> filterApples = filterApples(apples, apple -> apple.getWeight() > 300);

        System.out.println();
    }

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> predicate) {
        List<Apple> newList = new ArrayList<>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                newList.add(apple);
            }
        }
        return newList;
    }
}
