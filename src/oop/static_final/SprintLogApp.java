package oop.static_final;

public class SprintLogApp {
    public static void main(String[] args) {
        LearningLog javaLog = new LearningLog("Java 시작", 40, true);
        LearningLog gitLog = new LearningLog("Git 복습", 30, false);
        LearningLog encapLog = new LearningLog("캡슐화 연습", 90);

        LearningLog[] logs = new LearningLog[]{javaLog, gitLog, encapLog};

        for (LearningLog log : logs) {
            log.printSummary();
        }

        System.out.println("지금까지 생성된 학습 기록 수: " + LearningLog.getTotalCreatCount());

    }
}

