package com.bridgelabz;
import java.util.ArrayList;
import java.util.Objects;
//Ability to find frequency
//of words in a sentence
//like “To be or not to be”
class HashNode<K, V> {
    K key;
    V value;
    final int hashcode;
    HashNode next;
    HashNode(K key, V value,int hashcode)
    {
        this.key = key;
        this.value = value;
        next = null;
        this.hashcode = hashcode;
    }
    HashNode(String key,Integer value,int hashcode)
    {
        this.key = (K) key;
        this.value = (V) value;
        next = null;
        this.hashcode = hashcode;
    }
}
public class Map<K,V> {
    private ArrayList<HashNode<K,V>> bucketList;
    private int numBuckets;
    private int size;
    Map() {
        bucketList = new ArrayList<>();
        numBuckets = 10;
        size = 0;

        for(int i=0;i<10;i++)
        {
            bucketList.add(null);
        }
    }
    public final int hashcode(K key)
    {
        return Objects.hashCode(key);
    }
    public int getBucketIndex(K key)
    {
        int index = hashcode(key) % numBuckets;
        index = index < 0 ? index * -1 : index;
        return index;
    }
    public void add(K key, V value)
    {
        HashNode<K,V> newNode = new HashNode(key, value, hashcode(key));
        int index = getBucketIndex(key);
        HashNode head = bucketList.get(index);
        if(head == null)
        {
            bucketList.set(index, newNode);
            return;
        }
        HashNode tempNode = head;
        while(tempNode != null)
        {
            if(tempNode.key.equals(key))
            {
                tempNode.value = ((Integer)tempNode.value) + (Integer)value;
                return;
            }
            tempNode = tempNode.next;
        }
        newNode.next = head;
        bucketList.set(index, newNode);
    }
    public void display()
    {
        for(HashNode<K,V> item : bucketList)
        {
            if(item == null)
                continue;
            else
            {    while(item != null)
    {
        System.out.println("word =>" + item.key + ",  frequency => "+item.value);
        item = item.next;
    }
}
        }
                System.out.println();
                }
       public static void main(String[] args) {
        Map<String, Integer> map = new Map();
        String s = "To be or not to be";
        String[] arr = s.split(" ");
        for (String value : arr) {
        map.add(value, 1);
        }
        System.out.println("Frequency of words in: To be or not to be");
        map.display();
        }
        }