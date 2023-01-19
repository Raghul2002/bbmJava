package bbm.application;

import bbm.BikeTypes;
import bbm.SalesRecord.SalesRecord;

public interface customerAccess {
    void viewAvailableBike();
    boolean addOrderDetails(SalesRecord salesRecord, BikeTypes bikeType);
    boolean compareBike(BikeTypes bikeType, int bikeId1, int bikeId2);
}
