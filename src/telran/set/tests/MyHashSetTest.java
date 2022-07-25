package telran.set.tests;

import org.junit.jupiter.api.Test;
import telran.set.model.ISet;
import telran.set.model.MyHashSet;

class MyHashSetTest {

    @Test
    void test() {
        ISet<String> mySet = new MyHashSet<>();
//        System.out.println(mySet.size());
        mySet.add("Boston");
        mySet.add("Atlanta");
        mySet.add("Chicago");
        mySet.add("NY");
        mySet.add("Detroit");
//        System.out.println(mySet.size());
        mySet.add("Detroit");
//        System.out.println(mySet.size());
//        System.out.println(mySet.contains("Chicago"));
//        System.out.println(mySet.contains("Dallas"));
        mySet.add("Dallas");
        mySet.add("AAA");
        mySet.add("aaa");

//        System.out.println(mySet.contains("Dallas"));
//        System.out.println(mySet.size());
        System.out.println(mySet.remove("Dallas"));
//        System.out.println(mySet.size());
        System.out.println(mySet.remove("ddd"));
//        System.out.println(mySet.size());
//        System.out.println(mySet.contains("Dallas"));
        System.out.println("=========PRINT ARR=========");
        mySet.print();
        System.out.println("=========ITERATOR=========");

        for (String s : mySet) {
            System.out.println(s);
        }

//        String str = new String("aaa");
//        int hash = str.hashCode();
//        System.out.println(hash%16);



    }
}