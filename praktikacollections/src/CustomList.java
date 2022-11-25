import java.util.LinkedList;

public class CustomList<T> extends LinkedList<T> {
    public boolean add(T obj) {
        super.add(obj);
        return true;
    }

    public int size(CustomList<T> list){
        return size(list);
    }
    
    public boolean remove(Object obj) {
        return super.remove(obj);
    }
    
    public T remove(int index) {
        return super.remove(index);
    }

    public void clear(){
        super.clear();
    }
}