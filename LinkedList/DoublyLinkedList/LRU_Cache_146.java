package LinkedList.DoublyLinkedList;

import java.util.HashMap;
import java.util.Map;

public class LRU_Cache_146 {
    public static void main(String[] args) {
        System.out.println("146. LRU Cache");
        int capacity = 3;
        LRUCache obj = new LRUCache(capacity);
        obj.put(1, 10);
        obj.put(3, 15);
        obj.put(2, 10);
        obj.get(3);
        obj.put(4, 20);
        obj.get(2);
        obj.put(4, 25);
        obj.get(6);
    }

    static class LRUCache {
        Node head = new Node(0,0), tail = new Node(0,0);
        Map<Integer, Node> map = new HashMap<>();
        int capacity;

        class Node
        {
            Node next, prev;
            int key, value;
            public Node(int _key, int _value)
            {
                key = _key;
                value = _value;
            }
        }

        public LRUCache(int _capacity) {
            capacity = _capacity;
            head.next = tail;
            tail.prev = head;
        }

        public void insert(Node node)
        {
            map.put(node.key, node);
            Node headNext = head.next;
            node.prev = head;
            head.next = node;
            node.next = headNext;
            headNext.prev = node;
        }

        public void remove(Node node)
        {
            map.remove(node.key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        
        public int get(int key) {
            if (map.containsKey(key))
            {
                Node node = map.get(key);
                remove(node);
                insert(node);
                return node.value;
            }
            else
                return -1;
        }
        
        public void put(int key, int value) {
            if (map.containsKey(key))
            {
                remove(map.get(key));
            }
            if (map.size() == capacity)
            {
                remove(tail.prev);
            }

            insert(new Node(key, value));
        }
    }
}
