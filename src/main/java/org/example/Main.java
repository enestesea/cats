package org.example;

public class Main {
    public static void main(String[] args) {
        CatOwner owner = new CatOwner();
        owner.addCat(new Cat("Tom", 3));
        owner.addCat(new Cat("Jerry", 2));

        System.out.println("All Cats: " + owner);

        Cat cat = owner.findCatByName("Tom");
        if (cat != null) {
            System.out.println("Found Cat: " + cat);
        }

        owner.removeCat("Jerry");
        System.out.println("After removal: " + owner);
    }
}