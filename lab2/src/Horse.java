public class Horse extends Animal {
    String horseName;
    String horseColor;

    public Horse(String food, String location, String horseName, String horseColor){
        super(food, location);
    }
    public static void makeNoise() {
        System.out.println("this horse sings");
    }
    public static void eat() {
        System.out.println("this horse eats hay");
    }
}