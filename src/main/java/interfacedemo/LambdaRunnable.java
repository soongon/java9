package interfacedemo;

public class LambdaRunnable {
    public static void main(String[] args) {
        System.out.println("메인쓰레드 시작");
        new Thread(() -> System.out.println("별도 쓰레드 동작.."))
                .start();
        System.out.println("메인 쓰레드 끝");
    }
}
