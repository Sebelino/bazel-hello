package se.tink.hello;

public class HelloWorld {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            System.out.println("hoyworld");
            Thread.sleep(1000);
        }
    }

    public static int add(int a, int b) {
        return a + b;
    }
}
