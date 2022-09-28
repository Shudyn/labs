public class Animal {

    public String food;
    public String location;
    
    public Animal(String food, String location){
        this.food = food;
        this.location = location;
    }

    public static void makeNoise() {
        System.out.println("this animal makes noises");
    }

    public static void eat() {
        System.out.println("this animal eats");
    }
    public static void sleep() {
        System.out.println("this animal sleeps");
    }
}