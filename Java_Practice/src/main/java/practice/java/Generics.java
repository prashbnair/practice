package practice.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generics {

    // If you use collections without generics it is called a raw type.

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(4, 5, 6));

//        copy(list1, list2);
        copyAllBut(list1, list2, 5);

        list1.forEach(System.out::println);
    }

    /*
    T is a parameterized type parameter. It is required because if there was no such declaration, then T
    would be assumed to be a type which means that a class of type T would need to exist.
     */
    static <T> void  copy(List<T> dest, List<T> src) {
        src.forEach(dest::add);

        // You cannot create an instance of the parameterized type. This is because of type erasure which does not
        // store any of this information in the byte code. This is to ensure backward compatibility. This means that
        // a class compiled in java 6 or 7 can run in java 8. This means that java 8 allows earlier versions of code
        // to run on it which is backward compatible.
        // Java does not implement reification which means storing the generic information in class files.

        // The following statement will not be allowed because java does not know the type and therefore uses Object.
        // T t = new T();
    }

    /*
    The parameterized type T by default extends Object class. If we need to use specific methods, we need to
    give it a type. In this case, we are saying that T can be any class that implements the Comparable interface.
     */
    static <T extends Comparable> void  copyAllBut(List<T> dest, List<T> src, T exclude) {
        for(T t : src) {
            if (t.compareTo(exclude) != 0 )
                dest.add(t);
        }
    }


}
