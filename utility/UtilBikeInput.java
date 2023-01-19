package bbm.utility;

import bbm.model.bike.BikeTypes;
import bbm.model.bike.EBike;
import bbm.model.bike.MBike;

import java.util.Scanner;

public final class UtilBikeInput {

    Scanner sc = new Scanner(System.in);
    private int topSpeed, groundClearance, wheelBase, maxTorque, price;
    private String bikeModel, bodyType, instrumentConsole, seatType;

    public static int getBikeId() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter bike Id:");
        return sc.nextInt();
    }

    private void getBikeDetails() {
        System.out.println("Enter Bike Model \t:");
        bikeModel = sc.next();
        System.out.println("Enter Top Speed \t:");
        topSpeed = sc.nextInt();
        System.out.println("Enter Ground Clearance \t:");
        groundClearance = sc.nextInt();
        System.out.println("Enter Wheel Base \t:");
        wheelBase = sc.nextInt();
        System.out.println("Enter Max Torque \t:");
        maxTorque = sc.nextInt();
        System.out.println("Enter Prize \t:");
        price = sc.nextInt();
        System.out.println("Enter Body Type \t:");
        bodyType = sc.next();
        System.out.println("Enter InstrumentConsole \t:");
        instrumentConsole = sc.next();
        System.out.println("Enter seatType \t:");
        seatType = sc.next();
    }

    public MBike getMBikeDetails() {
        getBikeDetails();
        System.out.println("Enter Mileage \t:");
        int mileage = sc.nextInt();
        System.out.println("Enter No Of Cylinder \t:");
        int noOfCylinders = sc.nextInt();
        System.out.println("Enter Engine Capacity \t:");
        String engineType = sc.next();
        System.out.println("Enter Displacement \t:");
        String displacement = sc.next();
        System.out.println("Enter Cooling System \t:");
        String coolingSystem = sc.next();
        System.out.println("Enter Fuel Supply \t:");
        String fuelSupply = sc.next();
        System.out.println("Enter Gear Box \t:");
        String gearBox = sc.next();
        return new MBike(topSpeed, groundClearance, wheelBase, maxTorque, price, bikeModel, bodyType, instrumentConsole, seatType, mileage, noOfCylinders, engineType, displacement, coolingSystem, fuelSupply, gearBox);
    }

    public EBike getEBikeDetails() {
        getBikeDetails();
        System.out.println("Enter Range Eco \t:");
        int rangeEco = sc.nextInt();
        System.out.println("Enter Range Normal \t:");
        int rangeNormal = sc.nextInt();
        System.out.println("Enter Range Sport \t:");
        int rangeSport = sc.nextInt();
        System.out.println("Enter Motor Power \t:");
        int motorPower = sc.nextInt();
        System.out.println("Enter Charge Time \t:");
        int chargeTime = sc.nextInt();
        return new EBike(topSpeed, groundClearance, wheelBase, maxTorque, price, bikeModel, bodyType, instrumentConsole, seatType, rangeEco, rangeNormal, rangeSport, motorPower, chargeTime);
    }

    public static BikeTypes getBikeType() {
        Scanner sc = new Scanner(System.in);
        for (BikeTypes bikeTypes : BikeTypes.values())
            System.out.println(bikeTypes.ordinal() + 1 + " " + bikeTypes);
        int a = sc.nextInt();
        return BikeTypes.values()[a - 1];
    }
}

