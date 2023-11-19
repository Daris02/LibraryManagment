package com.prog.model;

public class Subscriber extends User{
    private String reference;

    public Subscriber(String id, String name, String reference) {
        super(id, name);
        this.reference = reference;
    }

    public Subscriber(String name, String reference) {
        super(name);
        this.reference = reference;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return "\nSubscriber{" +
                "\n\tid='" + getId() + '\'' +
                ", \n\tname='" + getName() + '\'' +
                ", \n\treference='" + reference + '\'' +
                "\n}";
    }
}
