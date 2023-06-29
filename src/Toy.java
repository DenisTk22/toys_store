public class Toy implements Comparable<Toy> {

    private int Id;
    private String Name;
    private int weight;

    public Toy(int Id, String Name, int weight) {
        this.Id = Id;
        this.Name = Name;
        this.weight = weight;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public int getWeight() {
        return weight;
    }

    public String getInfo() {
        return String.format("Id: %d, Name: %s", Id, Name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Toy toy = (Toy) o;
        return Name.equals(toy.Name);
    }

    @Override
    public int compareTo(Toy o) {
        return Integer.compare(this.weight, o.weight);
    }
}
