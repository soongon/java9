package interfacedemo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaCompare {
    public static void main(String[] args) {
        List<String> favoriteColors =
                Arrays.asList("red", "pink", "blue", "brown", "purple");

        // 3. Lambda version
        Comparator<String> stringComparator = (a, b) -> b.length() - a.length();
        favoriteColors.sort(stringComparator);
        System.out.println(favoriteColors);
    }
}
