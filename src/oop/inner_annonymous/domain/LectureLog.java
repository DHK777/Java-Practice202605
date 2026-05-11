package oop.inner_annonymous.domain;

import oop.inner_annonymous.policy.Reviewable;
import oop.inner_annonymous.policy.Shareable;

// LectureLog는 LearningActivity의 한 종류이고, Reviewable에 선언된 역할도 수행할 수 있다.
public class LectureLog extends LearningActivity implements Reviewable, Shareable {

    private String instructorName;

    public LectureLog(String title, int minutes, Visibility visibility, String instructorName) {
        super(title, minutes, visibility, ActivityCategory.LECTURE);
        this.instructorName = normalizeInstructorName(instructorName);
    }


    @Override
    public boolean needsReview() {
        return getCategory().isShortStudy(getMinutes());
    }

    @Override
    public void printReviewTarget() {
        System.out.println("[복습 권장]: " + getTitle() + " (" + getMinutes() + "분");
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

    @Override
    public boolean canShare() {
        return isPublicActivity();
    }

    @Override
    public String getShareTitle() {
        return getTitle();
    }

    @Override
    public String getAcivityType() {
        return "강의";
    }

    @Override
    public String getDetailText() {
        return "강사";
    }
}
