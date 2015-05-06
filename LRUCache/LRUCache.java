import java.util.*;

 class LRUCache1 {
    
    private LinkedList<Pair> list = new LinkedList<>();
    private Map<Integer, Pair> cache = new HashMap<>();
    private int size;
    private int cap;

    public LRUCache1(int capacity) {
        if (capacity < 1) {
            System.out.println("The capacity should larger than 0.");
        }
        cap = capacity;
    }
    
    public int get(int key) {
        Pair tmp = cache.get(key);
        if (tmp == null) {
            return -1;
        } else {
            list.remove(tmp);
            list.add(tmp);
        }
        return tmp.val;
    }
    
    public void set(int key, int value) {
        Pair tmp = cache.get(key);
        if (tmp == null) {
            if (size == cap) {
                cache.remove(list.poll().key);
                size--;
            }
            Pair p = new Pair(key, value);
            list.add(p);
            cache.put(key, p);
            size++;
        } else {
            tmp.val = value;
            list.remove(tmp);
            list.add(tmp);
        }
        
    }
    public static void main(String[] args) {
        LRUCache ca = new LRUCache(1);
        ca.set(2,5);
        ca.set(2,3);
        ca.set(6,8);
        System.out.println(ca.get(6));
        

    }
}

public class LRUCache {
    
    private Map<Integer, Pair> cache;
    private int size;
    private int cap;
    private Pair head;
    private Pair tail;

    public LRUCache(int capacity) {
        cap = capacity;
        cache = new HashMap<>();
        head = new Pair(0, 0);
        tail = new Pair(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public void remove(Pair p) {
        p.prev.next = p.next;
        p.next.prev = p.prev;
        p.next = null;
        p.prev = null;
    }

    // add a node to the head of list
    public void add(Pair p) {
        p.next = head.next;
        p.prev = head;
        p.next.prev = p;
        head.next = p;
    }

    public void update(Pair p) {
        remove(p);
        add(p);
    }

    public int get(int key) {
        Pair tmp = cache.get(key);
        if (tmp == null) {
            return -1;
        } else {
            update(tmp);
        }
        return tmp.val;
    }
    
    public void set(int key, int value) {
        Pair tmp = cache.get(key);
        if (tmp == null) {
            if (size == cap) {
                Pair oldest = tail.prev;
                remove(oldest);
                cache.remove(oldest.key);
                size--;
            }
            Pair p = new Pair(key, value);
            add(p);
            cache.put(key, p);
            size++;
        } else {
            tmp.val = value;
            update(tmp);
        }
        
    }

    public static void main(String[] args) {
        LRUCache ca = new LRUCache(1);
        ca.set(2,5);
        ca.set(2,3);
        ca.set(6,8);
        System.out.println(ca.get(2));
        

    }
}

class Pair {
    int key;
    int val;
    Pair next;
    Pair prev;

    public Pair(int k, int v) {
        key = k;
        val = v;
    }
}