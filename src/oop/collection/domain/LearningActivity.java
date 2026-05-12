package oop.collection.domain;

import oop.collection.exception.InvalidActivityException;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class LearningActivity {

    private static int totalCreatCount = 0;

    private final long id;
    private String title;
    private int minutes;
    private Visibility visibility;
    private final ActivityCategory category;
    private final Set<String> tags = new HashSet<>();

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

    /**
     * 태그를 추가한다. 공백은 제거하고, 소문자로 저장한다.
     * 중복 태그는 무시한다 (Set의 특성)
     */
    public void addTag(String tag) {
        if (tag == null || tag.isBlank()) {
            throw new InvalidActivityException("태그는 비워둘 수 없습니다.");
        }
        tags.add(tag.trim().toLowerCase());
    }

    /** 등록된 태크 목록을 읽기 전용으로 반환한다. */
    public Set<String> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * 해당 태그가 등록되어 있는지 확인한다.
     */
    public boolean hasTag(String tag) {
        if (tag == null) return false;
        return tag.contains(tag.trim().toLowerCase());
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
