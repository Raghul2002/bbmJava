package bbm.utility;

import bbm.model.bike.EBike;
import bbm.model.bike.MBike;

import java.util.List;


public class UtilBikeView {
    private UtilBikeView(){}
    private static void mBikeHeader() {
        mBikeDivider();
        System.out.printf("|%7s |%15s |%15s |%20s |%15s |%15s |%15s |%15s |%20s |%15s |%15s |%15s |%16s |%15s |%15s |%15s |%15s |%15s |\n", "Bike Id", "BIke Model", "TopSpeed", "Ground Clearance", " WheelBase ", "MaxTorque", "Price", "Body Type", "Instrument_Console", "Seat Type", "mileage", "noOfCylinders", "Engine Type", "Displacement", "Cooling System", "Fuel Supply", "Gear Box", "Availability");
        mBikeDivider();
    }

    private static void eBikeHeader() {
        eBikeDivider();
        System.out.printf("|%7s |%15s |%15s |%20s |%15s |%15s |%15s |%15s |%20s |%15s |%15s |%15s |%15s |%15s |%15s |%15s |\n", "Bike Id", "BIke Model", "TopSpeed", "Ground_Clearance", " WheelBase ", "MaxTorque", "Price", "Body Type", "Instrument_Console", "Seat Type", "rangeEco", "rangeNormal", "rangeSport", "motorPower", "chargeTime", "Availability");
        eBikeDivider();
    }

    private static void mBikeDivider() {
        System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
    }

    private static void eBikeDivider() {
        System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
    }

    private static void printMBike(MBike mBike) {
        System.out.printf("|%7d |%15s |%15d |%20s |%15d |%15d |%15d |%15s |%20s |%15s |%15d |%15d |%16s |%15s |%15s |%15s |%15s |%15s |\n", mBike.getBikeId(), mBike.getBikeModel(), mBike.getTopSpeed(), mBike.getGroundClearance(), mBike.getWheelBase(), mBike.getMaxTorque(), mBike.getPrice(), mBike.getBodyType(), mBike.getInstrumentConsole(), mBike.getSeatType(), mBike.getMileage(), mBike.getNoOfCylinders(), mBike.getEngineType(), mBike.getDisplacement(), mBike.getCoolingSystem(), mBike.getFuelSupply(), mBike.getGearBox(), mBike.getAvailabilityStatus());
    }

    private static void printEBike(EBike eBike) {
        System.out.printf("|%7d |%15s |%15d |%20s |%15d |%15d |%15d |%15s |%20s |%15s |%15d |%15d |%15d |%15d |%15s |%15s |\n", eBike.getBikeId(), eBike.getBikeModel(), eBike.getTopSpeed(), eBike.getGroundClearance(), eBike.getWheelBase(), eBike.getMaxTorque(), eBike.getPrice(), eBike.getBodyType(), eBike.getInstrumentConsole(), eBike.getSeatType(), eBike.getRangeEco(), eBike.getRangeNormal(), eBike.getRangeSport(), eBike.getMotorPower(), eBike.getChargeTime(), eBike.getAvailabilityStatus());
    }


    public static void printMBikeList(List<MBike> mBikeList) {
        if (mBikeList.isEmpty())
            System.out.println("Sorry Currently no Mechanical bike available");
        else {
            System.out.println("Mechanical Bike :");
            mBikeHeader();
            for (MBike i : mBikeList) {
                printMBike(i);
            }
            mBikeDivider();
        }
    }

    public static void printEBikeList(List<EBike> eBikeList) {
        if (eBikeList.isEmpty())
            System.out.println("Sorry Currently no Electric bike available");
        else {
            System.out.println("\nElectric Bike :");
            eBikeHeader();
            for (EBike i : eBikeList) {
                printEBike(i);
            }
            eBikeDivider();
        }
    }
}
