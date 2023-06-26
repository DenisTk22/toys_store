public class Toy {

    protected int id;
    protected String name;
    protected int weight;


    public Toy(int id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getWeight() {
        return weight;
    }
}
