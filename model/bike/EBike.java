package bbm.model.bike;

public class EBike extends Bike {
    private final int rangeEco, rangeNormal, rangeSport, motorPower, chargeTime;

    public EBike(int topSpeed, int groundClearance, int wheelBase, int maxTorque, int price, String bikeModel, String bodyType, String instrumentConsole, String seatType, int rangeEco, int rangeNormal, int rangeSport, int motorPower, int chargeTime) {
        super(topSpeed, groundClearance, wheelBase, maxTorque, price, bikeModel, bodyType, instrumentConsole, seatType);
        this.rangeEco = rangeEco;
        this.rangeNormal = rangeNormal;
        this.rangeSport = rangeSport;
        this.motorPower = motorPower;
        this.chargeTime = chargeTime;
    }

    public int getRangeEco() {
        return rangeEco;
    }

    public int getRangeNormal() {
        return rangeNormal;
    }

    public int getRangeSport() {
        return rangeSport;
    }

    public int getMotorPower() {
        return motorPower;
    }

    public int getChargeTime() {
        return chargeTime;
    }

}
