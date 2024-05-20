package com.example.todohidromiel.models;

public class HidromielRecipe {
    private double honey;
    private double water;
    private double yeast;

    public HidromielRecipe(double honey, double water, double yeast) {
        this.honey = honey;
        this.water = water;
        this.yeast = yeast;
    }

    public double getHoney() {
        return honey;
    }

    public void setHoney(double honey) {
        this.honey = honey;
    }

    public double getWater() {
        return water;
    }

    public void setWater(double water) {
        this.water = water;
    }

    public double getYeast() {
        return yeast;
    }

    public void setYeast(double yeast) {
        this.yeast = yeast;
    }
}
