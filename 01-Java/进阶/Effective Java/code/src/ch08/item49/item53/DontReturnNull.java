package ch08.item49.item53;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DontReturnNull {

    private final List<Cheese> cheesesInStock = new ArrayList<>();

    static class Cheese {
    }

    // Optimization - avoids allocating empty collections
    public List<Cheese> getCheesesList() {
        return cheesesInStock.isEmpty() ?
                Collections.emptyList() : new ArrayList<>(cheesesInStock);
    }

    // Optimization - avoids allocating empty arrays
    private static final Cheese[] EMPTY_CHEESE_ARRAY = new Cheese[0];

    public Cheese[] getCheesesArray() {
        return cheesesInStock.toArray(EMPTY_CHEESE_ARRAY);
    }
}
