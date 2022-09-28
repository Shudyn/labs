public class Phone {

    public int number;
    public int model;
    public int weight;
    
    public Phone(int number, int model){
        this.number = number;
        this.model = model;
    }

    public Phone(int number, int model, int weight){
        this(13, 5);
    }
    
    public Phone(){
    }
    public void receiveCall(String caller) {
        System.out.println(caller + " calls");
    }

    public void receiveCall(String caller, int number) {
        System.out.println(caller + " calls from " + number);
    }
    public static void sendMessage(Phone[] phones) {
        for (Phone phone : phones) {
            System.out.println(phone.number);
        }
    }
    public int getNumber() {
        return this.number;
    }
}