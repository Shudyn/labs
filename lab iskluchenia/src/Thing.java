public class Thing {
    String name;
    String desc;
    Integer cost;
    Integer numAvailable;

    public Thing(String nam, String des, Integer cos, Integer numAvailabl){
        name = nam;
        desc = des;
        cost = cos;
        numAvailable = numAvailabl;
    }

    public void printThing(){
        System.out.println("Name");
        System.out.println(this.name);
        System.out.println("Description");
        System.out.println(this.desc);
        System.out.println("Cost");
        System.out.println(this.cost);
        System.out.println("Available amount");
        System.out.println(this.numAvailable);
        System.out.println();
    }
}