package interfacedemo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaCompare {
    public static void main(String[] args) {
        List<String> favoriteColors =
                Arrays.asList("red", "pink", "blue", "brown", "purple");

        favoriteColors.sort(new MyComparator());
        System.out.println(favoriteColors);
    }
}

// 1. impl class version
class MyComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o2.length() - o1.length();
    }
}
