package org.example;

import java.util.ArrayList;
import java.util.List;

public class CatOwner {

    private final List<Cat> cats = new ArrayList<>();

    public void addCat(Cat cat) {
        cats.add(cat);
    }

    public boolean removeCat(String name) {
        return cats.removeIf(cat -> cat.getName().equals(name));
    }

    public Cat findCatByName(String name) {
        return cats.stream()
                .filter(cat -> cat.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return "Cat owner has{" + cats + '}';
    }


}
