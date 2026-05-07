package basic.loop;

public class WhileExample {
    public static void main(String[] args) {

        // 반복문의 필수 3요소 (begin - end - step)
        // 안녕하세요! n번 고객님

        int i  = 1; // begin
        while (i <= 10) { // end
            System.out.println("안녕하세요! " + i + "번 고객님");
            i += 1; // step
            // i++; // 증감연산자 (단순 변수의 값을 하나 올리거나 내릴때 사용)
        }

        for (int j = 1; j <= 10; j++) {
            System.out.println("안녕하세요! " + j + "번 고객님");
        }

        System.out.println("============================================");

        // 1 ~ 10까지의 누적합계 구하기
        int sum = 0;

        for (int j = 1; j <= 100; j++) {
            sum += j; // sum = sum + j;
        }
        System.out.println("1부터 100까지의 누적합계: " + sum);
        System.out.println("sum = " + sum); // soutv, v == valuable

        System.out.println("============================================");

        int primeNum = 13;
        int n = 1;
        int count = 0;
        while (n <= primeNum) {
            if (primeNum % n == 0) {
                count++;
            }
            n++;
        }
        if (count == 2) {
            System.out.println(primeNum + "는 소수입니다.");
            System.out.println("count = " + count);
        } else {
            System.out.println(primeNum + "는 소수가 아닙니다.");
            System.out.println("count = " + count);
        }

        System.out.println("============================================");

        int s = 2;

        while (primeNum % s != 0) {
            s++;
        }

        if (primeNum == s) {
            System.out.println(primeNum + "는 소수입니다.");
        } else {
            System.out.println(primeNum + "는 소수가 아닙니다.");
        }

    }

}
