package array;

import java.util.Arrays;

public class Array2D {
    public static void main(String[] args) {
        // 2차원 배열은 배열의 배열로 표현할 수 있다.
        // 배열은 선언할 때 각 인덱스 자리의 값이 비어있지 않고
        // 각 타입의 기본값으로 초기화 됩니다.
        // 기본값: 정수 0, 실수 0.0, 논리 false, 문자 (공백), 기타 null
        int[][] arr = new int[3][4]; // 3행 4열의 2차원 배열 생성

        // 2차원 배열에 값 할당
        arr[0][0] = 1;
        arr[0][1] = 2;
        //arr[0][2] = 3;
        arr[0][3] = 4;

        //arr[1][0] = 5;
        arr[1][1] = 6;
        arr[1][2] = 7;
        //arr[1][3] = 8;

        arr[2][0] = 9;
        //arr[2][1] = 10;
        arr[2][2] = 11;
        arr[2][3] = 12;

        // 2차원 배열 출력
        for (int i = 0; i < arr.length; i++) { // 행 반복
            for (int j = 0; j < arr[i].length; j++) { // 열 반복
                System.out.print(arr[i][j] + " ");
            }
            System.out.println(); // 행이 끝날 때마다 줄 바꿈
        }
        System.out.println(Arrays.deepToString(arr)); // 2차원 배열을 문자열 형태로 출력

        for (int[] a : arr) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}
