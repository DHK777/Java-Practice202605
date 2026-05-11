package oop.enum_exception.exception;

public class ThrowExample {
    
    static int calcTotal(int end) throws RuntimeException {
        if (end <= 0) {
            // throw는 예외가 발생한 지점에서 예외 객체를 생성하여 던지는 방식입니다.
            // throw는 메서드 선언부에 예외를 명시할 필요가 없으며, 예외 처리를 강요하지 않습니다.
            // throw는 예외가 발생한 지점에서 예외 객체를 생성하여 던지는 방식입니다.
            throw new RuntimeException("0보다 작은 수는 입력할 수 없습니다.");
        }

        int total = 0;
        for (int i = 1; i <= end; i++) {
            total += i;
        }
        return total;
    }
    
    public static void main(String[] args) {
        try {
            int result = calcTotal(100);

            System.out.println("result = " + result);

            int result2 = calcTotal(-10);
            System.out.println("result2 = " + result2);
        } catch (RuntimeException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
        System.out.println("프로그램 정상 종료!");
    }
}
