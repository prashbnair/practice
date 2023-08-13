package practice.ds;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Optional;
import java.util.Queue;

public class LRUCache<K, T> implements Cache<K, T>{

    private Queue<K> queue;
    private HashMap<K, T> map;
    private int size;

    public LRUCache(int size) {
        this.size = size;
        queue = new ArrayDeque<>(size);
        map = new HashMap<>(size);
    }

    @Override
    public boolean set(K k, T t) {
        if (map.containsKey(k)) {
            queue.remove(k);
            queue.offer(k);
            map.put(k, t);
        }
        else {
            if (queue.size() == size) {
                K key = queue.remove();
                map.remove(key);
            }
            queue.offer(k);
            map.put(k, t);
        }
        return true;
    }

    @Override
    public Optional<T> get(K k) {
        if (map.containsKey(k)) {
            queue.remove(k);
            queue.offer(k);
            return Optional.of(map.get(k));
        }

        return Optional.empty();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
