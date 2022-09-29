public abstract class Car {

    public String carModel;
    public String carClass;
    public int carWeight;
    public Engine engine;
    
    public abstract void start();

    public abstract void stop();

    public static void turnLeft() {
        System.out.println("turn left");
    }
    public static void turnRight() {
        System.out.println("turn right");
    }

    public abstract void printInfo();
}