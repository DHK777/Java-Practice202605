package oop.constructor;

import java.sql.SQLOutput;

public class LearningLog {

    // 객체의 속성을 필드(field)라고 합니다. 또는 멤버 변수라고도 합니다.

    String title;
    int minutes;
    boolean publicLog;

    // 생성자는 클래스의 이름과 대/소문자까지 완전히 일치해야 합니다.
    // 그리고 메서드와 달리 리턴 타입이 존재하지 않습니다.
    LearningLog() {
        System.out.println("기본 생성자 호출!");
    }

    LearningLog(String title, int minutes) {
        // this() 문법으로 자기 자신의 다른 생성자를 호출하는 것이 가능합니다.
        //this.title = title;
        //this.minutes = minutes;
        //publicLog = true;
        this(title, minutes, true);
    }

    LearningLog(String title, int minutes, boolean publicLog) {
        // this는 현재 객체 자기 자신을 뜻합니다.
        // 생성자에서의 this는 곧 지금 생성자에 의해 생성되고 있는 그 객체를 의미합니다.
        this.title = title;
        this.minutes = minutes;
        this.publicLog = publicLog;
    }
    void printSummary() {
        System.out.println(title + " - " + minutes + "분");
    }

    boolean needsReview() {
        return minutes < 60;
    }
}
