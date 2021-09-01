package interfacedemo;

public class LambdaDemo01 {
    public static void main(String[] args) {
        LambdaDemo01 demo = new LambdaDemo01();
        System.out.println(demo.calcNumber(new FFIImpl(), 2, 3));
    }
    public int calcNumber(FirstFunctionalInterface ffi, int a, int b) {
        return ffi.calc(a, b);
    }

    static class FFIImpl implements FirstFunctionalInterface {
        @Override
        public int calc(int a, int b) {
            return a * 2 + b;
        }
    }
}

@FunctionalInterface
interface FirstFunctionalInterface {
    int calc(int a, int b);
    default int add(int a, int b) {
        return a + b;
    }
    static int sub(int a, int b) {
        return a -b;
    }
}