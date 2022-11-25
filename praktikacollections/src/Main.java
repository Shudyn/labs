public class Main {
    
    public static void main(String[] args){
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Apple apple4 = new Apple();
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();

        FruitBox box1 = new FruitBox();
        FruitBox box12 = new FruitBox();
        FruitBox box2 = new FruitBox();

        //get some apples in box1 and try to put an orange in there
        System.out.println(box1.addFruit(apple1));
        System.out.println(box1.addFruit(apple2));
        System.out.println(box1.addFruit(orange1));

        for (Fruit fruit : box1.box) {
            System.out.println(fruit.name);
        }

        System.out.println(box1.getWeight());

        //put apples in box2 and transfer apples from box1 to box2
        System.out.println(box12.addFruit(apple3));
        System.out.println(box12.addFruit(apple4));

        box1.transferFruits(box12);

        System.out.println("box 1 contents");
        for (Fruit fruit : box1.box) {
            System.out.println(fruit.name);
        }

        System.out.println("box 2 contents");
        for (Fruit fruit : box12.box) {
            System.out.println(fruit.name);
        }

        //put oranges in box 3, compare with box 2
        box1.box.removeLast();
    }

    
}
