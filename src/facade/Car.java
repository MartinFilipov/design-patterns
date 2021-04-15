package facade;

import observer.ObservableVehicle;
import observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Car implements ObservableVehicle {

    private List<Observer> observers;
    private int topSpeed;
    private String color;
    private boolean hasTurbo;

    public Car(int topSpeed, String color, boolean hasTurbo) {
        this.topSpeed = topSpeed;
        this.color = color;
        this.hasTurbo = hasTurbo;
        this.observers = new ArrayList<>();
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isHasTurbo() {
        return hasTurbo;
    }

    public void setHasTurbo(boolean hasTurbo) {
        this.hasTurbo = hasTurbo;
    }

    @Override
    public String toString() {
        return "Car{" +
                "topSpeed=" + topSpeed +
                ", color='" + color + '\'' +
                ", hasTurbo=" + hasTurbo +
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
        return "Car";
    }
}
