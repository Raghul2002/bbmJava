package bbm.bikeManager;

import bbm.SalesRecord.SalesRecord;
import bbm.model.account.Manager;
import bbm.model.bike.Bike;
import bbm.model.bike.BikeStatus;

public interface BikeManager<B extends Bike> {
    void addBike(B bike, Manager manager);
    boolean removeBike(int bikeId,Manager manager);
    void viewBike(BikeStatus bikeStatus);
    void compareBike(int bikeId1,int bikeId2);
    boolean addOrderDetails(SalesRecord salesRecord);
}
