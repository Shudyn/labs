public class Cat extends Animal {
    String catName;
    String catFurColor;

    public Cat(String food, String location, String catName, String catFurColor){
        super(food, location);
    }
    public static void makeNoise() {
        System.out.println("this cat meows");
    }
    public static void eat() {
        System.out.println("this cat eats catfood");
    }
}