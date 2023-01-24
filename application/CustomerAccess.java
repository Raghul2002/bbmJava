package bbm.application;

import bbm.model.bike.Bike;
import bbm.model.bike.BikeTypes;
import bbm.SalesRecord.SalesRecord;
import bbm.model.bike.EBike;
import bbm.model.bike.MBike;

import java.util.List;

public interface CustomerAccess {
    List<MBike> getAvailableMBike();

    List<EBike> getAvailableEBike();

    boolean addBookingOrder(SalesRecord salesRecord, BikeTypes bikeType);

    boolean compareBike(BikeTypes bikeType, int bikeId1, int bikeId2);
    List<Bike> getCustomerBike(String customerID);
}
