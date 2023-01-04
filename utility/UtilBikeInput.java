package bbm.utility;

import bbm.enumPackage.EnumBikeTypes;
import bbm.manager.BikeManagerController;
import bbm.model.bike.EBike;
import bbm.model.bike.MBike;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UtilBikeInput {
    private UtilBikeInput(){}

    static Scanner sc = new Scanner(System.in);
    private static int topSpeed, groundClearance, wheelBase, maxTorque, price,bikeId;
    private static String bikeModel, bodyType, instrumentConsole, seatType;
    public static int getBikeId(){
        System.out.println("Enter bike Id:");
        bikeId = sc.nextInt();
        return bikeId;
    }

    private static void getBikeDetails() {
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

    public static MBike getMBikeDetails() {
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

    public static EBike getEBikeDetails() {
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
    public static List<Integer> getBikesIdToCompare(){
        BikeManagerController bikeManager = new BikeManagerController();
        Scanner sc = new Scanner(System.in);
        List<Integer> bikeDetails = new ArrayList<>();
        bikeManager.viewAvailableBike();
        System.out.println("You want to compare\n1.Mechanical Bikes\n2.Electric Bikes");
        bikeDetails.add(sc.nextInt());
        System.out.println("---------------Compare Bikes---------------");
        System.out.println("Enter Bike 1 ID:");
        bikeDetails.add(sc.nextInt());
        System.out.println("Enter Bike 2 ID:");
        bikeDetails.add(sc.nextInt());
        return bikeDetails;
    }

    public static EnumBikeTypes getBikeType() {
        for(EnumBikeTypes bikeTypes :EnumBikeTypes.values())
            System.out.println(bikeTypes.ordinal()+1+" "+bikeTypes);
        int a = sc.nextInt();
        return EnumBikeTypes.values()[a-1];
    }
}

