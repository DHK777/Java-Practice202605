package loop;

public class ContinueExample {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            // for문에서 continue는 증감식이 실행됨.
            // while문에서 continue는 조건식이 실행됨.
            if (i == 5) continue;
            System.out.print(i + " ");
        }
        System.out.println("\n================================================");
    }
    int a = 1;
    while (a <= 10) {
        if (a == 5) {
            continue;
        }
        System.out.println(a + " ");
        a++;
    }
}
