public class Lorry extends Car {

    public int maxCarryWeight;
    
    public void start(){
        System.out.println("Lorry drives");
    }

    public void stop(){
        System.out.println("Lorry stops");
    }

    public void printInfo(){
        System.out.println("Model: " + this.carModel + " Class: " + this.carClass + " Weight: " + this.carWeight 
            + " Engine power: " + this.engine.power + " Engine producer: " + this.engine.producer);
    }
}