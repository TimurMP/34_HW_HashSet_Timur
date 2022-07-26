package telran.set.model;

import java.util.Iterator;
import java.util.LinkedList;

public class MyHashSet<E> implements ISet<E> {
    private LinkedList<E>[] hashset;
    private int size;
    private int capacity;
    private double loadFactor;

    @SuppressWarnings("unchecked")
    public MyHashSet(int capacity, double loadFactor) {
        this.hashset = new LinkedList[capacity];
        this.capacity = capacity;
        this.loadFactor = loadFactor;
    }

    public MyHashSet(int capacity) {
        this(capacity, 0.75);
    }

    public MyHashSet() {
        this(16, 0.75);
    }

    @Override
    public boolean add(E element) {
        if (size >= capacity * loadFactor) {
            rebuildArray();
        }

        int index = getIndex(element);

        if (hashset[index] == null) {
            hashset[index] = new LinkedList<>();
        }
        if (hashset[index].contains(element)) {
            return false;
        }
        hashset[index].add(element);
        size++;
        return true;


//        if (size>= capacity * loadFactor){
//            rebuildArray();
//        }
//        int index = getIndex(element);
//        if (hashset[index] == null){
//            hashset[index] = new LinkedList<>();
//
//        }
//        if(hashset[index].contains(element)){
//            return false;
//        }
//        hashset[index].add(element);
//        size++;
//        return true;
    }

    private int getIndex(E element) {
        int hashCode = element.hashCode();
        hashCode = hashCode >= 0 ? hashCode : -hashCode;
        return hashCode % capacity;
    }

    @SuppressWarnings("unchecked")

    private void rebuildArray() {
        capacity = capacity * 2;
        LinkedList<E>[] newHashSet = new LinkedList[capacity];
        for (int i = 0; i < hashset.length; i++) {
            if (hashset[i] != null) {
                for (E e : hashset[i]) {
                    int index = getIndex(e);
                    if (newHashSet[index] == null) {
                        newHashSet[index] = new LinkedList<>();
                    }
                    newHashSet[index].add(e);
                }
            }
        }
        hashset = newHashSet;

    }

    @Override
    public boolean remove(E element) {
        int index = getIndex(element);
        if (hashset[index] == null) {
            return false;
        }
        boolean res = hashset[index].remove(element);
        if (res) {
            size--;
        }
        return res;
    }


    public void print() {
        for (int i = 0; i < hashset.length; i++) {
            System.out.println(hashset[i]);

        }
    }

    @Override
    public boolean contains(E element) {
        int index = getIndex(element);
        if (hashset[index] == null) {
            return false;
        }
        return hashset[index].contains(element);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {


        return new Iterator<E>() {
            int count = 0;
            int bucket = 0;
            E temp = null;

            int empty = empty();

            @Override
            public boolean hasNext() {
                return count < capacity;
            }


            @Override
            public E next() {
                if (hashset[count] == null || hashset[count].isEmpty()) {
                    while (hashset[count] == null || hashset[count].isEmpty()) {
                        count++;
                    }
                }

                int bSize = hashset[count].size();
                temp = hashset[count].get(bucket);
                bucket++;
                if (bucket > bSize - 1) {
                    bucket = 0;
                    count++;
                }
                if (count == empty) {
                    count = count + ((capacity) - empty);
                    return temp;
                }
                return temp;

            }

            public int empty() {
                int empty = 0;
                for (int i = hashset.length - 1; hashset[i] == null || hashset[i].isEmpty(); i--) {
                    empty = i;

                }
                return empty;

            }
        };
    }
}
