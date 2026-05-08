package oop.abstract_interface.domain;

import oop.abstract_interface.policy.Reviewable;
import oop.abstract_interface.policy.Shareable;

public class PracticeLog extends LearningActivity implements Reviewable, Shareable {

    private int completionRate;

    public PracticeLog(String title, int minutes, boolean publicActivity, int completionRate) {
        super(title, minutes, publicActivity);
        this.completionRate = completionRate;
    }

    @Override
    public void printSummary() {
        System.out.println("[실습] #" + getId() + " " + getTitle() + " - " + getMinutes()
                + "분 - 완료율: " + completionRate);
    }

    @Override
    public boolean needsReview() {
        return getMinutes() < 60 || completionRate < 70;
    }

    @Override
    public void printReviewTarget() {
        printSummary();
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
        return ispublicActivity();
    }

    @Override
    public String getShareTitle() {
        return getTitle();
    }
}
