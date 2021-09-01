package interfacedemo;

public class LambdaDemo02 {
    public static void main(String[] args) {
        LambdaDemo02 demo = new LambdaDemo02();
        demo.calcNumber((a, b) -> a * a + b, 5, 7);

    }
    public int calcNumber(FirstFunctionalInterface02 ffi, int a, int b) {
        return ffi.calc(a, b);
    }
}

@FunctionalInterface
interface FirstFunctionalInterface02 {
    int calc(int a, int b);
    default int add(int a, int b) {
        return a + b;
    }
    static int sub(int a, int b) {
        return a -b;
    }
}