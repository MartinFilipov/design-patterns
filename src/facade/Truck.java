package facade;

import observer.Observable;
import observer.ObservableVehicle;
import observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Truck implements ObservableVehicle {

    private List<Observer> observers;
    private int topSpeed;
    private int carryCapacity;
    private String color;

    public Truck(int topSpeed, int carryCapacity, String color) {
        this.topSpeed = topSpeed;
        this.carryCapacity = carryCapacity;
        this.color = color;
        this.observers = new ArrayList<>();
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public int getCarryCapacity() {
        return carryCapacity;
    }

    public void setCarryCapacity(int carryCapacity) {
        this.carryCapacity = carryCapacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "topSpeed=" + topSpeed +
                ", carryCapacity=" + carryCapacity +
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
        return "Truck";
    }
}
