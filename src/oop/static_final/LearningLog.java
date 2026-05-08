package oop.static_final;

public class LearningLog {

    // final 키워드는 해당 필드가 한 번 초기화된 이후에는 값을 변경할 수 없도록 하는 역할을 합니다.
    // final 필드는 반드시 초기화되어야 하며, 초기화된 이후에는 값을 변경할 수 없습니다.
    // 이를 상수라고 합니다.

    // 싱수(constant)는 대문자로 작성하는 것이 관계
    // 상수는 고정된 불변의 값을 의미. 모든 객체가 하나의 값을 공유하며, 코드로 절대 수정하지 못하는 값
    private static final int REVIEW_THRESHOLD_MINUTES = 60;

    // 지금까지 LearningLog 객체가 몇 개 만들어졌는지 세는 변수
    private static int totalCreatCount = 0;

    private final long id;
    private String title;
    private int minutes;
    private boolean publicLog;

    LearningLog() {
        System.out.println("기본 생성자 호출!");
        totalCreatCount++;
        this.id = totalCreatCount;
    }

    LearningLog(String title, int minutes) {
        this(title, minutes, true);
    }

    LearningLog(String title, int minutes, boolean publicLog) {
        totalCreatCount++;
        this.id = totalCreatCount;
        this.title = normalizeTitle(title);
        this.minutes = minutes;
        this.publicLog = publicLog;
    }

    public void setMinutes(int minutes) {
        if (minutes <= 0) {
            System.out.println("학습 시간은 0보다 커야 합니다.");
            return;
        }
        this.minutes = minutes;
    }

    public void changeTitle(String newTitle) {
        this.title = normalizeTitle(newTitle);;
    }

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
        String visibility = publicLog ? "공개" : "비공개";
        System.out.println("#" + id + ". " + title + " - " + minutes + "분 - " + visibility);
    }

    boolean needsReview() {
        return minutes < REVIEW_THRESHOLD_MINUTES;
    }

    public static int getTotalCreatCount() {
        return totalCreatCount;
    }

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
