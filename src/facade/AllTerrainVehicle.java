package facade;

import observer.Observable;
import observer.ObservableVehicle;
import observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class AllTerrainVehicle implements ObservableVehicle {

    private List<Observer> observers;
    private int topSpeed;
    private String model;
    private String color;

    public AllTerrainVehicle(int topSpeed, String model, String color) {
        this.topSpeed = topSpeed;
        this.model = model;
        this.color = color;
        this.observers = new ArrayList<>();
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "AllTerrainVehicle{" +
                "topSpeed=" + topSpeed +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public void listInfo() {
        System.out.println(this.toString());
        notifyObservers();
    }

    @Override
    public void subscribe(Observer observer) {
        this.observers.add(observer);
        observer.setVehicle(this);
    }

    @Override
    public void unsubscribe(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer: this.observers) {
            observer.update();
        }
    }

    @Override
    public String getName() {
        return "All-Terrain Vehicle";
    }
}
