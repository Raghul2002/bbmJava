package bbm.model.bike;

public class Bike {
    private static int id = 1;
    private final int bikeId, topSpeed, groundClearance, wheelBase, maxTorque, price;
    private final String bikeModel, bodyType, instrumentConsole, seatType;
    private BikeStatus availabilityStatus = BikeStatus.AVAILABLE;

    public Bike(int topSpeed, int groundClearance, int wheelBase, int maxTorque, int price, String bikeModel, String bodyType, String instrumentConsole, String seatType) {
        this.bikeId = id;
        this.topSpeed = topSpeed;
        this.groundClearance = groundClearance;
        this.wheelBase = wheelBase;
        this.maxTorque = maxTorque;
        this.price = price;
        this.bikeModel = bikeModel;
        this.bodyType = bodyType;
        this.instrumentConsole = instrumentConsole;
        this.seatType = seatType;
        id++;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public int getGroundClearance() {
        return groundClearance;
    }


    public int getWheelBase() {
        return wheelBase;
    }

    public int getMaxTorque() {
        return maxTorque;
    }

    public int getPrice() {
        return price;
    }

    public int getBikeId() {
        return bikeId;
    }

    public String getBikeModel() {
        return bikeModel;
    }

    public String getBodyType() {
        return bodyType;
    }

    public String getInstrumentConsole() {
        return instrumentConsole;
    }

    public String getSeatType() {
        return seatType;
    }
    public BikeStatus getAvailabilityStatus(){return availabilityStatus;}

    public void setAvailabilityStatus(BikeStatus availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }
}