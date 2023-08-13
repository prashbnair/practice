package practice.ds;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LRUCacheTest {

    @Test
    public void addToCache(){
        LRUCache<String, String> cache = new LRUCache<>(3);
        assertEquals(0, cache.size());

        cache.set("H", "Hello");
        assertEquals(1, cache.size());

        cache.set("P", "Prashant");
        cache.set("D", "Darsana");

        assertEquals(3, cache.size());

        cache.set("H", "Delhi");

        assertEquals(3, cache.size());

        cache.set("F", "Delhi");

        assertEquals(Optional.empty(), cache.get("P"));
        assertEquals("Delhi", cache.get("H").get());
        assertEquals("Delhi", cache.get("F").get());


    }
}
