package oop.access_modifier;

public class SprintLogApp {
    public static void main(String[] args) {
        LearningLog javaLog = new LearningLog("Java 시작", 40, true);
        LearningLog gitLog = new LearningLog("Git 복습", 30, false);

        javaLog.setMinutes(200);
        javaLog.changeTitle("Java 객체지향과 캡슐화");
        javaLog.hideFormPublic();

        gitLog.setMinutes(45);


        javaLog.printSummary();
    }
}

