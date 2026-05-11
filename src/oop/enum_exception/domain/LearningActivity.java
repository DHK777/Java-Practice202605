package oop.enum_exception.domain;

public abstract class LearningActivity {

    private static int totalCreatCount = 0;

    private final long id;
    private String title;
    private int minutes;
    private Visibility visibility;
    private final ActivityCategory category;

//    LearningActivity() {
//        System.out.println("기본 생성자 호출!");
//        totalCreatCount++;
//        this.id = totalCreatCount;
//    }

//    public LearningActivity(String title, int minutes) {
//        this(title, minutes, Visibility.PUBLIC);
//    }

    public LearningActivity(String title, int minutes, Visibility visibility, ActivityCategory category) {
        totalCreatCount++;
        this.id = totalCreatCount;
        this.title = normalizeTitle(title);
        this.minutes = minutes;
        this.visibility = visibility;
        this.category = category;
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
        this.visibility = Visibility.PUBLIC;
    }

    public void hideFormPublic() {
        this.visibility = Visibility.PRIVATE;
    }

    public abstract String getAcivityType();
    public abstract String getDetailText();

    public static int getTotalCreatCount() {
        return totalCreatCount;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getMinutes() {
        return minutes;
    }

    // 추상메서드는 메서드 바디가 없는 메서드의 틀 역할을 합니다.
    // 특정 메서드는 부모가 대충 정해버리는 것보다, 자식이 반드시 자기 방식대로 구현하게 하는 편이 명확할 때가 있습니다.
    //
    public Visibility getvisibility() {
        return visibility;
    }

    public String getVisibilityText() {
        return this.visibility.getLabel();
    }

    public String getActivityType() {
        return "강의";
    }

    public boolean isPublicActivity() {
        return visibility == Visibility.PUBLIC;
    }

    public ActivityCategory getCategory() {
        return category;
    }
}
