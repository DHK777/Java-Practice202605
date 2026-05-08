package oop.access_modifier;

public class LearningLog {

    // 접근 제한자를 활용한 정보 은닉과 캡슐화
    // 필드에 private를 붙여서 외부에서 직접 접근하지 못하도록 막습니다.
    private String title;
    private int minutes;
    private boolean publicLog;

    LearningLog() {
        System.out.println("기본 생성자 호출!");
    }

    LearningLog(String title, int minutes) {
        this(title, minutes, true);
    }

    LearningLog(String title, int minutes, boolean publicLog) {
        this.title = normalizeTitle(title);
        this.minutes = minutes;
        this.publicLog = publicLog;
    }

    public void setMinutes(int minutes) {
        if (minutes <= 0) {
            System.out.println("학습 시간은 0보다 커야 합니다.");
            return; // void 메서드에서 return은 메서드를 강제 종료합니다.
        }
        this.minutes = minutes;
    }

    public void changeTitle(String newTitle) {
        this.title = normalizeTitle(newTitle);;
    }

    // 이 메서드는 굳이 외부에서 알 필요가 없고, 호출할 일도 없기 때문에 private으로 선언합니다.
    // 이 클래스 안에서만 사용할 수 있도록 범위를 지정
    private String normalizeTitle(String newTitle) {
        if (newTitle == null || newTitle.isBlank()) {
            return "제목 없음";
        }
        return newTitle;
    }

    public void openToPublic() {
        this.publicLog = true;
    }

    public void hideFormPublic() {
        this.publicLog = false;
    }

    void printSummary() {
        // 3항 연산식: 조건식의 결과에 따라 변수에 대입할 값을 다르게 할 수 있는 문법
        // 논리형 조건식 ? 좌항 : 우항
        // 논리형 조건식이 true라면 좌항의 값이, false라면 우항의 값이 도출됩니다.
        String visibility = publicLog ? "공개" : "비공개";
        System.out.println(title + " - " + minutes + "분 - " + visibility);
    }

    boolean needsReview() {
        return minutes < 60;
    }

    // 외부로 필드값을 돌려주는 getter 메서드
    // get + 필드이름으로 지어주는 것이 관례,
    // boolean 타입의 값을 돌려주는 getter는 is + 필드이름으로 지어주는 것이 관례입니다.
    public String getTitle() {
        return title;
    }

    public int getMinutes() {
        return minutes;
    }

    public boolean isPublicLog() {
        return publicLog;
    }
}
