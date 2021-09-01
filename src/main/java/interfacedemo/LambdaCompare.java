package interfacedemo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaCompare {
    public static void main(String[] args) {
        List<String> favoriteColors =
                Arrays.asList("red", "pink", "blue", "brown", "purple");

        // 2. anonymous inner class version
        favoriteColors.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        System.out.println(favoriteColors);
    }
}
