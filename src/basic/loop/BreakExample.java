package basic.loop;

public class BreakExample {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            // 블록 내의 코드가 한 줄인 경우에는 중괄호 생략 가능 (두 줄은 안돼요)
            if (i == 5) break;
            System.out.print(i + " ");
        }
        System.out.println("\n================================================");

    }
}
