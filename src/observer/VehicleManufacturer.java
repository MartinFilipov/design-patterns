package observer;

public class VehicleManufacturer implements Observer {

    private String companyName;
    private Observable vehicle;

    public VehicleManufacturer(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public void update() {
        System.out.println("Someone is interested in: " + vehicle.getName() + "! We need to manufacture more.");
    }

    @Override
    public void setVehicle(Observable vehicle) {
        this.vehicle = vehicle;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
