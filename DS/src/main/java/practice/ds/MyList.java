package practice.ds;

import java.util.ArrayList;
import java.util.List;

public class MyList<T> {
    private List<T> list;

    public MyList() {
        list = new ArrayList<>();
    }
    public void add(T t){
        list.add(t);
    }

    public <E extends T> void anotherType(E e) {

    }
}
