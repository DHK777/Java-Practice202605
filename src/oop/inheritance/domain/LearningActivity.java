package oop.inheritance.domain;

public class LearningActivity {

    private static final int REVIEW_THRESHOLD_MINUTES = 60;
    private static int totalCreatCount = 0;

    private final long id;
    private String title;
    private int minutes;
    private boolean publicActivity;

//    LearningActivity() {
//        System.out.println("기본 생성자 호출!");
//        totalCreatCount++;
//        this.id = totalCreatCount;
//    }

    public LearningActivity(String title, int minutes) {
        this(title, minutes, true);
    }

    public LearningActivity(String title, int minutes, boolean publicActivity) {
        totalCreatCount++;
        this.id = totalCreatCount;
        this.title = normalizeTitle(title);
        this.minutes = minutes;
        this.publicActivity = publicActivity;
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
        this.publicActivity = true;
    }

    public void hideFormPublic() {
        this.publicActivity = false;
    }

    public void printSummary() {
        String visibility = publicActivity ? "공개" : "비공개";
        System.out.println("#" + id + ". " + title + " - " + minutes + "분 - " + visibility);
    }

    public boolean needsReview() {
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

    public boolean ispublicActivity() {
        return publicActivity;
    }

    protected long getId() {
        return id;
    }
}
