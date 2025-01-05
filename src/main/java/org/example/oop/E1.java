package org.example;

// Main class to demonstrate polymorphism
public class E1 {
    public static void main(String[] args) {
        // Create objects using a factory method
        Shape rectangle = new Rectangle();
        Shape triangle = new Triangle();
        Shape square = new Square();
        Toy yoyo = new Yoyo();

        // Print shapes
        printObject(rectangle);
        printObject(triangle);
        printObject(square);

        // Print toy
        printObject(yoyo);
    }

    /**
     * Generic method to handle all objects that implement Parent.
     *
     * @param parent An object implementing the Parent interface
     */
    public static void printObject(Parent parent) {
        parent.draw();
    }
}

// Base interface for drawable objects
interface Parent {
    void draw();
}

// Interface representing a shape
interface Shape extends Parent {
}

// Interface representing a toy
interface Toy extends Parent {
}

// Rectangle implementation of Shape
class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}

// Triangle implementation of Shape
class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Triangle");
    }
}

// Square implementation of Shape
class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Square");
    }
}

// Yoyo implementation of Toy
class Yoyo implements Toy {
    @Override
    public void draw() {
        System.out.println("Playing with Yoyo");
    }
}
