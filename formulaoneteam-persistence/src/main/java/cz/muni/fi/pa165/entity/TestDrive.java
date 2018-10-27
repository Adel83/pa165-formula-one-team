package cz.muni.fi.pa165.entity;

public class TestDrive {

    private CarSetup car;
    private Driver driver;
    private String notes;

    public CarSetup getCar() {
        return car;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setCar(CarSetup car) {
        this.car = car;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    public String toString() {
        return "TestDrive{" +
                "car='" + getCar() + '\'' +
                ", driver='" + getDriver() + '\'' +
                ", notes='" + getNotes() + '\'' +
                "} " + super.toString();
    }
}
