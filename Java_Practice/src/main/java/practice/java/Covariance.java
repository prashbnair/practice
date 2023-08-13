package practice.java;

import java.util.ArrayList;
import java.util.List;

// Covariance is the ability to use a derived class in place of the base class. Languages that allow
// covariance then allow polymorphism
// class Fruit
// class Banana extends Fruit
// class Orange extends Fruit
// accept(Fruit fruit) - it will accept a Banana and Orange, this is known as covariance.

// Derived extends from Base
// Generic of Derived *does not* extend from Generic of Base
// Derived is covariant to Base
// Generic of Derived is *not* covariant to Generic of Base


public class Covariance {

    List<Fruit> l = new ArrayList<>();



    public  void main(String[] args) {
        List<Banana> bananas = new ArrayList<>();
        Fruit f = new Fruit();
        l.add(f);
//        This is not allowed because covariance is not allowed for generic typed
//        f.addFruit(bananas);

    }

    // Can add to the to list because it a takes in a list parameter that contains the super
    // type of the parameterized type
    static <T> void copy(List<T> from, List<? super T> to){
        from.forEach(v -> to.add(v));
    }

    static void copyTo(List<Banana> from, List<Fruit> to){
        from.forEach(v -> to.add(v));
    }

//    src list can point to any list that contains elements of type that are a subtype of T
//    dest lst can point to any list that contains elements of type that are a supertype of T
//    Elements of subtype T cannot be added to the src because they could be of any of the subtypes of T.
    // for example we could pass in a list of Integer or double into this and update them with either values
    // Elements
    private <T> void addToList(List<? super T> dst, List<? extends T> src) {
        src.forEach(dst::add);

    }
}

class Fruit {
    void addFruit(List<Fruit> fruitBasket){

    }
}

class Banana extends Fruit {

}

class Orange extends Fruit {

}
