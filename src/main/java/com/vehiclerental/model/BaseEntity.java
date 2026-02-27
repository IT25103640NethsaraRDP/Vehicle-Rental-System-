package com.vehiclerental.model;

/**
 * BaseEntity - the root parent class for ALL models in this system.
 *
 * OOP CONCEPTS DEMONSTRATED:
 * - Abstraction: abstract class that cannot be instantiated directly
 * - Inheritance: every model class (Vehicle, Customer, etc.) extends this
 * - Encapsulation: private field with getter/setter
 *
 * Every model class MUST extend this.
 * Example: public class Vehicle extends BaseEntity { ... }
 */
public abstract class BaseEntity {

    private String id;

    public BaseEntity(String id) {
        this.id = id;
    }

    // Abstract method — every entity must be able to convert itself to a CSV line
    // This is used when saving to .txt files
    public abstract String toCsvLine();

    // Getter and Setter (Encapsulation)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
