import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Box<T extends Fruit> implements Iterable {
    List<T> box = new LinkedList<>();

    public <U extends T> void add(U fruit) {
        box.add(fruit);
    }

    private void add(List<? extends T> list) {
        box.addAll(list);
    }

    public int size() {
        return box.size();
    }

    public int getWeight() {
        int weight = 0;
        for (Fruit fruit : box) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public void moveToBox(Box<? extends T> boxFruits, int q) {
        if (boxFruits.size() <= q) {

            add(boxFruits.box);
            boxFruits.box.clear();
        } else {
            add(boxFruits.box.subList(0, q));
            boxFruits.box.subList(0, q).clear();
        }

    }

    @Override
    public String toString() {
        return box.toString();
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int current = 0;

            @Override
            public boolean hasNext() {
                return current < box.size();
            }

            @Override
            public T next() {
                return box.get(current++);
            }
        };
    }
}
