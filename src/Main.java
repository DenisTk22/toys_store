/*
Необходимо написать проект, для розыгрыша в магазине игрушек. Функционал
должен содержать добавление новых игрушек и задания веса для выпадения
игрушек.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Processor proce = new Processor();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("""
                    Shop of toys (choose a digit):
                    1 : Add a new toy
                    2 : Start a lottery
                    3 : 10 times lottery!!!
                    4 : Exit
                    >\s""");
            var selection = sc.next();
            switch (selection) {
                case "1" -> proce.addToy();
                case "2" -> proce.lottery();
                case "3" -> proce.ten_times_lottery();
                case "4" -> {
                    System.exit(0);
                }
                default -> System.out.println("Incorrect selection. Try again.");
            }
        }
    }
}
