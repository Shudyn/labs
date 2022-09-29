public class SportCar extends Car {
    
    public void start(){
        System.out.println("Sportcar drives");
    }

    public void stop(){
        System.out.println("Sportcar stops");
    }

    public void printInfo(){
        System.out.println("Model: " + this.carModel + " Class: " + this.carClass + " Weight: " + this.carWeight 
            + " Engine power: " + this.engine.power + " Engine producer: " + this.engine.producer);
    }
}