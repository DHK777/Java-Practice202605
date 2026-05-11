package oop.enum_exception.domain;

import oop.enum_exception.exception.InvalidActivityException;

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
        validateTitle(title);
        validateMinutes(minutes);
        totalCreatCount++;
        this.id = totalCreatCount;
        this.title = title.trim(); // 좌우 공백 제거
        this.minutes = minutes;
        this.visibility = visibility;
        this.category = category;
    }

    public static int getTotalCreatedCount() {
        return totalCreatCount;
    }

    public void setMinutes(int minutes) {
        if (minutes <= 0) {
            throw new InvalidActivityException(
                    "추가 학습 시간은 1분 이상이어야 합니다. 입력값: " + minutes);
        }
        this.minutes += minutes;
    }

    public void changeTitle(String newTitle) {
        validateTitle(newTitle);
        this.title = newTitle;;
    }

    private void validateTitle(String newTitle) {
        if (newTitle == null || newTitle.isBlank()) {
            throw new InvalidActivityException("합습 제목은 비워둘 수 없습니다.");
        }
    }

    private void validateMinutes(int newMinutes) {
        if (newMinutes <= 0) {
            throw new InvalidActivityException("학습 시간은 1분 이상이여야 합니다." + newMinutes);
        }
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
