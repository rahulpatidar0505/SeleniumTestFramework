package javaPrograms;

public class CollectionExample {
    /*
    * Array is fixed in size : not growable in nature
    * Only store Homogeneous data
    * no underline data structure readymade methods available (like for sorting and all)
    *
    * Group of element as a single entity : Collection
    *
    * List is an interface which extend Collection interface
    * List have it's own method + Collection interface method
    * List is growable in nature
    * Can contain Homogeneous + Hetrogeneous data
    *
    * Arraylist and Linkedlist implement List interface
    *
    * When we want more retrieval operation go for : Arraylist
    *
    * When we want more insertion & deletion operation go for : Linkedlist , in this no shifting of element,
    * will just add new Node or remove Node
    *
    * In list default location is =10
    * so when we add any element after 10th , Arraylist/Linkedlist will create new array and insert all element from
    * previos array + new element and old list will go for garbage colection
    *
    * Set is child interface of Collection interface
    * insertion order not maintain, means unordered collection
    * Duplicate values not allowed
    * internally use Hashcode concept for insertion
    *
    * search operation is very fast : Hashset
    * default location size = 16
    *
    * here as soon as it reached 75% (load factor) it will create new location and copy old values +new value
    * Load factor is very important in Hashset
    *
    * Hashset : insertion order not maintain
    * Linkedhashset : insertion order maintain
    * */
}
