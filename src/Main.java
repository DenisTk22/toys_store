/*
Необходимо написать проект, для розыгрыша в магазине игрушек. Функционал
должен содержать добавление новых игрушек и задания веса для выпадения
игрушек.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Processor shop = new Processor();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("""
                \nChoose one of the options bellow:
                Type 1 to add a new toy.
                Type 2 to start a lottery.
                Type 3 to start lottery 10 times!!!
                Type 4 to exit.
                >>>\s""");
            String selection = scanner.next();
            switch (selection) {
                case "1" -> shop.addToy();
                case "2" -> shop.lottery();
                case "3" -> shop.tenTimesLottery();
                case "4" -> {
                    return;
                }
                default -> System.out.println("Type correctly. See a menu!\n");
            }
        }
    }
}
