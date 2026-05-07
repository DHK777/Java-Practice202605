import java.sql.SQLOutput;
import java.util.Scanner;

public class SprintLogApp {
    public static void main(String[] args) {

        String[] titles = {"Java 시작", "Git 복습", "조건문 학습", "반복문 학습"};
        int[] minutes = {40, 30, 75, 120};
        boolean[] publicFlags = {true, false, true, true};

        Scanner sc = new Scanner(System.in);

        // 무한 루프 while (true)
        while (true) {
            printMenu();
            int menu = sc.nextInt();
            if (menu == 1) {
                printDivider("전체");

                printTotalLogs(titles, minutes);
            } else if (menu == 2) {
                printDivider("공개");
                for (int i = 0; i < titles.length; i++) {
                    printPublicLogs(publicFlags, i, titles, minutes);
                }
            } else if (menu == 3) {
                printDivider("전체 학습 시간");
                int total = calculateTotalMinutes(minutes);
                System.out.println("전체 학습 시간: " + total + "분");
            } else if (menu == 4) {
                printReviewLogs(titles, minutes);
            } else if (menu == 5) {
                printLongStudyLogs(titles, minutes);
            } else if (menu == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }

    private static void printLongStudyLogs(String[] titles, int[] minutes) {
        printDivider("긴 학습");
        for (int i = 0; i < titles.length; i++) {
            if (minutes[i] >= 100) {
                printLogItem(i, titles, minutes);
            }
        }
    }

    private static void printReviewLogs(String[] titles, int[] minutes) {
        printDivider("복습 필요");
        for (int i = 0; i < titles.length; i++) {
            if (minutes[i] < 60) {
                printLogItem(i, titles, minutes);
            }
        }
        int total = calculateTotalMinutes(minutes);
        double avg = (double) total / minutes.length;
        System.out.println("평균 학습 시간: " + avg + "분");
    }

    private static int calculateTotalMinutes(int[] minutes) {
        int total = 0;

        for (int m : minutes) {
            total += m;
        }
        return total;
    }

    private static void printPublicLogs(boolean[] publicFlags, int i, String[] titles, int[] minutes) {
        if (!publicFlags[i]) {
            return;
        }
        printLogItem(i, titles, minutes);
    }

    private static void printTotalLogs(String[] titles, int[] minutes) {
        for (int i = 0; i < titles.length; i++) {
            printLogItem(i, titles, minutes);
        }
    }

    private static void printLogItem(int i, String[] titles, int[] minutes) {
        System.out.println((i + 1) + ". " + titles[i] + " - " + minutes[i] + "분");
    }

    static void printMenu() {
        System.out.println();
        System.out.println("==== SprintLog ====");
        System.out.println("1. 전체 기록 출력");
        System.out.println("2. 공개 기록만 출력");
        System.out.println("3. 전체 학습 시간 출력");
        System.out.println("4. 복습 필요 기록 출력");
        System.out.println("5. 긴 학습 기록 출력");
        System.out.println("0. 종료");
        System.out.print("메뉴를 선택하세요: ");
    }

    static void printDivider(String title) {
        System.out.println();
        System.out.println("========== " + title + " 기록 ==========");
    }
}
