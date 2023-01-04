package bbm.model.bike;

public class MBike extends Bike {
    private final int mileage, noOfCylinders;
    private final String engineType, displacement, coolingSystem, fuelSupply, gearBox;

    public MBike(int topSpeed, int groundClearance, int wheelBase, int maxTorque, int price, String bikeModel, String bodyType, String instrumentConsole, String seatType, int mileage, int noOfCylinders, String engineType, String displacement, String coolingSystem, String fuelSupply, String gearBox) {
        super(topSpeed, groundClearance, wheelBase, maxTorque, price, bikeModel, bodyType, instrumentConsole, seatType);
        this.mileage = mileage;
        this.noOfCylinders = noOfCylinders;
        this.engineType = engineType;
        this.displacement = displacement;
        this.coolingSystem = coolingSystem;
        this.fuelSupply = fuelSupply;
        this.gearBox = gearBox;
    }

    public int getMileage() {
        return mileage;
    }

    public int getNoOfCylinders() {
        return noOfCylinders;
    }

    public String getEngineType() {
        return engineType;
    }

    public String getDisplacement() {
        return displacement;
    }

    public String getCoolingSystem() {
        return coolingSystem;
    }

    public String getFuelSupply() {
        return fuelSupply;
    }

    public String getGearBox() {
        return gearBox;
    }

}
