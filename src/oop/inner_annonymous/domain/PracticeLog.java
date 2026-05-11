package oop.inner_annonymous.domain;

import oop.inner_annonymous.policy.Reviewable;
import oop.inner_annonymous.policy.Shareable;

public class PracticeLog extends LearningActivity implements Reviewable, Shareable {

    private static final int MINIMUM_COMPLETION_RATE = 70;

    private int completionRate;

    public PracticeLog(String title, int minutes, Visibility visibility, int completionRate) {
        super(title, minutes, visibility, ActivityCategory.PRACTICE);
        this.completionRate = completionRate;
    }

    @Override
    public boolean needsReview() {
        return getCategory().isShortStudy(getMinutes()) || completionRate < MINIMUM_COMPLETION_RATE;
    }

    @Override
    public void printReviewTarget() {
        System.out.println("[복습 권장]: " + getTitle() + " (완료율: " + completionRate + "%");
    }

    public int getCompletionRate() {
        return normalizeCompletionRate(completionRate);
    }

    private int normalizeCompletionRate(int completionRate) {
        if (completionRate < 0) {
            return 0;
        } else if (completionRate > 100) {
            return 100;
        }
        return completionRate;
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
        return "실습";
    }

    @Override
    public String getDetailText() {
        return "완료율: " + completionRate + "%";
    }
}
