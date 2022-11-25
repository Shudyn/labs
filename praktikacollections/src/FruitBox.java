public class FruitBox {

    String fruitType;
    CustomList<Fruit> box;
    
    public FruitBox(){
        this.box = new CustomList<Fruit>();
    }

    public boolean addFruit(Fruit fruit) {
        if (this.box.size() == 0){
            box.add(fruit);
            this.fruitType = fruit.name;
            return true; //succeded
        }
        else if (this.fruitType.equals(fruit.name)){
            box.add(fruit);
            return true; //succeded
        }
        else {
            return false; //failed
        }
    }

    public double getWeight(){
        if (this.box.size() == 0){
            return 0;
        }
        else {
            Fruit fruit = this.box.get(0);
            double result = this.box.size() * fruit.weight;
            return result;
        }
    }

    public boolean compare(FruitBox box2){
        if(this.getWeight() == box2.getWeight()){
            return true; 
        }
        else{
            return false; 
        }
    }

    public boolean transferFruits(FruitBox toBox){
        if(this.fruitType.equals(toBox.fruitType)){
            for (Fruit fruit : this.box) {
                toBox.box.add(fruit);
            }
            this.box.clear();
            return true; //succeded
        }
        else{
            return false; //failed
        }
    }

}