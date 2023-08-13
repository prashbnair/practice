package practice.ds;

import java.util.Optional;

public interface Cache <K, T>{
    boolean set(K k, T t);
    Optional<T> get(K k);
    int size();
    boolean isEmpty();
}
