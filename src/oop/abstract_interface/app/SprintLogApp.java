package oop.abstract_interface.app;

import oop.abstract_interface.domain.LearningActivity;
import oop.abstract_interface.domain.LectureLog;
import oop.abstract_interface.domain.PracticeLog;
import oop.abstract_interface.domain.ReadingLog;
import oop.abstract_interface.policy.Reviewable;
import oop.abstract_interface.policy.Shareable;
import oop.abstract_interface.printer.ActivityPrinter;
import oop.abstract_interface.printer.CompactActivityPrinter;
import oop.abstract_interface.printer.ConsolActivityPrinter;

public class SprintLogApp {
    public static void main(String[] args) {
        LectureLog javaLecture = new LectureLog("Java 객체지향", 50, true, "박코치");
        PracticeLog gitPractice = new PracticeLog("Git 브랜치 실습", 70, true, 80);
        PracticeLog oopPractice = new PracticeLog("캡슐화 리팩터링", 40, false, 45);
        ReadingLog oopBook = new ReadingLog("객체지향의 사실과 오해", 35, true, "객체지향의 사실과 오해");

        // 추상클래스는 스스로의 객체를 생성할 수 없고, 자식에 의해서 생성될 뿐입니다.
        // LearningActivity act = new LearningActivity("test", 10);

        LearningActivity[] activitys = {javaLecture, gitPractice, oopPractice, oopBook};
        ActivityPrinter printer = new ConsolActivityPrinter();
        ActivityPrinter printer2 = new CompactActivityPrinter();

        System.out.println();
        System.out.println("=== 학습 활동 목록 ===");
        for (int i = 0; i < activitys.length; i++) {
            printer.print(activitys[i]);
        }

        System.out.println();
        System.out.println("=== 간단 활동 목록 ===");
        for (int i = 0; i < activitys.length; i++) {
            printer2.print(activitys[i]);
        }

        Shareable[] shareables = {javaLecture, gitPractice, oopPractice, oopBook};

        System.out.println();
        System.out.println("=== 공유 가능한 활동 ===");
        for (Shareable shareable : shareables) {
            if (shareable.canShare()) {
                System.out.println("공유 가능한 활동: " + shareable.getShareTitle());
            }
        }

        // 다형성이란 부모 타입의 변수에 자식 타입의 객체가 들어올 수 있다는 것, 곧 상속 관계 하에서만 발생한다.
        // 인터페이스 구현 관계도 다형성 발생이 가능합니다.

    }
}

