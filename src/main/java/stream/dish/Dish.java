package stream.dish;

public class Dish {
    private String name;
    private boolean vegeterian;
    private int calories;
    private String type;

    public Dish() {}
    public Dish(String name, boolean vegeterian, int calories, String type) {
        this.name = name;
        this.vegeterian = vegeterian;
        this.calories = calories;
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public boolean isVegeterian() {
        return vegeterian;
    }
    public int getCalories() {
        return calories;
    }
    public String getType() {
        return type;
    }
    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", vegeterian=" + vegeterian +
                ", calories=" + calories +
                ", type='" + type + '\'' +
                '}';
    }
}
