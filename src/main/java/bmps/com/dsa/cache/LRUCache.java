package bmps.com.dsa.cache;

import java.util.*;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LRUCache<K, V> implements Cache<K, V> {

    private final int capacity;
    private final Map<K, V> cache;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();


    public LRUCache(int size) {
        this.capacity = size;

        this.cache= new LinkedHashMap<>(this.capacity, 0.75f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return this.size() > capacity;
            }
        };
    }

    @Override
    public boolean put(K key, V value) {
        lock.writeLock().lock();
        boolean containsKey;
        try{
            cache.put(key, value);
        } finally {
            containsKey = cache.containsKey(key);
            lock.writeLock().unlock();
        }

        return containsKey;
    }

    @Override
    public Optional<V> get(K key) {
        lock.readLock().lock();
        try {
            if (!cache.containsKey(key)) {
                return Optional.empty();
            }
            return Optional.of(cache.get(key));
        }
        finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public int size() {
        return this.capacity;
    }

    @Override
    public boolean isEmpty() {
        return this.cache.isEmpty();
    }

    @Override
    public void clear() {
        lock.writeLock().lock();
        try {
            this.cache.clear();
        } finally {
            lock.writeLock().unlock();
        }
    }
}
