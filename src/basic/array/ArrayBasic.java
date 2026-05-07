package basic.array;

import java.util.Arrays;

public class ArrayBasic {
    public static void main(String[] args) {
        // 1. 배열 변수 선언
        int[] numbers;

        // 2. 배열 객체 생성
        numbers = new int[5];

        numbers[0] = 50;
        numbers[1] = 77;
        numbers[2] = (int) 3.14;
        numbers[3] = numbers[0] + 20;
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
        // 배열의 순회 forEach (향상된 for문)
        // 무조건 범위는 배열의 처음부터 끝까지로 설정됩니다. (중간에 break나 continue는 가능함)
        for (int n : numbers) {    // iter
            System.out.println(n);
        }
        // 배열 내부를 문자열 형태로 한 번에 출력하기
        // 자바유틸 패키지의 Arrays 클래스의 전역함수 사용
        System.out.println(Arrays.toString(numbers));
        // 배열 쉽게 초기화 하기
        //선언 당시에 크기가 고정되고, 그 크기는 변할 수 없습니다.
        // 만약 혹시라도 크기를 늘리거나 줄이고 싶다면 배열을 새로 만들어서 값을 옮겨야 합니다.
        String[] pets = {"멍멍이", "야옹이", "짹짹이", "춘식이"};
            // pets = {"멍멍이", "야옹이", "짹짹이"}; // 배열은 한 번 만들어지면 크기가 고정되기 때문에 이렇게는 초기화 할 수 없습니다.
        pets = new String[]{"멍멍이", "야옹이", "짹짹이"};
    }
}
