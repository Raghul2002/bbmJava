package bbm.manager;

import bbm.SalesRecord.SalesRecord;
import bbm.model.account.Manager;
import bbm.model.bike.EBike;
import bbm.model.bike.MBike;

import java.util.List;

public interface IManagerController {
    void addBike(MBike mBike);

    void addBike(EBike eBike);

    List<EBike> viewAvailableEBike();
    List<MBike> viewAvailableMBike();

    List<Manager> showPersonalDetails();

    boolean removeMBike(int bikeId);

    boolean removeEBike(int bikeId);
    List<SalesRecord> viewSoldDetails();
    List<MBike> viewSoldMBike();
    List<EBike> viewSoldEBike();
}
