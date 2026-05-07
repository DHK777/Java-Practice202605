package oop.intro;

public class LearningLog {

    // 객체의 속성을 필드(field)라고 합니다. 또는 멤버 변수라고도 합니다.
    String title;
    int minutes;
    boolean publicLog;

    void printSummary() {
        System.out.println(title + " - " + minutes + "분");
    }

    boolean needsReview() {
        return minutes < 60;
    }
}
