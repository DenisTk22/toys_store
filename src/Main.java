/*
Необходимо написать проект, для розыгрыша в магазине игрушек. Функционал
должен содержать добавление новых игрушек и задания веса для выпадения
игрушек.
 */

import com.sun.source.util.SourcePositions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {

        List<Toy> toys = new ArrayList<>();
        PriorityQueue queueOfToys = new PriorityQueue(Comparator.comparingInt(Toy::getWeight));

        toys.add(new Toy(1, "Robot", 10));
        toys.add(new Toy(2,"Gun", 15));
        toys.add(new Toy(3,"LegoSet", 20));
        toys.add(new Toy(4,"Ball", 12));
        toys.add(new Toy(5,"PictureSet", 9));


        for (Toy toy : toys) {
            queueOfToys.add(toy);
        }
        int qSize = queueOfToys.size();

        for (int i = 0; i < qSize; i++) {
            Toy toy = (Toy) queueOfToys.poll();
            System.out.println(toy.getId() + " " + toy.getWeight() + " " + toy.getName());
        }



    }
}
