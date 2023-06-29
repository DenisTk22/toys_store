import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;

public class Processor {
    String resultFile = "result.txt";
    private static ArrayList<Toy> toys = new ArrayList<>();
    private static PriorityQueue<Toy> prizes = new PriorityQueue<>();
    private static int idCount = 1;
    private static int noNameCount = 1;

    public void addToy() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print("Type a Name or press Enter to set default Name - Toy: ");
            String name = scan.nextLine();
            if (name.isEmpty()) {
                name = "Toy" + noNameCount;
                noNameCount +=1;
            }
            System.out.print("Enter a weight (positive number > 0): ");
            String setWeight = scan.nextLine();
            if (isDigit(setWeight)) {
                int weight = Integer.parseInt(setWeight);
                if (weight <= 0) {
                    System.out.println("Input a positive number > 0! Try again!\n");
                }
                else {
                    Toy toy = new Toy(idCount, name, weight);
                    if (!toys.contains(toy)) { //if (!toys.contains(toy) || toys.size() == 0)

                        toys.add(toy);
                        System.out.println("The toy is added");
                        idCount++;
                    } else {
                        System.out.println("The toy already exist.");
                    }
                }
            } else {
                System.out.println("Input a digit!");
            }
            break;
        }
    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public Toy getPrize() {
        if (prizes.size() == 0) {
            Random rnd = new Random();
            for (Toy toy : toys) {
                for (int i = 0; i < toy.getWeight(); i++) {
                    Toy temp = new Toy(toy.getId(), toy.getName(), rnd.nextInt(1, 10));
                    prizes.add(temp);
                }
            }
        }
        return prizes.poll();
    }

    public void lottery() {
        if (toys.size() > 1) {
            Toy prize = getPrize();
            System.out.println("Prize: " + prize.getName());
            saveResult(prize.getInfo());
        } else {
            System.out.println("Please add more toys.\n");
        }
    }

    public void ten_times_lottery() {
        for (int i = 0; i < 10; i++) {
            lottery();
        }
    }

    private void saveResult(String text) {
        File file = new File(resultFile);
        try {
            file.createNewFile();
        } catch (Exception ignored) {
            throw new RuntimeException();
        }
        try (FileWriter fw = new FileWriter(resultFile, true)) {
            fw.write(text + "\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}