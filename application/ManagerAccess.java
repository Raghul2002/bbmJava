package bbm.application;

import bbm.SalesRecord.SalesRecord;
import bbm.model.account.Manager;
import bbm.model.bike.EBike;
import bbm.model.bike.MBike;

import java.util.List;

public interface ManagerAccess {
    List<MBike> getAvailableMBike();

    List<EBike> getAvailableEBike();
    void addBike(EBike bike, Manager manager);
    void addBike(MBike bike, Manager manager);
    boolean removeMBike(int bikeId, Manager manager);
    boolean removeEBike(int bikeId, Manager manager);
    List<SalesRecord> getSoldDetails();
    List<MBike> getSoldMBike();

    List<EBike> getSoldEBike();
}
