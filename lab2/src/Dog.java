public class Dog extends Animal {
    String dogName;
    String dogFurColor;

    public Dog(String food, String location, String dogName, String dogFurColor){
        super(food, location);
    }
    public static void makeNoise() {
        System.out.println("this dog barks");
    }
    public static void eat() {
        System.out.println("this dog eats dog food");
    }
}