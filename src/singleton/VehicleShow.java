package singleton;

import facade.AllTerrainVehicle;
import facade.Car;
import facade.Truck;
import observer.ObservableVehicle;
import observer.VehicleManufacturer;

public class VehicleShow {

    private static VehicleShow vehicleShow;

    private ObservableVehicle car;
    private ObservableVehicle truck;
    private ObservableVehicle atv;

    private VehicleShow() {
        this.car = new Car(200, "blue", true);
        this.truck = new Truck(80, 1000, "green");
        this.atv = new AllTerrainVehicle(60, "Tesla model ATV", "white");
    }

    public void showCar() {
        car.listInfo();
    }

    public void showTruck() {
        truck.listInfo();
    }

    public void showATV() {
        atv.listInfo();
    }

    public void addCarManufacturer(VehicleManufacturer vehicleManufacturer) {
        car.subscribe(vehicleManufacturer);
    }

    public void addTruckManufacturer(VehicleManufacturer vehicleManufacturer) {
        truck.subscribe(vehicleManufacturer);
    }

    public void addATVManufacturer(VehicleManufacturer vehicleManufacturer) {
        atv.subscribe(vehicleManufacturer);
    }

    public static VehicleShow getVehicleShow() {
        if (vehicleShow == null){
            vehicleShow = new VehicleShow();
        }
        return vehicleShow;
    }
}
