package oop.inheritance.domain;

// 상속: 개념, 기능의 확장
// extends: 확장, 연장
public class LectureLog extends LearningActivity {

    private String instructorName;

    public LectureLog(String title, int minutes, boolean publicActivity, String instructorName) {
        // 상속 관계 하에서 자식 객체가 생성될 때 부모의 객체도 함께 생성됩니다. (그래야 필드, 메서드를 물려줄 수 있으니까)
        // 그래서 생성자에는 항상 super()가 내장되어 있습니다.
        // 그런데 만약 부모가 기본생성자가 없다면 직접 지정하여 호출해야 합니다.
        super(title, minutes, publicActivity);
        this.instructorName = normalizeInstructorName(instructorName);
    }

    // 메서드 재정의 (override)
    // 부모가 물려준 메서드가 자식에게 맞지 않거나 부족할 경우 자식이 재 정의해서 사용할 수 있습니다.
    // 오버라이딩 규칙: 1. 메서드 이름이 같아야한다, 2. 리턴 타입이 같아야 한다,
    // 3. 매개변수의 선언이 일치해야 한다.
    // 어노테이션(annotation): 컴파일러에게 알려주는 일종의 메타데이터입니다.
    @Override
    public void printSummary() {
        System.out.println("[강의] #" + getId() + " " + getTitle() + " - " + getMinutes()
                + "분 - 강사: " + instructorName);
    }

    @Override
    public boolean needsReview() {
        return getMinutes() < 60;
    }

    // 이 메서드는 부모가 물려준 게 아니라
    private String normalizeInstructorName(String instructorName) {
        if (instructorName == null || instructorName.isBlank()) {
            return "강사 미정";
        }
        return instructorName;
    }

    public void method1() {
        System.out.println("LectureLog의 method1 호출!");
    }
}
