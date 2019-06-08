package com.ystu.web_first.Model;

public class Guitar {
    private long id;
    private String name;
    private String color;
    private double price;
    private GuitarType type;

    public Guitar(long id, String name, String color, double price, GuitarType type) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.price = price;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public GuitarType getType() {
        return type;
    }

    public void setType(GuitarType type) {
        this.type = type;
    }
}
