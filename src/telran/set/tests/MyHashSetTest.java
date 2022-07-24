package telran.set.tests;

import org.junit.jupiter.api.Test;
import telran.set.model.ISet;
import telran.set.model.MyHashSet;

import static org.junit.jupiter.api.Assertions.*;

class MyHashSetTest {

    @Test
    void test() {
        ISet<String> mySet = new MyHashSet<>();
        System.out.println(mySet.size());

    }
}