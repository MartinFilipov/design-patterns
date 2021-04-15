package main;

import singleton.VehicleShow;
import observer.VehicleManufacturer;

public class Main {

    public static void main(String[] args) {
        VehicleShow vehicleShow = VehicleShow.getVehicleShow();
        VehicleManufacturer audi = new VehicleManufacturer("Audi");
        VehicleManufacturer ford = new VehicleManufacturer("Ford");
        VehicleManufacturer subaru = new VehicleManufacturer("Subaru");

        vehicleShow.addCarManufacturer(audi);
        vehicleShow.addTruckManufacturer(ford);
        vehicleShow.addATVManufacturer(subaru);

        vehicleShow.showCar();
        vehicleShow.showTruck();

    }
}
