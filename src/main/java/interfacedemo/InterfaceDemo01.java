package interfacedemo;

import java.nio.file.Path;
import java.util.Collection;

public class InterfaceDemo01 {

    private int c = 5;
    public static void main(String[] args) {
        System.out.println("Hello world");

        MyInterface.calc(1,2);
    }


    public int calcTwoNumbers(int a, int b) {
        System.out.println("hello");  // IO
        return a + b;
    }
}

interface MyInterface {
    int MY_INT = 5;
    double MY_DOUBLE = 3.14;

    int add(int a, int b);
    int sub(int a, int b);

    default int multiply(int a, int b) {
        return a * b;
    }

    default int divide(int a, int b) {
        return a / b;
    }

    static int calc(int a, int b) {
        return a + b;
    }
}

class MyClass implements MyInterface {

    @Override
    public int add(int a, int b) {
        return 0;
    }

    @Override
    public int sub(int a, int b) {
        return 0;
    }
}