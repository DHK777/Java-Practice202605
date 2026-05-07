package basic;

public class JavaStarter {
    public static void main(String[] args) {
        // 주석(comments)은 프로그램의 실행에 영향을 주지 않습니다.
        // 인텔리제이 출력 함수 생성: sout
        System.out.println("Hello World");

        String title = "Java 변수와 자료형";
        int studyMinutes = 90;
        int targetMinutes = 120;
        int extraMinutes = 60;

        studyMinutes = 80;

        boolean isPublic = true;
        char level = 'A';
        double progressRate = (double) studyMinutes / targetMinutes;

        boolean isEnoughStudy = studyMinutes >= 60;

        // 문자열의 덧셈 연산은 뒤에 어떤 타입이 들어와도 가능하다
        System.out.println(title + "제목");
        System.out.println(studyMinutes);
        System.out.println(targetMinutes);
        System.out.println(extraMinutes);
        System.out.println(isPublic);
        System.out.println(level);
        System.out.println(progressRate);

    }
}
