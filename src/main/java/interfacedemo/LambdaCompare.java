package interfacedemo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaCompare {
    public static void main(String[] args) {
        List<String> favoriteColors =
                Arrays.asList("red", "pink", "blue", "brown", "purple");

        // 3. Lambda version
        favoriteColors.sort((a, b) -> b.length() - a.length());
        System.out.println(favoriteColors);
    }
}
